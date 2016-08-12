/*
 *  Programmer: 	Kyle Neal
 *  Date Created: 	7-3-14
 *  Information:	This is a slider value panel file. This panel simply displays
 *  				the slider values of the respective sliders of interest.
 */

package main.java.gui.comp;

//IMPORT FIELD
//*****************************************
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
//*****************************************


public class SliderValuePanel extends JPanel
{
	//DATA FIELD
	//*****************************************
	static Font f;
	private int QE = 100;
	private int MV;
	private VelocitySlider vs;
	private QuadrantElevationSlider qes;
	private int player;
	private JLabel QEValue;
	private JLabel MVValue;
	private JLabel tankHealth;
	//*****************************************
	
	//FUNCTIONS FIELD
	//*****************************************
	public SliderValuePanel(VelocitySlider vs, QuadrantElevationSlider qes, int player)
	{

		QEValue = new JLabel(new String("QE: " + QE + " mils"));
		MVValue = new JLabel(new String("MV: " + MV + " m/s"));
		tankHealth = new JLabel(new String("Health: " + 100));
		f = new Font("Monospaced", Font.PLAIN, 10);
		QEValue.setFont(f);
		MVValue.setFont(f);
		tankHealth.setFont(f);
		
		this.player = player;
		this.vs = vs;
		this.qes = qes;
		this.qes.addListener(new MyListener(this.player, this.QEValue));
		this.vs.addListener(new MyVelocityListener(this.player, this.MVValue));

		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Data"));
		this.setLayout(new GridLayout(2,2));
		
		this.add(MVValue);
		this.add(QEValue);
		this.add(tankHealth);
	}
	
	public void setHealthPanel(int health)
	{
	
		if(health < 0)
			this.tankHealth.setText("Health: " + 0);
		else
		{
			String s = Integer.toString(health);
			this.tankHealth.setText("Health: " + s);
		}
		
	}
	//*****************************************
	
	static public class MyListener implements main.java.gui.comp.QuadrantElevationSlider.QESliderListener
	{
		private JLabel qelabel;
		
		public MyListener(int player, JLabel qelabel)
		{
			super();
			this.qelabel = qelabel;
			this.qelabel.setFont(f);
		}
		@Override
		public void changeQEText(int QE) 
		{
			this.qelabel.setFont(f);
			this.qelabel.setText("QE: " + QE + " mils");
		}
		
	}
	
	static public class MyVelocityListener implements main.java.gui.comp.VelocitySlider.VelocitySliderListener
	{
		private JLabel mvlabel;
		
		public MyVelocityListener(int player, JLabel mvlabel)
		{
			super();
			this.mvlabel= mvlabel;
			this.mvlabel.setFont(f);
		}
		@Override
		public void changeVelocitySliderListenerText(int MV) 
		{
			this.mvlabel.setFont(f);
			this.mvlabel.setText("MV: " + MV + " m/s");
		}
		
	}
	
}

