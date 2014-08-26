/*
 * Programmer: Kyle Neal
 * Date:	   30 December 2013
 * Info:	   This program simulates the trajectory of a fired
 * 			   projectile and plots the flight on a 2-D display.
 */
package test;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//import dotComponent.Pixel;

public class multipleShots extends JFrame
{
	private static final long serialVersionUID = 1L;
	//***********************************
	final static double initialQE = 1000;
	final static double minQE = 0;
	final static double maxQE = 1600;
	
	final static int initialMV = 300;
	final static int minMV = 0;
	final static int maxMV = 2000;
	
	static int SCALER = 40;
	
	//Holds slider values.
	static LinkedList<Curves> curves;
	static double QE = initialQE;
	static int MV = initialMV;
	static int CH = 0;
	static int TR = 0;
	static long initialAnimationDelay = 5;
	static long animationDelay = initialAnimationDelay/2;
	static boolean clearScreenCheck = false;
	static boolean multipleShotsFlag = false;
	//***********************************
	public static displayPanel display;
	public static finalFlightStatsPanel finalFlightStats;
	public static currentFlightDataPanel currentFlightData;
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public multipleShots()
	{
		Font f; 						//Font variable to be used for changing fonts
		setLayout(new BorderLayout());	//Layout for frame.
		
		//Data grid~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JPanel dataGrid = new JPanel();
		dataGrid.setLayout(new GridLayout(5, 1));
	
		
		final JPanel sliderValues = new JPanel();
		sliderValues.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Slider Data"));
		sliderValues.setLayout(new GridLayout(3,2));
		sliderValues.add(new JLabel("Quadrant Elevation:"));
		final JLabel QEVALUE = new JLabel(new String(QE + " mils"));
		sliderValues.add(QEVALUE);
		sliderValues.add(new JLabel("Muzzle Velocity:"));
		final JLabel MVVALUE = new JLabel(new String(MV + " m/s"));
		sliderValues.add(MVVALUE);
		sliderValues.add(new JLabel("Cannon Height:"));
		final JLabel CHVALUE = new JLabel(new String(CH + " meters"));
		sliderValues.add(CHVALUE);
		
		
		
		currentFlightData = new currentFlightDataPanel();
		currentFlightData.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Current Flight Data"));


		finalFlightStats = new finalFlightStatsPanel();

		
		final JPanel finalInputs = new JPanel();
		finalInputs.setLayout(new GridLayout(2,1));
		
		JCheckBox clearScreen = new JCheckBox();
		clearScreen.setText("Clear Screen Prior to Fire");
		clearScreen.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)				
			{
				clearScreenCheck = !clearScreenCheck;
			}
		});
		finalInputs.add(clearScreen);
		
		JCheckBox multipleShots = new JCheckBox();
		multipleShots.setText("Shoot multiple shots");
		multipleShots.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				multipleShotsFlag = !multipleShotsFlag;
			}
		});
		
		finalInputs.add(multipleShots);
		

		
		dataGrid.add(sliderValues);
		dataGrid.add(currentFlightData);
		dataGrid.add(finalFlightStats);
		dataGrid.add(finalInputs);
	
		JButton fire = new JButton("FIRE");
		fire.setBackground(Color.BLACK);
		fire.setForeground(Color.RED);
		f = new Font("Monospaced", Font.BOLD, 20);
		fire.setFont(f);
		
		FIREListenerClass action = new FIREListenerClass();		//Listener class
		fire.addActionListener(action);
		dataGrid.add(fire);
		
		
		//Input Sliders~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JPanel inputSliders = new JPanel();
		inputSliders.setLayout(new GridLayout(2,2,10,10));
		
		final JSlider quadrantElevation = new JSlider(JSlider.HORIZONTAL, (int)minQE, (int)maxQE, (int)initialQE);    
		f = new Font("Monospaced", Font.BOLD, 10);
		quadrantElevation.setBorder(BorderFactory.createTitledBorder("Quadrant Elevation (mils)"));
		quadrantElevation.setFont(f); 
		quadrantElevation.setMajorTickSpacing(100);
		quadrantElevation.setMinorTickSpacing(10);
		quadrantElevation.setPaintTicks(true);
		quadrantElevation.setPaintLabels(true);
		quadrantElevation.addChangeListener(new ChangeListener() 
		{ 
			@Override
			public void stateChanged(ChangeEvent e) 
			{ 
			      QE = quadrantElevation.getValue(); 
			      QEVALUE.setText(new String("" + QE + " mils"));
			} 
		});
		inputSliders.add(quadrantElevation);	
		
		final JSlider muzzleVelocity = new JSlider(JSlider.HORIZONTAL, minMV, maxMV, initialMV);
		f = new Font("Monospaced", Font.BOLD, 7);
		muzzleVelocity.setBorder(BorderFactory.createTitledBorder("Muzzle Velocity"));
		muzzleVelocity.setFont(f); 
		muzzleVelocity.setMajorTickSpacing(100);
		muzzleVelocity.setMinorTickSpacing(10);
		muzzleVelocity.setPaintTicks(true);
		muzzleVelocity.setPaintLabels(true);
		muzzleVelocity.addChangeListener(new ChangeListener() 
		{ 
			@Override
			public void stateChanged(ChangeEvent e) 
			{ 
			      MV = muzzleVelocity.getValue(); 
			      MVVALUE.setText(new String("" + MV + " m/s"));
			} 
		});
		inputSliders.add(muzzleVelocity);	
		
		final JSlider cannonHeight = new JSlider(JSlider.HORIZONTAL, 0, 5000, 0);
		f = new Font("Monospaced", Font.BOLD, 7);
		cannonHeight.setBorder(BorderFactory.createTitledBorder("Cannon Height (meters)"));
		cannonHeight.setFont(f); 
		cannonHeight.setMajorTickSpacing(1000);
		cannonHeight.setMinorTickSpacing(100);
		cannonHeight.setPaintTicks(true);	
		cannonHeight.setPaintLabels(true);
		cannonHeight.addChangeListener(new ChangeListener() 
		{ 
			@Override
			public void stateChanged(ChangeEvent e) 
			{ 
			      CH = cannonHeight.getValue(); 
			      CHVALUE.setText(new String("" + CH + " meters"));
			} 
		});
		inputSliders.add(cannonHeight);	
		

		//Here we are replacing the target slider with zoom and animation delay.
		JPanel animationZoomSliders = new JPanel();
		animationZoomSliders.setLayout(new GridLayout(1, 2));
		
		//Zoom Slider
		final JSlider zoomSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
		f = new Font("Monospaced", Font.BOLD, 10);
		zoomSlider.setBorder(BorderFactory.createTitledBorder("Zoom"));
		zoomSlider.setFont(f); 
		zoomSlider.setMajorTickSpacing(1);
		zoomSlider.setPaintTicks(true);
		zoomSlider.setPaintLabels(true);
		zoomSlider.addChangeListener(new ChangeListener() 
		{ 
			@Override
			public void stateChanged(ChangeEvent e) 
			{ 
				//Zoom out = SCALER gets bigger
				//Zoom in = SCALER gets smaller
				
			
				//We start at 0 which translates to 40
				switch(zoomSlider.getValue())
				{
					case 0:
					{
						SCALER = 40;
						break;
					}
					case 1:
					{		
						SCALER = 100;
						break;
					}
					case 2:
					{
						SCALER = 150;
						break;
					}
					case 3:
					{
						SCALER = 200;
						break;
					}
					case 4:
					{
						SCALER = 250;
						break;
					}
					case 5:
					{
						SCALER = 300;
						break;
					}
					case 6:
					{
						SCALER = 400;
						break;
					}
					case 7:
					{
						SCALER = 450;
						break;
					}
					case 8:
					{
						SCALER = 500;
						break;
					}
					case 9:
					{
						SCALER = 550;
						break;
					}
					case 10:
					{
						SCALER = 600;
						break;
					}
					default:
					{
						SCALER = 100;
						break;
					}
				
				}
				display.paint();
			} 
		});


		//Animation Slider
		final JSlider delaySlider = new JSlider(JSlider.HORIZONTAL, 0, 10, (int)initialAnimationDelay);
		f = new Font("Monospaced", Font.BOLD, 10);
		delaySlider.setBorder(BorderFactory.createTitledBorder("Animation Delay"));
		delaySlider.setFont(f); 
		delaySlider.setMajorTickSpacing(1);
		delaySlider.setPaintTicks(true);
		delaySlider.setPaintLabels(true);
		delaySlider.addChangeListener(new ChangeListener() 
		{ 
			@Override
			public void stateChanged(ChangeEvent e) 
			{ 
				animationDelay = delaySlider.getValue()/2;
			} 
		});
		
		//Add to panel
		animationZoomSliders.add(zoomSlider);
		animationZoomSliders.add(delaySlider);

		inputSliders.add(animationZoomSliders);	

		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//Center Panel for 2-D display and data~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//Data-------
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(dataGrid, BorderLayout.EAST);
		
		//Display-------
		display = new displayPanel();
		display.setBackground(Color.WHITE);
	
		centerPanel.add(display);
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		centerPanel.setBorder(BorderFactory.createTitledBorder("Display"));
		inputSliders.setBorder(BorderFactory.createTitledBorder("Input Data"));
		
		//Add the components to the frame
		add(inputSliders, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);	
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
	class currentFlightDataPanel extends JPanel
	{
		private double currentX, currentY, currentT;
	

		public void updateStats(double X, double Y, double T) 
		{
			currentX = X;
			currentY = Y;
			currentT = T;
			
			Graphics g = getGraphics();
			
			
			paintComponent(g);
			
			int PIXX = 10;
			int PIXY = 40;
			
			g.clearRect(10, 20, 100, 100);

			g.drawString("Altitude: 	" + Y + " meters", PIXX, PIXY);
			g.drawString("Range: 		" + X + " meters", PIXX, PIXY+20);
			g.drawString("Flight Time:	" + T + " ms", PIXX, PIXY+40);	
			//setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Current Flight Data"));
		}

	}
	
	class finalFlightStatsPanel extends JPanel
	{
		public JLabel FINALALTITUDE;
		public JLabel FINALRANGE;
		public JLabel FINALTIME;
		
		finalFlightStatsPanel()
		{
			this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Final Flight Data"));
			this.setLayout(new GridLayout(3,2));
			this.add(new JLabel("Maximum Altitude:"));
			FINALALTITUDE = new JLabel(new String("0 meters"));
			this.add(FINALALTITUDE);
			this.add(new JLabel("Maximum Range:"));
			FINALRANGE = new JLabel(new String("0 meters"));
			this.add(FINALRANGE);
			this.add(new JLabel("Final Flight Time:"));
			FINALTIME = new JLabel(new String("0 ms"));
			this.add(FINALTIME);
		}
		
		void setFlightDataText(double time, double maxAltitude, double maxRange)
		{
			DecimalFormat df = new DecimalFormat("#.##");
			FINALALTITUDE.setText(new String("" + df.format(maxAltitude) + " meters"));
			FINALRANGE.setText(new String("" + df.format(maxRange) + " meters"));
			FINALTIME.setText(new String("" + df.format(time) + " m/s"));
		}
	}
	
	class displayPanel extends JPanel 
	{
		Graphics worldgfx;
		
		displayPanel()
		{
			if(curves == null)
				curves = new LinkedList<Curves>();
		}
		
		void drawMisslePath(int x, int y, int ch) 
		{	
			Graphics gfx = getGraphics();
			
			worldgfx = gfx;
			
			gfx.translate(0, 490-(ch/10));		//Sets start point according to cannon height
			gfx.drawLine(x/SCALER, (y/SCALER)*-1, x/SCALER, (y/SCALER)*-1);
		}
		
		void drawImpact(int x)
		{
			x /= SCALER;
			System.out.println(x);
			
			//worldgx
		}
		
		void clearScreen()
		{
			curves.clear();
			Graphics gfx = getGraphics();
			super.paintComponent(gfx);	//Basically clears drawing area.
		}
		
		public void paint(Graphics g)
		{	
			super.paintComponent(g);
			
			//For every item in linked list repaint
			for(Curves l : curves)
			{	
				l.drawPixels();
			}
		}
		
		public void paint()
		{	
			Graphics g = getGraphics();
			
			super.paintComponent(g);
			
			//Draw line to represent ground.
			
			//For every item in linked list repaint
			for(Curves l : curves)
			{	
				l.drawPixels();
			}
		}
		void plotPixel(int x, int y, int ch, Color color)
		{			
			Graphics gfx = getGraphics();
			gfx.translate(0, 490-ch);
			//gfx.translate(0, 490-(ch/10));		//Sets start point according to cannon height
			gfx.drawLine(x/SCALER, (y/SCALER)*-1, x/SCALER, (y/SCALER)*-1);
		}
		
//		void drawBlast(int x)
//		{
//			Graphics gfx = getGraphics();
//			
//			for(int i = 0; i < 100; i++)
//			{
//				gfx.setColor(Color.white);
//				gfx.fillOval((x/SCALER)-5, 482-(CH/10), 10, 10);//x, y , width, height
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				repaint();
//				gfx.setColor(Color.RED);
//				gfx.fillOval((x/SCALER)-5, 482-(CH/10), 10, 10);//x, y , width, height
//			}
//			System.out.println("DONE");
//		}

	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	static class Curves
	{
		private LinkedList<Pixel> pixels;
		
		Curves(LinkedList<Pixel> p)
		{
			this.pixels = p;
		}
		
		public void drawPixels()
		{
			for(Pixel l: pixels)
			{
				//display.plotPixel(l.x, l.y, l.ch, l.color);
				display.drawMisslePath(l.x, l.y, l.ch);
			}
		}
		
	}

	static class Pixel
	{
	    final int x; 
	    final int y; 
	    final int ch;
	    final Color color;
	
	    public Pixel(int x, int y, int ch, Color color) 
	    {
	        this.x = x;
	        this.y = y;
	        this.ch = ch;
	        this.color = color;
	    }               
	}
	
	static private void runMissleAnimation(boolean noDelay, int mv, double qe, int ch)
	{
		if(!multipleShotsFlag)
			shootOnce(noDelay, mv, qe, ch);
		else
			shootMany(noDelay, mv, qe, ch);
	}
	
	static private void shootOnce(boolean noDelay, int mv, double qe, int ch)
	{
		
		if(clearScreenCheck)
			display.clearScreen();
		
		//Start of algorithm
		final double G = -9.8;
		double X = 0.0;
		double Y = 0.0;
		double T = 0.0;
		qe = qe/1018.95;	//One radian equates to 1018.95 mils.
		double V_X = (double)mv * Math.cos(qe);
		double V_Y = (double)mv * Math.sin(qe);
		double maxAltitude = 0;
		double maxRange = 0;
		LinkedList<Pixel> pixels = new LinkedList<Pixel>();
		
		do
		{	
			System.out.println("X: " + X);
			System.out.println("Y: " + Y);
			double tempY = Y;
			X = V_X * T;
			Y = V_Y * T + 0.5 * G * T * T;
			
			if(tempY < Y)
				maxAltitude = Y;
			
			T = T + 0.1;
			
			if(!noDelay)
			{
				try {
					Thread.sleep(animationDelay);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
			display.drawMisslePath((int)X,(int)Y, CH);
			pixels.add(new Pixel((int)X, (int)Y, CH, Color.BLACK));
			//flightData.setFlightDataText(X, Y, T);
			
			currentFlightData.updateStats(X, Y, T);
		}while(Y >= 0-(ch*10));
		maxRange = X;
		curves.add(new Curves(pixels));
		
		display.drawImpact((int)maxRange);
		
		//System.out.println((int)X);
		//display.drawBlast((int)X);

		finalFlightStats.setFlightDataText(T, maxAltitude, maxRange);
		currentFlightData.updateStats(X, Y, T);
	}
	
	static private void shootMany(boolean noDelay, int mv, double qe, int ch)
	{
		double tempQE = qe;
		
		for(int i = 0; i <= 10; i++)
		{
			Shooter run = new Shooter(noDelay, mv, qe + i*10, ch);
			Thread thread = new Thread(run);
			thread.start();
		}
	}
	
	static class Shooter implements Runnable
	{
		boolean noDelay;
		int mv;
		double qe; 
		int ch;
		double tempQE;
		
		Shooter(boolean noDelay, int mv, double qe, int ch)
		{
			this.noDelay = noDelay;
			this.mv = mv;
			this.qe = qe;
			this.ch = ch;
			this.tempQE = qe;
		}
		public void run()
		{
			shot();
		}
		
		private void shot()
		{
			if(clearScreenCheck)
				display.clearScreen();
			
			//Start of algorithm
			final double G = -9.8;
			double X = 0.0;
			double Y = 0.0;
			double T = 0.0;
			qe = tempQE/1018.95;	//One radian equates to 1018.95 mils.
			double V_X = (double)mv * Math.cos(qe);
			double V_Y = (double)mv * Math.sin(qe);
			double maxAltitude = 0;
			double maxRange = 0;
			LinkedList<Pixel> pixels = new LinkedList<Pixel>();
			
			System.out.println(tempQE);
			do
			{	
				double tempY = Y;
				X = V_X * T;
				Y = V_Y * T + 0.5 * G * T * T;
				
				if(tempY < Y)
					maxAltitude = Y;
				
				T = T + 0.1;
				
				if(!noDelay)
				{
					try {
						Thread.sleep(animationDelay);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
				display.drawMisslePath((int)X,(int)Y, CH);
				pixels.add(new Pixel((int)X, (int)Y, CH, Color.BLACK));
				//flightData.setFlightDataText(X, Y, T);
				
				currentFlightData.updateStats(X, Y, T);
			}while(Y >= 0-(ch*10));
			maxRange = X;
			curves.add(new Curves(pixels));
	
			finalFlightStats.setFlightDataText(T, maxAltitude, maxRange);
			currentFlightData.updateStats(X, Y, T);
			tempQE = tempQE + 10.0;
		}
	}
	
	class FIREListenerClass implements ActionListener
	{	
		
		private class Animator implements Runnable
		{
			public void run()
			{
				runMissleAnimation(false, MV, QE, CH);
			}
		}
		
		
		public void actionPerformed(ActionEvent e) 
		{	
			Animator animation = new Animator();
			Thread thread = new Thread(animation);
			thread.start();
		}
		
		
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void main(String[] args)
	{
		multipleShots frame = new multipleShots();
		
		frame.setTitle("Trajectory of Projectile");
		frame.setSize(1000,700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);	
		frame.setResizable(false);
		
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}
