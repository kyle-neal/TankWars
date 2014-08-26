/*
 *  Programmer: 	Kyle Neal
 *  Date Created: 	7-3-14
 *  Information:	This is a slider file. It defines the slider
 *  				for the adjustable muzzle velocity.
 */

package gui.comp;

//IMPORT FIELD
//*****************************************
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JSlider;
//*****************************************


public class VelocitySlider extends JSlider
{
	//DATA FIELD
	//*****************************************
	public List<VelocitySliderListener> listeners;
	private Font f;
	private int velocity;
	private int minVelocity = 0;
	private int maxVelocity = 3500;
	private Dimension d;
	private int player;
	//*****************************************
	
	//FUNCTIONS FIELD
	//*****************************************
	public VelocitySlider(Dimension d, int player)
	{
		this.player = player;
		this.d = d;
		this.setMaximumSize(d);
		this.velocity = 0;	
		this.setModel(new DefaultBoundedRangeModel(minVelocity, 0, minVelocity, maxVelocity));
		f = new Font("Monospaced", Font.BOLD, 7);
		this.setBorder(BorderFactory.createTitledBorder("Muzzle Velocity"));
		this.setFont(f); 
		this.addChangeListener(new StateListener(player));
	}
	
	//GETTER/SETTER FUNCTIONS
	//*****************************************
	public int getVelocity() { return this.velocity; }
	public int getMinVelocity() { return this.minVelocity; }
	public int getMaxVelocity() { return this.maxVelocity; }
	public void setVelocity(int velocity) { this.velocity = velocity; }
	
	//*****************************************
	
	//*****************************************
	
	protected class StateListener implements ChangeListener
	{
		private int player;
		
		public StateListener(int player)
		{
			super();
			this.player = player;
		}
		
		@Override
		public void stateChanged(ChangeEvent e) 
		{
			setVelocity(getValue());
			
			if(VelocitySlider.this.listeners != null)
			{
				for(VelocitySliderListener l: VelocitySlider.this.listeners)
					l.changeVelocitySliderListenerText(VelocitySlider.this.getVelocity());
			}
		}
		
	}
	
	public void addListener(VelocitySliderListener l)
	{
		if(this.listeners == null)
				this.listeners = new LinkedList<VelocitySliderListener>();
		
		this.listeners.add(l);
	}
	
	public void removeListener(VelocitySliderListener l)
	{
		if(this.listeners != null)
			this.listeners.remove(l);
	}
	
	static public interface VelocitySliderListener
	{
		public void changeVelocitySliderListenerText(int MV);
	}	
}
