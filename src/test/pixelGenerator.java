/*
 *  Programmer: 	Kyle Neal
 *  Date Created: 	7-8-14
 *  Information:	This file generators customizable calls to pixels. Using a file.
 */

package test;
import java.awt.Color;
import java.io.*;
import java.util.Scanner;


public class pixelGenerator 
{
	public static final int BLACK = 1;


	public static void main(String[] args) throws IOException 
	{
		PrintWriter myPrint;
		myPrint = new PrintWriter(new BufferedWriter(new FileWriter("/home/nealkw/Desktop/Eclipse Workspace/TankWars/src/test/tankGenPixels.txt")));
		
		Scanner scan = new Scanner(new File("/home/nealkw/Desktop/Eclipse Workspace/TankWars/src/test/tankPixels.txt"));
		
		while(scan.hasNext())
		{
			//pixels.add(new Pixel(2+xmod, 0+ymod, Color.BLACK));
			int x = scan.nextInt();
			int y = scan.nextInt();
			int color = scan.nextInt();
			String Color = null;
			
			switch(color)
			{
				case 1:
				{
					Color = new String("Color.BLACK");
					break;
				}
				default:
				{
					System.err.println("ERROR: No color");
					System.exit(-1);
					break;
				}
			}
			
			
			myPrint.write("pixels.add(new Pixel(" + x + "+xmod, " + y + "+ymod, " + Color + "));\n");
		}
		myPrint.close();
	}

}
