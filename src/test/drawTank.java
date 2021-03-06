package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class drawTank extends JFrame
{
	private final LinkedList<Pixel> pixels = new LinkedList<Pixel>();
	
	public drawTank()
	{
		Dimension d = new Dimension(500, 500);
		this.setSize(d);
		//this.setResizable(false);
		drawPanel dp = new drawPanel(d);
		this.add(dp);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		dp.paint();
		
	}
	
	public class drawPanel extends JPanel
	{
		private int xmod = 200;
		private int ymod = 200;
		private Dimension d;
		
		public drawPanel(Dimension d)
		{
			this.d = d;
			this.setPreferredSize(d);
			
			//Add all pixels
			pixels.add(new Pixel(0+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(1+xmod, 9+ymod, Color.BLACK));
			pixels.add(new Pixel(1+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(1+xmod, 11+ymod, Color.BLACK));
			pixels.add(new Pixel(1+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(1+xmod, 13+ymod, Color.BLACK));
			pixels.add(new Pixel(1+xmod, 14+ymod, Color.BLACK));
			pixels.add(new Pixel(1+xmod, 15+ymod, Color.BLACK));
			pixels.add(new Pixel(2+xmod, 8+ymod, Color.BLACK));
			pixels.add(new Pixel(2+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(2+xmod, 14+ymod, Color.BLACK));
			pixels.add(new Pixel(2+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(3+xmod, 7+ymod, Color.BLACK));
			pixels.add(new Pixel(3+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(3+xmod, 13+ymod, Color.BLACK));
			pixels.add(new Pixel(3+xmod, 14+ymod, Color.BLACK));
			pixels.add(new Pixel(3+xmod, 15+ymod, Color.BLACK));
			pixels.add(new Pixel(3+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(4+xmod, 7+ymod, Color.BLACK));
			pixels.add(new Pixel(4+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(4+xmod, 14+ymod, Color.BLACK));
			pixels.add(new Pixel(4+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(5+xmod, 7+ymod, Color.BLACK));
			pixels.add(new Pixel(5+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(5+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(6+xmod, 7+ymod, Color.BLACK));
			pixels.add(new Pixel(6+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(6+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(7+xmod, 4+ymod, Color.BLACK));
			pixels.add(new Pixel(7+xmod, 5+ymod, Color.BLACK));
			pixels.add(new Pixel(7+xmod, 5+ymod, Color.BLACK));
			pixels.add(new Pixel(7+xmod, 7+ymod, Color.BLACK));
			pixels.add(new Pixel(7+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(7+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(8+xmod, 3+ymod, Color.BLACK));
			pixels.add(new Pixel(8+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(8+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(9+xmod, 2+ymod, Color.BLACK));
			pixels.add(new Pixel(9+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(10+xmod, 2+ymod, Color.BLACK));
			pixels.add(new Pixel(10+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(10+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(11+xmod, 2+ymod, Color.BLACK));
			pixels.add(new Pixel(11+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(11+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(12+xmod, 2+ymod, Color.BLACK));
			pixels.add(new Pixel(12+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(12+xmod, 14+ymod, Color.BLACK));
			pixels.add(new Pixel(12+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(13+xmod, 2+ymod, Color.BLACK));
			pixels.add(new Pixel(13+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(13+xmod, 13+ymod, Color.BLACK));
			pixels.add(new Pixel(13+xmod, 14+ymod, Color.BLACK));
			pixels.add(new Pixel(13+xmod, 15+ymod, Color.BLACK));
			pixels.add(new Pixel(13+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(14+xmod, 2+ymod, Color.BLACK));
			pixels.add(new Pixel(14+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(14+xmod, 14+ymod, Color.BLACK));
			pixels.add(new Pixel(14+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(15+xmod, 3+ymod, Color.BLACK));
			pixels.add(new Pixel(15+xmod, 4+ymod, Color.BLACK));
			pixels.add(new Pixel(15+xmod, 5+ymod, Color.BLACK));
			pixels.add(new Pixel(15+xmod, 6+ymod, Color.BLACK));
			pixels.add(new Pixel(15+xmod, 7+ymod, Color.BLACK));
			pixels.add(new Pixel(15+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(15+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(16+xmod, 3+ymod, Color.BLACK));
			pixels.add(new Pixel(16+xmod, 7+ymod, Color.BLACK));
			pixels.add(new Pixel(16+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(16+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(17+xmod, 3+ymod, Color.BLACK));
			pixels.add(new Pixel(17+xmod, 7+ymod, Color.BLACK));
			pixels.add(new Pixel(17+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(17+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(18+xmod, 3+ymod, Color.BLACK));
			pixels.add(new Pixel(18+xmod, 7+ymod, Color.BLACK));
			pixels.add(new Pixel(18+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(18+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(19+xmod, 3+ymod, Color.BLACK));
			pixels.add(new Pixel(19+xmod, 7+ymod, Color.BLACK));
			pixels.add(new Pixel(19+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(19+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(20+xmod, 3+ymod, Color.BLACK));
			pixels.add(new Pixel(20+xmod, 7+ymod, Color.BLACK));
			pixels.add(new Pixel(20+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(20+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(21+xmod, 3+ymod, Color.BLACK));
			pixels.add(new Pixel(21+xmod, 7+ymod, Color.BLACK));
			pixels.add(new Pixel(21+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(21+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(22+xmod, 2+ymod, Color.BLACK));
			pixels.add(new Pixel(22+xmod, 3+ymod, Color.BLACK));
			pixels.add(new Pixel(22+xmod, 4+ymod, Color.BLACK));
			pixels.add(new Pixel(22+xmod, 7+ymod, Color.BLACK));
			pixels.add(new Pixel(22+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(22+xmod, 14+ymod, Color.BLACK));
			pixels.add(new Pixel(22+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(23+xmod, 7+ymod, Color.BLACK));
			pixels.add(new Pixel(23+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(23+xmod, 13+ymod, Color.BLACK));
			pixels.add(new Pixel(23+xmod, 14+ymod, Color.BLACK));
			pixels.add(new Pixel(23+xmod, 15+ymod, Color.BLACK));
			pixels.add(new Pixel(23+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(24+xmod, 8+ymod, Color.BLACK));
			pixels.add(new Pixel(24+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(24+xmod, 14+ymod, Color.BLACK));
			pixels.add(new Pixel(24+xmod, 16+ymod, Color.BLACK));
			pixels.add(new Pixel(25+xmod, 9+ymod, Color.BLACK));
			pixels.add(new Pixel(25+xmod, 10+ymod, Color.BLACK));
			pixels.add(new Pixel(25+xmod, 11+ymod, Color.BLACK));
			pixels.add(new Pixel(25+xmod, 12+ymod, Color.BLACK));
			pixels.add(new Pixel(25+xmod, 13+ymod, Color.BLACK));
			pixels.add(new Pixel(25+xmod, 14+ymod, Color.BLACK));
			pixels.add(new Pixel(25+xmod, 15+ymod, Color.BLACK));
			pixels.add(new Pixel(26+xmod, 12+ymod, Color.BLACK));
		}
		
		public void paint()
		{
			Graphics g = getGraphics();
			
			//Draw Tank
			for(Pixel p : pixels)
			{
				g.setColor(p.getcolor());
				g.drawRect(p.getx(), p.gety(), 1, 1);
			}
		}
		
		public void paint(Graphics g)
		{
			//Draw Tank
			for(Pixel p : pixels)
			{
				g.setColor(p.getcolor());
				g.drawRect(p.getx(), p.gety(), 1, 1);
			}
		}
	    
	    public void addPixel(int x, int y) {
	        addPixel(x, y, Color.black);
	    }
	    
	    public void addPixel(int x, int y, Color color) {
	        pixels.add(new Pixel(x,y, color));        
	        repaint();
	    }
		
	}
	
	private static class Pixel{
	    final int x; 
	    final int y; 
	    final Color color;

	    public Pixel(int x, int y, Color color) {
	        this.x = x;
	        this.y = y;
	        this.color = color;
	    } 
	    
	    public int getx()
	    {
	    	return this.x;
	    }
	    public int gety()
	    {
	    	return this.y;
	    }
	    public Color getcolor()
	    {
	    	return this.color;
	    }
	}

	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		drawTank f = new drawTank();
		
	}

}
