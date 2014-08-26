/*
 *  Programmer: 	Kyle Neal
 *  Date Created: 	7-3-14
 *  Information:	This is a button file. It defines the fire button and kicks off
 *  				the animation of the shot, and all calculations associated with it.
 */

package gui.comp;

//IMPORT FIELD
//*****************************************
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import gui.PlayDrawArea;
import gui.graphics.Pixel;
import gui.graphics.tank;
import gui.graphics.tank.MuzzleTip;

//*****************************************
public class FireButton extends JButton
{
	//DATA FIELD
	//*****************************************
	private Font f;
	private int player;
	private int SCALER = 200;	//Scales down the pixels
	private LinkedList<Pixel> shotPixels = new LinkedList<Pixel>();
	private MuzzleTip myMuzzle;
	private PlayDrawArea dp;
	private QuadrantElevationSlider qeslider;
	private VelocitySlider mvslider;
	private FireButton theirButton;
	private tank myTank, theirTank;
	//*****************************************
	
	//FUNCTIONS FIELD
	//*****************************************
	public FireButton(int player, PlayDrawArea dp, QuadrantElevationSlider qe, 
					  VelocitySlider mv)
	{
		this.qeslider = qe;
		this.mvslider = mv;
		this.dp = dp;
		this.player = player;
		this.f = new Font("Monospaced", Font.BOLD, 20);
		
		if(player == 1)
		{
			this.myTank = dp.getTank1();
			this.theirTank = dp.getTank2();
			this.myMuzzle = dp.getTank1().getMuzzleTip();
		}
		else
		{
			this.myTank = dp.getTank2();
			this.theirTank = dp.getTank1();
			this.myMuzzle =  dp.getTank2().getMuzzleTip();
		}
		
		this.setText("FIRE");
		this.setBackground(Color.BLACK);
		this.setForeground(Color.RED);
		this.setFont(f);
		this.addActionListener(new FireListener(this.player, this));
	}
	
	public void setTheirButton(FireButton theirs)
	{
		this.theirButton = theirs;
	}
	
	public void setScaler(int scaler)
	{
		this.SCALER = scaler;
	}
	//*****************************************
	private class FireListener implements ActionListener
	{
		private int player; 
		private FireButton mybutton;
		
		public FireListener(int player, FireButton button)
		{
			super();
			this.player = player;
			this.mybutton = button;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			shotPixels.clear();
			
			double qe = qeslider.getValue(); 
			int mv = mvslider.getValue();
			boolean tankHit = false;
			
			//Start of algorithm
			final double G = -9.8;
			double X = 0.0;
			double Y = 0.0;
			double T = 0.0;
			qe = qe/1018.95;	//One radian equates to 1018.95 mils.
			double V_X = (double)mv * Math.cos(qe);
			double V_Y = (double)mv * Math.sin(qe);
			
			do
			{	
				
				int x, y;
				if(player == 2)
				{
					x = ((int)X/SCALER)*-1;
					y = ((int)Y/SCALER)*-1;
					
					shotPixels.add(new Pixel(x, y, Color.RED));
					
					if(theirTank.inBounds((x+myMuzzle.getX()), (y+myMuzzle.getY())))
						tankHit = true;
				}
				else
				{
					x = ((int)X/SCALER);
					y = ((int)Y/SCALER)*-1;
					
					shotPixels.add(new Pixel(x, y, Color.RED));
					
					if(theirTank.inBounds((x+myMuzzle.getX()), (y+myMuzzle.getY())))
						tankHit = true;
				}
	
				X = V_X * T;
				Y = V_Y * T + 0.5 * G * T * T;
				
				T = T + 0.1;
				

		
			}while(Y >= -10000);
			
			dp.setShotPixels(shotPixels, player, tankHit);
			mybutton.setEnabled(false);
			theirButton.setEnabled(true);
			
		}		
	}

}
