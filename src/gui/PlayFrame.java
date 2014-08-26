/*
 *  Programmer: 	Kyle Neal
 *  Date Created: 	7-3-14
 *  Information:	This is the Frame where the play field will reside.
 */

package gui;

//IMPORT FIELD
//*****************************************
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import gui.PlayDrawArea;
//*****************************************



public class PlayFrame extends JFrame
{
	//DATA FIELD
	//*****************************************
	private Dimension d;
	private PlayDrawArea drawPanel;
	private PlayerPanel player1;
	private PlayerPanel player2;
	//*****************************************
	
	//FUNCTION FIELD
	//*****************************************
	public PlayFrame()
	{
		this.d = new Dimension(1250, 500);
		this.drawPanel = new PlayDrawArea(new Dimension(850, this.d.height));
		this.player1 = new PlayerPanel(1, new Dimension(200, this.d.height), this.drawPanel);
		this.player2 = new PlayerPanel(2, new Dimension(200, this.d.height), this.drawPanel);
		
		//Give players the other players button
		player1.setOtherPlayerButton(player2.getButton());
		player2.setOtherPlayerButton(player1.getButton());
		
		//Set active button
		player1.getButton().setEnabled(true);
		player2.getButton().setEnabled(false);
		
		
		//Give the player panels to drawPanel
		this.drawPanel.setPlayerPanel(player1, 1);
		this.drawPanel.setPlayerPanel(player2, 2);
		
		
		this.setTitle("TANK WARS");
		this.setSize(d);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//LAYOUT
		//*****************************************
		/*
		 * West; 	 Player 1 Panel
		 * Center:	 Draw Panel
		 * East; 	 Player 2 Panel
		 */
		this.setLayout(new BorderLayout());
		this.add(player1, BorderLayout.WEST);
		this.add(drawPanel, BorderLayout.CENTER);
		this.add(player2, BorderLayout.EAST);

		//*****************************************
		
		this.setVisible(true);
	}
	//*****************************************
}
