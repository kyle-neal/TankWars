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

public class QuadrantElevationSlider extends JSlider
{
	//DATA FIELD
	//*****************************************
	public List<QESliderListener> listeners;
	private Font f;
	private int QE;
	private int minQE = 100;
	private int maxQE = 1600;
	private Dimension d;
	private int player;
	//*****************************************
	
	//FUNCTIONS FIELD
	//*****************************************
	public QuadrantElevationSlider(Dimension d, int player)
	{
		this.player = player;
		this.d = d;
		this.setMaximumSize(d);
		this.QE = 0;	
		this.setModel(new DefaultBoundedRangeModel(minQE, 0, minQE, maxQE));
		f = new Font("Monospaced", Font.BOLD, 7);
		this.setBorder(BorderFactory.createTitledBorder("Quadrant Elevation"));
		this.setFont(f); 
		this.addChangeListener(new StateListener(this.player));
	}
	
	//GETTER/SETTER FUNCTIONS
	//*****************************************
	public int getQE() { return this.QE; }
	public int getMinQE() { return this.minQE; }
	public int getMaxQE() { return this.maxQE; }
	public void setQE(int QE) { this.QE = QE; }
	
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
			setQE(getValue());
			
			if(QuadrantElevationSlider.this.listeners != null)
			{
				for(QESliderListener l: QuadrantElevationSlider.this.listeners)
					l.changeQEText(QuadrantElevationSlider.this.getQE());
			}
		}
		
	}
	
	public void addListener(QESliderListener l)
	{
		if(this.listeners == null)
				this.listeners = new LinkedList<QESliderListener>();
		
		this.listeners.add(l);
	}
	
	public void removeListener(QESliderListener l)
	{
		if(this.listeners != null)
			this.listeners.remove(l);
	}
	
	static public interface QESliderListener
	{
		public void changeQEText(int QE);
	}
}


