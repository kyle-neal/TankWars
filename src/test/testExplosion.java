package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class testExplosion extends JFrame 
{
	public display testPanel;
	
	public testExplosion()
	{
		testPanel = new display();
		this.setTitle("Test Explosion Animation");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JButton	testButton = new JButton();
		testButton.setText("TEST");
		testButton.addActionListener(new ActionListener()
		{
			class animation implements Runnable
			{
				@Override
				public void run() 
				{
					testPanel.action();
				}
			}
			@Override
			public void actionPerformed(ActionEvent e)
			{
				animation animator = new animation();
				Thread t = new Thread(animator);
				t.start();
			}
		});
		
		this.setLayout(new BorderLayout());
		this.add(testPanel, BorderLayout.CENTER);
		this.add(testButton, BorderLayout.SOUTH);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		testPanel.paint();
	}
	
	public class display extends JPanel
	{
		private static final double gravity = 0;
		private Graphics g;
		private Dimension d;
		private int width;
		private int height;
		
		public display()
		{
			g = getGraphics();
			d = new Dimension(500, 500);
			width = d.width;
			height = d.height;
			this.setPreferredSize(d);
			this.setBackground(Color.CYAN);
		}
		
		public void paint(Graphics g)
		{
			super.paintComponent(g);
		
			synchronized(this)
			{
				//Ground
				g.setColor(new Color(139, 69, 19));
				g.fillRect(0, 250, width, height);
				
				//Grass
				g.setColor(Color.GREEN);
				g.fillRect(0, 250, width, 50);	
			}
		}
		
		public void paint()
		{
			g = getGraphics();
			this.paintComponent(g);

			synchronized(this)
			{
				//Ground
				g.setColor(new Color(139, 69, 19));
				g.fillRect(0, 250, width, height);
				
				//Grass
				g.setColor(Color.GREEN);
				g.fillRect(0, 250, width, 50);		
			}
			
		}
		
		public void action()
		{
			paint();
			drawMissile();
		}
		
		private void drawMissile()
		{
			d = this.getSize();
			g = getGraphics();	
			System.out.print(d);
			
			int X = 250;
			int Y = 0;
			
			while(Y <= 250)
			{
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				g.drawRect(X, Y, 1, 1);
				Y++;
			}	
			try {
				impact(X, Y);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void impact(int x, int y) throws IOException
		{
			g = getGraphics();
			g.translate(x, y);
			
			//Tosser threads
			for(double qe = 700.0; qe < 1100.0; qe +=50.0)
			{
				dirtAnimator a = new dirtAnimator(qe);
				Thread t = new Thread(a);
				t.start();
			}

		
			//Cleaner threads
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(double qe = 700.0; qe < 1100.0; qe +=50.0)
			{
				dirtAnimator a = new dirtAnimator(qe, true);
				Thread t = new Thread(a);
				t.start();
			}
		}
		
		private void tossDirt(double qe, boolean colorChange)
		{
			if(colorChange)
				g.setColor(Color.CYAN);
			
			//Start of algorithm
			final double gravity = -9.8;
			int mv = 300;
			double X = 0.0;
			double Y = 0.0;
			double T = 0.0;	
			double V_X = (double)mv * Math.cos(qe);
			double V_Y = (double)mv * Math.sin(qe);
			
			do
			{	
				double tempY = Y;
				X = V_X * T;
				Y = V_Y * T + 0.5 * gravity * T * T;
				T = T + 0.1;
			
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				g.drawLine((int)X/100,(int)Y/100*-1,(int)X/100,(int)Y/100*-1);
			}while(T < 30);
		}
		
		
		private class dirtAnimator implements Runnable
		{
			double qe;
			boolean colorChange = false;
			
			public dirtAnimator(double qe)
			{
				this.qe = qe;
			}
			
			public dirtAnimator(double qe, boolean colorChange)
			{
				this.colorChange = colorChange;
				this.qe = qe;
			}
			
			@Override
			public void run() 
			{
				tossDirt(qe, colorChange);
			}
			
		}
	}
	
	
	public static void main(String[] args)
	{
		testExplosion frame = new testExplosion();
	}
}
