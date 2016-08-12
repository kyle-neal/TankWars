package main.java.gui.graphics;

import java.awt.Color;
import java.util.LinkedList;

import main.java.utilities.Coordinate;

public class tank 
{
	private final LinkedList<Pixel> pixels = new LinkedList<Pixel>();
	private int currentx;
	private int currenty;
	private int xstart;
	private int ystart;
	private MuzzleTip t = null;
	private TankBounds bounds = null;
	private int player;
	private int health;
	private Coordinate topOfTank;
	
	public tank(int player, int x, int y)
	{
		this.player = player;
		this.xstart = x;
		this.ystart = y;
		currentx = xstart;
		currenty = ystart;
		this.health = 100;
		
		if(player == 1)
			generateTank1();
		else if (player == 2)
			generateTank2();
		else
		{
			System.err.println("tank->ERROR! Tried to create a tank for an invalid player!");
			System.exit(-1);
		}
	}
	
	
	private void generateTank1()
	{	
		//Add all pixels
		pixels.add(new Pixel(0+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 9+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 11+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 13+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 15+currenty, Color.BLACK));
		pixels.add(new Pixel(2+currentx, 8+currenty, Color.BLACK));
		pixels.add(new Pixel(2+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(2+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(2+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(3+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(3+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(3+currentx, 13+currenty, Color.BLACK));
		pixels.add(new Pixel(3+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(3+currentx, 15+currenty, Color.BLACK));
		pixels.add(new Pixel(3+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(4+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(4+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(4+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(4+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(5+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(5+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(5+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(6+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(6+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(6+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(7+currentx, 4+currenty, Color.BLACK));
		pixels.add(new Pixel(7+currentx, 5+currenty, Color.BLACK));
		pixels.add(new Pixel(7+currentx, 5+currenty, Color.BLACK));
		pixels.add(new Pixel(7+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(7+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(7+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(8+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(8+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(8+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(9+currentx, 2+currenty, Color.BLACK));
		pixels.add(new Pixel(9+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(10+currentx, 2+currenty, Color.BLACK));
		pixels.add(new Pixel(10+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(10+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(11+currentx, 2+currenty, Color.BLACK));
		pixels.add(new Pixel(11+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(11+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(12+currentx, 2+currenty, Color.BLACK));
		pixels.add(new Pixel(12+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(12+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(12+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(13+currentx, 2+currenty, Color.BLACK));
		pixels.add(new Pixel(13+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(13+currentx, 13+currenty, Color.BLACK));
		pixels.add(new Pixel(13+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(13+currentx, 15+currenty, Color.BLACK));
		pixels.add(new Pixel(13+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(14+currentx, 2+currenty, Color.BLACK));
		pixels.add(new Pixel(14+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(14+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(14+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(15+currentx, 4+currenty, Color.BLACK));
		pixels.add(new Pixel(15+currentx, 5+currenty, Color.BLACK));
		pixels.add(new Pixel(15+currentx, 6+currenty, Color.BLACK));
		pixels.add(new Pixel(15+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(15+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(15+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(16+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(16+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(16+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(17+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(17+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(17+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(18+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(18+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(18+currentx, 16+currenty, Color.BLACK));	
		pixels.add(new Pixel(19+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(19+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(19+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(20+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(20+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(20+currentx, 16+currenty, Color.BLACK));	
		pixels.add(new Pixel(21+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(21+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(21+currentx, 16+currenty, Color.BLACK));	
		pixels.add(new Pixel(22+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(22+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(22+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(22+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(23+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(23+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(23+currentx, 13+currenty, Color.BLACK));
		pixels.add(new Pixel(23+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(23+currentx, 15+currenty, Color.BLACK));
		pixels.add(new Pixel(23+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(24+currentx, 8+currenty, Color.BLACK));
		pixels.add(new Pixel(24+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(24+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(24+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(25+currentx, 9+currenty, Color.BLACK));
		pixels.add(new Pixel(25+currentx, 10+currenty, Color.BLACK));
		pixels.add(new Pixel(25+currentx, 11+currenty, Color.BLACK));
		pixels.add(new Pixel(25+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(25+currentx, 13+currenty, Color.BLACK));
		pixels.add(new Pixel(25+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(25+currentx, 15+currenty, Color.BLACK));
		pixels.add(new Pixel(26+currentx, 12+currenty, Color.BLACK));
		
		
		//Muzzle
		pixels.add(new Pixel(15+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(16+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(17+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(18+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(19+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(20+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(21+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(22+currentx, 2+currenty, Color.BLACK));
		pixels.add(new Pixel(22+currentx, 3+currenty, Color.BLACK));	//TIP
		pixels.add(new Pixel(22+currentx, 4+currenty, Color.BLACK));
		
		//Muzzle tip for g.translate().
		if(t == null)
			this.t = new MuzzleTip(22+currentx, 3+currenty);
		else
			this.t.setTip(22+currentx, 3+currenty);
		
		//System.out.println("Tank 1 Muzzle Tip (" + (22+currentx) + ", " + (3+currenty) + " )");
		
		//Bounds
		this.bounds = new TankBounds(new Coordinate(0+currentx, 0+currenty), 
				 new Coordinate(26+currentx, 0+currenty),
				 new Coordinate(26+currentx, 16+currenty), 
				 new Coordinate(0+currentx, 16+currenty));
		
		this.topOfTank = new Coordinate(10+currentx, 2+currenty);
	}
	
	private void generateTank2()
	{
		//Add all pixels
		pixels.add(new Pixel(0+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 9+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 11+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 13+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 15+currenty, Color.BLACK));
		pixels.add(new Pixel(2+currentx, 8+currenty, Color.BLACK));
		pixels.add(new Pixel(2+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(2+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(2+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(3+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(3+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(3+currentx, 13+currenty, Color.BLACK));
		pixels.add(new Pixel(3+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(3+currentx, 15+currenty, Color.BLACK));
		pixels.add(new Pixel(3+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(4+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(4+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(4+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(4+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(5+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(5+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(5+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(6+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(6+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(6+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(7+currentx, 4+currenty, Color.BLACK));
		pixels.add(new Pixel(7+currentx, 5+currenty, Color.BLACK));
		pixels.add(new Pixel(7+currentx, 5+currenty, Color.BLACK));
		pixels.add(new Pixel(7+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(7+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(7+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(8+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(8+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(8+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(9+currentx, 2+currenty, Color.BLACK));
		pixels.add(new Pixel(9+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(10+currentx, 2+currenty, Color.BLACK));
		pixels.add(new Pixel(10+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(10+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(11+currentx, 2+currenty, Color.BLACK));
		pixels.add(new Pixel(11+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(11+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(12+currentx, 2+currenty, Color.BLACK));
		pixels.add(new Pixel(12+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(12+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(12+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(13+currentx, 2+currenty, Color.BLACK));
		pixels.add(new Pixel(13+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(13+currentx, 13+currenty, Color.BLACK));
		pixels.add(new Pixel(13+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(13+currentx, 15+currenty, Color.BLACK));
		pixels.add(new Pixel(13+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(14+currentx, 2+currenty, Color.BLACK));
		pixels.add(new Pixel(14+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(14+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(14+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(15+currentx, 4+currenty, Color.BLACK));
		pixels.add(new Pixel(15+currentx, 5+currenty, Color.BLACK));
		pixels.add(new Pixel(15+currentx, 6+currenty, Color.BLACK));
		pixels.add(new Pixel(15+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(15+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(15+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(16+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(16+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(16+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(17+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(17+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(17+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(18+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(18+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(18+currentx, 16+currenty, Color.BLACK));	
		pixels.add(new Pixel(19+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(19+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(19+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(20+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(20+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(20+currentx, 16+currenty, Color.BLACK));	
		pixels.add(new Pixel(21+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(21+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(21+currentx, 16+currenty, Color.BLACK));	
		pixels.add(new Pixel(22+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(22+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(22+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(22+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(23+currentx, 7+currenty, Color.BLACK));
		pixels.add(new Pixel(23+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(23+currentx, 13+currenty, Color.BLACK));
		pixels.add(new Pixel(23+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(23+currentx, 15+currenty, Color.BLACK));
		pixels.add(new Pixel(23+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(24+currentx, 8+currenty, Color.BLACK));
		pixels.add(new Pixel(24+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(24+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(24+currentx, 16+currenty, Color.BLACK));
		pixels.add(new Pixel(25+currentx, 9+currenty, Color.BLACK));
		pixels.add(new Pixel(25+currentx, 10+currenty, Color.BLACK));
		pixels.add(new Pixel(25+currentx, 11+currenty, Color.BLACK));
		pixels.add(new Pixel(25+currentx, 12+currenty, Color.BLACK));
		pixels.add(new Pixel(25+currentx, 13+currenty, Color.BLACK));
		pixels.add(new Pixel(25+currentx, 14+currenty, Color.BLACK));
		pixels.add(new Pixel(25+currentx, 15+currenty, Color.BLACK));
		pixels.add(new Pixel(26+currentx, 12+currenty, Color.BLACK));
		
		
		//Muzzle
		pixels.add(new Pixel(8+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(7+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(6+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(5+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(4+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(3+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(2+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 2+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 3+currenty, Color.BLACK));
		pixels.add(new Pixel(1+currentx, 4+currenty, Color.BLACK));
		
		if(t == null)
			this.t = new MuzzleTip(1+currentx, 3+currenty);
		else
			this.t.setTip(1+currentx, 3+currenty);
		
		//Bounds
		this.bounds = new TankBounds(new Coordinate(0+currentx, 0+currenty), 
				 new Coordinate(26+currentx, 0+currenty),
				 new Coordinate(26+currentx, 16+currenty), 
				 new Coordinate(0+currentx, 16+currenty));
		
		this.topOfTank = new Coordinate(10+currentx, 2+currenty);
	}

	

	public class TankBounds
	{
		//This represents a box surrounding the tank.
		/*
		 * p1--------p2
		 * |		 |	
		 * |         |
		 * |         |
		 * p4--------p3
		 */
		private Coordinate p1;
		private Coordinate p2;
		private Coordinate p3;
		private Coordinate p4;
		
		TankBounds(Coordinate p1, Coordinate p2, Coordinate p3, Coordinate p4)
		{
			this.p1 = p1;
			this.p2 = p2;
			this.p3 = p3;
			this.p4 = p4;	
			
//			System.out.println("Tank " + player + " Bounds");
//			System.out.println("P1( " + p1.getX() + ", " + p1.getY() + " )");
//			System.out.println("P2( " + p2.getX() + ", " + p2.getY() + " )");
//			System.out.println("P3( " + p3.getX() + ", " + p3.getY() + " )");
//			System.out.println("P4( " + p4.getX() + ", " + p4.getY() + " )");
			
		}
		
		public int getP1X() { return this.p1.getX(); }
		public int getP1Y() { return this.p1.getY(); }
		public int getP2X() { return this.p2.getX(); }
		public int getP2Y() { return this.p2.getY(); }
		public int getP3X() { return this.p3.getX(); }
		public int getP3Y() { return this.p3.getY(); }
		public int getP4X() { return this.p4.getX(); }
		public int getP4Y() { return this.p4.getY(); }
	}
			

		
	public class MuzzleTip
		{
			private int x;
			private int y;
			
			MuzzleTip(int x, int y)
			{
				this.x = x;
				this.y = y;
			}
			
			public MuzzleTip() 
			{
				//NO-OP
			}

			public void setTip(int x, int y)
			{
				this.x = x;
				this.y = y;
			}
			
			public int getX() { return this.x; }
			public int getY() { return this.y; }
				
		}
			
	public MuzzleTip getMuzzleTip()
	{
		return this.t;
	}
		
	
	public LinkedList<Pixel> getTankPixels()
	{
		return this.pixels;
	}
	
	public boolean inBounds(int x, int y)
	{
		//This function returns if incoming coordinates are hitting the tank.
		if(x > this.bounds.getP1X() && x < this.bounds.getP2X() &&
		   y > this.bounds.getP1Y() && y < this.bounds.getP4Y())
		{
			return true;
		}
		else
			return false;
	}
	
	public int getHealth() { return this.health; }
	public void addDamage(int damage) { this.health = this.health - damage; }
	public Coordinate getTopOfTank() { return this.topOfTank; }
	
	public void reset()
	{
		this.currentx = this.xstart;
		this.currenty = this.ystart;
		this.health = 100;
	}
	}

