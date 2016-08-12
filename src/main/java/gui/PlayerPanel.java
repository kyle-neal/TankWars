/*
 *  Programmer: 	Kyle Neal
 *  Date Created: 	7-3-14
 *  Information:	This is a player panel. It resides on the east
 *  				and west corners of the frame. It will hold
 *  				all player sliders, fire button, and other info.
 */

package main.java.gui;


//IMPORT FIELD
//*****************************************
import main.java.gui.comp.ArrowPanel;
import main.java.gui.comp.FireButton;
import main.java.gui.comp.QuadrantElevationSlider;
import main.java.gui.comp.SliderValuePanel;
import main.java.gui.comp.VelocitySlider;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
//*****************************************

public class PlayerPanel extends JPanel
{
	//DATA FIELD
	//*****************************************
	private int player;
	private Dimension d;
	private VelocitySlider vs;
	private QuadrantElevationSlider qes;
	private PlayDrawArea dp;
	private FireButton myButton;
	private SliderValuePanel sliderValPanel;
	//*****************************************
	
	//FUNCTION FIELD
	//*****************************************
	public PlayerPanel(int player, Dimension d, PlayDrawArea dp)
	{
		this.dp = dp;
		this.d = d;
		this.player = player;
		this.qes = new QuadrantElevationSlider(new Dimension(this.WIDTH, this.HEIGHT), player);
		this.vs = new VelocitySlider(new Dimension(this.WIDTH, this.HEIGHT), player);
		this.myButton = new FireButton(this.player, this.dp, this.qes, this.vs);
		this.setPreferredSize(d);

		//LAYOUT
		//*****************************************
		/*
		 * Row 1; Slider Values
		 * Row 2; Muzzle Velocity
		 * Row 3; Quadrant Elevation
		 * Row 4; Arrows
		 * Row 5; Fire Button
		 */
		this.setLayout(new GridLayout(5,1));
		//*****************************************
		// * Row 1; Slider Values
		this.sliderValPanel = new SliderValuePanel(this.vs, this.qes, this.player);
		this.add(sliderValPanel);
		// * Row 2; Muzzle Velocity
		this.add(vs);
		// * Row 3; Quadrant Elevation
		this.add(qes);
		// * Row 4; Arrows
		this.add(new ArrowPanel());
		// * Row 5; Fire Button
		this.add(myButton);		
	}

	public FireButton getButton() { return this.myButton; }
	
	public SliderValuePanel getSliderValuePanel() { return this.sliderValPanel; }
	public void setOtherPlayerButton(FireButton theirButton) 
	{
		this.myButton.setTheirButton(theirButton);
	}
	
	public void reset()
	{
		this.vs.setValue(0);
		this.qes.setValue(100);
		this.sliderValPanel.setHealthPanel(100);
		this.myButton.setScaler((int) (Math.random()*1000 + 200));
	}
	//*****************************************
}
