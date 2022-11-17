
/*
 * NATHEN FERNANDES
 * MR CHUS COMPUTER SCIENCE CLASS
 * DATE 01-22
 */
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import javax.swing.border.Border;

public class CharacterFrame extends JLabel {
	static JButton zukoButton;
	static JButton kataraButton;
	static JButton aangButton;
	static JButton sokkaButton;
	static JButton tophButton;
	static JButton startButton;

	static JLayeredPane characterPane;
	static JButton backButton1;

	static JLabel chooseText;
	Border borderOG;
	String player1;
	String player2;
	ArrayList<JButton> buttonClicked = new ArrayList<JButton>();
	static ArrayList<JButton> allButtons = new ArrayList<JButton>();

	CharacterFrame(ActionListener a) {
		// Choose text text that will display at the top
		ImageIcon rockButton = new ImageIcon("backButton.png");
		chooseText = new JLabel("PLAYER 1 CHOOSE YOUR CHARACTER");
		chooseText.setHorizontalAlignment(JLabel.CENTER);
		chooseText.setBounds(0, 20, 1280, 720);
		chooseText.setIconTextGap(1000);
		chooseText.setVerticalAlignment(JLabel.TOP);
		chooseText.setFont(new Font("FV Almelo", Font.BOLD, 50)); // changes font
		chooseText.setForeground(Color.GREEN);

		// Characterpane
		characterPane = new JLayeredPane();
		characterPane.setBounds(0, 0, 1280, 720);
		JLabel backColor = new JLabel();
		backColor.setBounds(0, 0, 1280, 720);
		backColor.setBackground(new Color(81, 3, 0));
		backColor.setOpaque(true);
		// Zuko Button
		zukoButton = new JButton();
		zukoButton.setBackground(Color.BLACK);
		zukoButton.addActionListener(a);
		zukoButton.setBackground(new Color(0, 139, 139));
		backButton1 = new JButton();
		backButton1.setBounds(0, 0, 250, 100);
		backButton1.setIcon(rockButton);
		backButton1.addActionListener(a);
		backButton1.setBackground(new Color(0, 139, 139));
		kataraButton = new JButton();
		kataraButton.setBackground(Color.BLACK);
		kataraButton.addActionListener(a);
		kataraButton.setBackground(new Color(0, 139, 139));

		// aang button
		aangButton = new JButton();
		aangButton.setBackground(Color.BLACK);
		aangButton.addActionListener(a);
		aangButton.setBackground(new Color(0, 139, 139));

		// Sokka Button
		sokkaButton = new JButton();
		sokkaButton.addActionListener(a);
		sokkaButton.setBackground(new Color(0, 139, 139));

		// Toph Button
		tophButton = new JButton();
		tophButton.addActionListener(a);
		tophButton.setBackground(new Color(0, 139, 139));
		allButtons.add(tophButton);
		allButtons.add(sokkaButton);
		allButtons.add(aangButton);
		allButtons.add(kataraButton);
		allButtons.add(zukoButton);

		// Characters png
		ImageIcon characters = new ImageIcon("characters1.png");
		backColor.setIcon(characters);
		backColor.setVerticalAlignment(JLabel.CENTER);
		backColor.setHorizontalAlignment(JLabel.CENTER);
		zukoButton.setBounds(210, 120, 177, 465);
		kataraButton.setBounds(385, 120, 177, 465);
		aangButton.setBounds(560, 120, 177, 465);
		sokkaButton.setBounds(735, 120, 177, 465);
		tophButton.setBounds(912, 120, 158, 465);

		// sets all buttons to opaque
		zukoButton.setOpaque(false);
		kataraButton.setOpaque(false);
		aangButton.setOpaque(false);
		sokkaButton.setOpaque(false);
		tophButton.setOpaque(false);

		// the orignal border to be reset when the player or bot wins or the player
		// presses the back button
		borderOG = aangButton.getBorder();
		startButton = new JButton();
		startButton.setBounds(515, 0, 250, 100);
		startButton.addActionListener(a);
		startButton.setBackground(new Color(0, 139, 139));
		startButton.setContentAreaFilled(false);
		startButton.setVisible(false);

		// adds everything to the pane
		characterPane.setBackground(new Color(81, 3, 0));
		characterPane.add(backColor, Integer.valueOf(2));
		characterPane.add(chooseText, Integer.valueOf(3));
		characterPane.add(backButton1, Integer.valueOf(3));
		characterPane.add(zukoButton, Integer.valueOf(3));
		characterPane.add(kataraButton, Integer.valueOf(3));
		characterPane.add(aangButton, Integer.valueOf(3));
		characterPane.add(sokkaButton, Integer.valueOf(3));
		characterPane.add(tophButton, Integer.valueOf(3));
		characterPane.add(startButton, Integer.valueOf(3));

	}

	public static JLayeredPane getCharacterFrame() {
		return characterPane;
	}

	public static JLayeredPane getBackButton() {
		return characterPane;
	}

	public static ArrayList<JButton> getButtonArray() {
		allButtons.add(tophButton);
		allButtons.add(sokkaButton);
		allButtons.add(aangButton);
		allButtons.add(kataraButton);
		allButtons.add(zukoButton);
		return allButtons;

	}

	// Methods so the frame manager can get the components
	public static JLabel getChooseText() {
		return chooseText;
	}

	public static JButton getBackButton1() {
		return backButton1;
	}

	public static JButton getStartButton() {
		return startButton;
	}
}
