/*
 *  Programmer: 	Kyle Neal
 *  Date Created: 	7-3-14
 *  Information:	This is the Panel where all the drawing will occur.
 *  				Tanks, missle, etc..
 *  Notes:			This panel gets all the shot information and updates all panels that indicate
 *  				health, etc. This file can be looked at as the driver for the game. Here we
 *  				check if a tank's health is at 0 or less and ends the game if so, also enables
 *  				and disables appropriate buttons.
 */

package gui;

//IMPORT FIELD
//*****************************************
import gui.comp.SliderValuePanel;
import gui.graphics.tank;
import gui.graphics.Pixel;
import gui.graphics.tank.MuzzleTip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
//*****************************************

import utilities.Coordinate;


public class PlayDrawArea extends JPanel
{
	//DATA FIELD
	//*****************************************
	private Dimension d;
	private tank tank1;
	private tank tank2;
	private LinkedList <Pixel> shot = new LinkedList<Pixel>();
	private Font hitMissFont = new Font("monospaced", Font.BOLD, 20);
	PlayerPanel p1Panel;
	PlayerPanel p2Panel;
	//*****************************************
	
	//FUNCTION FIELD
	//*****************************************
	public PlayDrawArea(Dimension d)
	{
		this.d = d;
		this.setPreferredSize(this.d);
		this.setBackground(Color.CYAN);
		this.tank1 = new tank(1, 0, d.height - 50);
		this.tank2 = new tank(2, d.width - 40, d.height - 50);
	}
	
	public void paint()
	{	
		Graphics g = getGraphics();
		
		super.paintComponent(g);

		//Draw Tank 1
		for(Pixel p : tank1.getTankPixels())
		{
			g.setColor(p.getcolor());
			g.drawRect(p.getx(), p.gety(), 1, 1);
		}
		//Draw Tank 2
		for(Pixel p : tank2.getTankPixels())
		{
			g.setColor(p.getcolor());
			g.drawRect(p.getx(), p.gety(), 1, 1);
		}
	}
		
		
	public void paint(Graphics g)
	{	
		super.paintComponent(g);
		
		//Draw Tank 1
		for(Pixel p : tank1.getTankPixels())
		{
			g.setColor(p.getcolor());
			g.drawRect(p.getx(), p.gety(), 1, 1);
		}
		//Draw Tank 2
		for(Pixel p : tank2.getTankPixels())
		{
			g.setColor(p.getcolor());
			g.drawRect(p.getx(), p.gety(), 1, 1);
		}
	}
	
	public void drawShot(int player, boolean tankHit)
	{
		Graphics g = getGraphics();
		paint(g);
		
		MuzzleTip t = null;
		
		if(player == 1)
			t = tank1.getMuzzleTip();
		else if(player == 2)
			t = tank2.getMuzzleTip();
		else
		{
			System.err.println("PlayDrawArea->drawShot->ERROR; tried to shoot for invalid player");
			System.exit(-1);
		}
		
		g.translate(t.getX(), t.getY());
		
		for(Pixel p : shot)
		{
			g.setColor(p.getcolor());
			g.drawLine(p.getx(), p.gety(), p.getx(),p.gety());
			
			try {
				Thread.sleep((long) 1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		if(tankHit)
		{	
			g = getGraphics();
			g.translate((d.width/2)-45, 100);
			g.setFont(hitMissFont);
			g.setColor(Color.RED);
			g.drawString("HIT!", 0, 0);
			
			if(player == 1)	//We subtract from tank 2
			{
				int damage = (int) (Math.random()*50 + 1);
				int health;
				tank2.addDamage(damage);
				health = tank2.getHealth();
				
				drawHitPoints(damage, tank2);
				p2Panel.getSliderValuePanel().setHealthPanel(health);
				
				if(health <= 0)
					closeGame(1);		//Close the game, player 1 wins.
			}
			else
			{
				int damage = (int) (Math.random()*50 + 1);
				int health;
				tank1.addDamage(damage);
				health = tank1.getHealth();
				drawHitPoints(damage, tank1);
				p1Panel.getSliderValuePanel().setHealthPanel(health);	
				
				if(health <= 0)
					closeGame(2);		//Close the game, player 2 wins.
			}
		}
		else
		{
			g = getGraphics();
			g.translate((d.width/2)-45, 100);
			g.setFont(hitMissFont);
			g.setColor(Color.RED);
			g.drawString("MISS!", 0, 0);
		}
	}
	
	private void drawHitPoints(int damage, tank t)
	{
		Graphics g = getGraphics();
		String s = Integer.toString(-1*damage);
		Coordinate c = t.getTopOfTank();
		g.translate(c.getX(), c.getY());
		g.setColor(Color.RED);
		g.setFont(new Font("monospaced", Font.BOLD, 10));
		g.drawString(s, 0, -20);
	}
	
	public void setShotPixels(LinkedList<Pixel> p, int player, boolean tankHit)
	{
		this.shot.clear();
		this.shot = p;
		drawShot(player, tankHit);	
	}
	
	public void setPlayerPanel(PlayerPanel p, int player)
	{
		if(player == 1)
			this.p1Panel = p;
		else if(player == 2)
			this.p2Panel = p;
		else
		{
			System.err.println("PlayDrawArea->ERROR:Tried to set a player panel for an invalid player!");
			System.exit(-1);
		}
	
	}
	

	private void closeGame(int winner)
	{
		if(winner == 1)
		{
			JOptionPane.showMessageDialog(null,
					"Player 1 wins!",
					"Score Report",
					JOptionPane.INFORMATION_MESSAGE);	
		}
		else if(winner == 2)
		{
			JOptionPane.showMessageDialog(null,
					"Player 2 wins!",
					"Score Report",
					JOptionPane.INFORMATION_MESSAGE);		
		}
		else
		{
			System.err.println("PlayDrawArea->ERROR:Invalid winner!");
			System.exit(-1);
		}
		
		int userResponse;
		userResponse = JOptionPane.showConfirmDialog(null,
					"Would you like to play again?",
					"",
					JOptionPane.YES_NO_OPTION);
		if(userResponse == JOptionPane.NO_OPTION)
			System.exit(0);
		else
		{
			resetGame();
		}
	}
	
	private void resetGame()
	{
		//Tasks
		/*
		 * -Reset tank health and position
		 * -Update slider value panels to defaults, and sliders
		 * -Let the loser go first (TODO)
		 * -Change the scalar (TODO)
		 */
		
		tank1.reset();
		tank2.reset();
		p1Panel.reset();
		p2Panel.reset();
		paint(getGraphics());
		
		
	}
	
	public tank getTank1() { return this.tank1; }
	public tank getTank2() { return this.tank2; }	
}
