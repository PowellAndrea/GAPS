/* --	Name: 	Andrea Powell
	Theme:  Solitaire card game
	Main:   Setup window with Menu Bar & panel for play area
	
	Unimplemented:
		* Selecting a given card should "lock" it into position so that it does not change on the next shuffle
		* Game Logic 
		*   Selected Cards may only move to a blank area
		*   Move is Valid if Selected Card is the same suit as, and one value higher than, card to the target's left
		* 		Does not apply to first row
		*   Two's in the first column are locked into place.
		*   Once a value 2 Card is in the first column, it is locked into place.
		*     Cards to the right, of the same suit, in sequential value, are also locked
*/

package GAPS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	public static JFrame mainWindow;
	public static JPanel gamePanel;
	public static Deck deckPanel;
	
	public static JButton btnQuit, btnNew, btnShuffle;
	public static JMenuBar toolBar;
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		
		mainWindow = new JFrame("Play GAPS for fun and money!");
		mainWindow.setSize(1200, 900);
		mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		// Exit on Close
		
		// Setup Menu Buttons
		btnQuit		= new JButton("Quit");
		btnNew		= new JButton("New") {};
		btnShuffle	= new JButton("Shuffle") {};
		
		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { clickQuit(); }
		});
		
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { clickNew(); }
		});
		
		btnShuffle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { clickShuffle(); }
		});
		
		
		toolBar	= new JMenuBar();
		toolBar.setBackground(new Color(147,102,57));
	
		toolBar.add(btnQuit);
		toolBar.add(btnNew);
		toolBar.add(btnShuffle);

		
		mainWindow.setJMenuBar(toolBar);
		deckPanel = new Deck();
		mainWindow.add(deckPanel);
		mainWindow.pack();
		mainWindow.setVisible(true);
	}	
	
	private static void clickNew() {
		deckPanel= new Deck();
		
	}
	
	public static void clickQuit() {
		mainWindow.dispose();
	}
	
	public static void clickShuffle() {
		deckPanel.shuffle();
	}


}	// End Class
