/* --	
 	Name: 	Andrea Powell
	Game Deck:  Create a deck of cards, manages card values and positions
	
	To Do:
		Shuffle not holding fixed positions
			
*/

package GAPS;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Deck extends JPanel implements ActionListener {
	
	public final Color cardFace = new Color(194,197,170);
	public final Color hunterGreen = new Color(53,94,59);

	private final String[] suits= {"H","C","D","S"};
	
	private Card card, cardSelected, target;
	private Random random;
	
	//  Was using this as part of the cardLock / shuffle mechanism that is not implemented
	private List<Card> cardList;
	
	
	public Deck() {
		super( new GridLayout(4,13,10,10) );
		setBackground(hunterGreen);
		random = new Random(51);

		newDeck(false);
		checkDeck(true);
	}

	
	protected void shuffle() {
		int    intRandom = random.nextInt();
		
		String selectedSuit, selectedText;
		int    selectedValue;
		Card   selectedCard;
		Color  selectedFace  = cardFace;
		Color  targetFace	= cardFace;
		
				
		// Buttons themselves stay in the same spot & are children of the deck
		// The cardList are the cards that are available to shuffle
		
		for (int i=0; i <= 500; i++) {
			// random number between 0 and current size of cardList (count of active cards)
			intRandom = random.nextInt(cardList.size());
			
			cardSelected	= this.cardList.get(intRandom);
			selectedFace	= cardSelected.getBackground();
			selectedSuit 	= cardSelected.getSuit();
			selectedValue 	= cardSelected.getValue();
			selectedText	= cardSelected.getText();
			
			intRandom = random.nextInt(cardList.size());
			//  Random selection of target
			
			target = this.cardList.get(intRandom);
			//targetFace = target.getBackground();
		
			//  The JButton itself stays in the same position, it is the card properties that move around
			//  Could move this to a card.swap() method
			cardSelected.setSuit(target.getSuit());
			cardSelected.setValue(target.getValue());
			cardSelected.setText(target.getText());
			cardSelected.setBackground(target.getBackground());
			
			target.setSuit(selectedSuit);
			target.setValue(selectedValue);
			target.setText(selectedText);
			target.setBackground(selectedFace);
		}
	}

	
	public void newDeck(Boolean isReset) {
		if (isReset) { this.removeAll();}
		this.cardList = new ArrayList<Card>();
		for (String suit : suits) {
			int row = 0;
			for (int value=1; value <= 13; value++) {
				this.card = new Card(suit,value);
				this.card.row = row;
				this.card.column = value;
				if (this.card.value == 1) { this.card.setBlank(); }
				this.card.setVisible(true);
				this.add(card);
				this.cardList.add(card);	// to work with cardLock()
			}
			row ++;
		}
		
		shuffle();
		setVisible(true);
		
	}
	
	
	
	// Move to game logic & make self starting app
	protected boolean checkTwos(Card card) {
		if (card.value == 2 && card.column == 1) {
			// This is a value 2 card in the first column, 
			// lock it in place and send it back to check following cards for runs.
			card.lockCard();
			return true;
		}
		
		return false;
	}
	
	
	public void checkDeck(boolean first) {
		// first = first run of the game

		cardList.forEach(new Consumer<Card>() {

			@Override
			public void accept(Card t) {
				checkTwos(t);
			}
		});
	}
	



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		
}