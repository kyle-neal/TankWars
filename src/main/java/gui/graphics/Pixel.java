package main.java.gui.graphics;

import java.awt.Color;


public class Pixel
{
    final int x; 
    final int y; 
    final Color color;

	public Pixel(int x, int y, Color color) 
	{
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
}	//class Pixel
