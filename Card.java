/* --	
 	Name: 	Andrea Powell
	Card Class: Handles the visual & logical aspects of the card; methods & properties.  
	This class does not implement the actual button instance the logical card will eventually belong to.
	
	Unimplemented:
	*	Playing card graphics for cards
	*	Drag & Drop
	* 	"Hint" button
*/
package GAPS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Card extends JToggleButton implements ActionListener {

	protected Boolean isBlank, isLocked, isActive;
	
	int value, row, column;
	String suit;
	
	public final Color cardFace = new Color(194,197,170);

	
	public Card(String suit, int value) {
		super();
		
		this.suit = suit;
		this.value = value;
		
		setBackground(new Color(53,94,59));
		this.setFont(new Font("Arial", Font.PLAIN, 14));
		this.setText(suit + String.valueOf(value));
		this.setBackground(cardFace);
		this.setPreferredSize(new Dimension(75,100));
		this.isRolloverEnabled();
		this.isLocked = false;
		this.setVisible(true);
	}
			
	
	protected String getSuit() {
		return this.suit;
	}
	
	protected void setSuit(String suit) { 
		this.suit = suit;
	}
	
	protected int getValue() {
		return this.value;
	}
	
	protected void setValue(int value) {
		this.value = value;
	}
	
		
	protected void lockCard() {
		this.isLocked = true;
		this.setEnabled(false);
		this.setBorder((Border) new Color(207,181,159));
		this.setBackground(Color.red);
	}
		
	protected void setBlank() {
		this.isBlank = true;
		this.setText(null);
		this.setBackground(null);	
	}
		

	@Override
	public void actionPerformed(ActionEvent MOUSE_CLICKED) {
		//  for Testing locking mechanism which isn't working :)
		//this.isLocked=true;
		this.setBackground(Color.cyan);
	};

}
