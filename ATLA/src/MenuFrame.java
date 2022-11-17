
/*
 * NATHEN FERNANDES
 * MR CHUS COMPUTER SCIENCE CLASS
 * DATE 01-22
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JSlider;
import javax.swing.border.Border;

public class MenuFrame extends JLabel {
	static JButton playButton;
	static JButton optionsButton;
	static JButton quitButton;
	static JLayeredPane menuPane;
	static JLayeredPane optionsPane;
	JLayeredPane characterPane;
	String player;
	static Clip clip;
	static Clip clip2;
	Boolean isMenu = true;
	Boolean isPlay = false;
	Boolean isOptions = false;
	Boolean isPlaying = false;
	static JSlider slider;
	static JButton backButton;

	MenuFrame(ActionListener actionListener) throws FileNotFoundException {
		JLabel text = new JLabel("AVATAR THE LAST AIR BENDER");
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setBounds(0, 20, 1280, 720);
		text.setIconTextGap(1000);
		text.setVerticalAlignment(JLabel.TOP);
		text.setFont(new Font("FV Almelo", Font.BOLD, 50)); // changes font
		text.setForeground(new Color(0, 128, 128));

		// JLabel background = new JLabel("");
		ImageIcon backgroundImage = new ImageIcon("background.png");
		JLabel background = new JLabel("", backgroundImage, JLabel.CENTER);
		background.setOpaque(true);
		background.setLayout(new GridBagLayout());
		background.setBounds(0, 0, 1280, 720);
		background.setIcon(backgroundImage);

		Border border = BorderFactory.createLineBorder(Color.ORANGE, 3);
		JLabel borderLabel = new JLabel();
		borderLabel.setBounds(0, 0, 1280, 720);
		borderLabel.setBorder(border);

		Character zuko = new Character("Zuko");
		/*
		 * ZUKO MOVES 0 = Fire Blast 1= Sunny Day 2 = Fire Charge Up 3 = Lightning Bolt
		 */
		/*
		 * zuko.getCharacter(); zuko.printAttack(2); for (int i = 0; i < 100; i++) {
		 * System.out.println(zuko.getAttack(2)); }
		 */
		menuPane = new JLayeredPane();
		menuPane.setBounds(0, 0, 1280, 720);
		menuPane.setForeground(Color.BLACK);
		menuPane.add(background, Integer.valueOf(0));
		menuPane.add(text, Integer.valueOf(1));
//menuPane.add(borderLabel,Integer.valueOf(15));
		menuPane.setBorder(border);

		playButton = new JButton();
		playButton.setBounds(515, 169, 250, 100);
		playButton.addActionListener(actionListener);
		playButton.setForeground(Color.orange);
		playButton.setBackground(new Color(0, 139, 139));
		playButton.setOpaque(false);
		playButton.setContentAreaFilled(true);
		ImageIcon waterButton = new ImageIcon("playButton.png");
		playButton.setIcon(waterButton);
		playButton.setVerticalAlignment(JButton.CENTER);
		playButton.setHorizontalAlignment(JButton.CENTER);
		playButton.setHorizontalTextPosition(JButton.CENTER);
		playButton.setVerticalTextPosition(JButton.BOTTOM);
		playButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

		optionsButton = new JButton();
		optionsButton.setBounds(515, 319, 250, 100);
		optionsButton.addActionListener(actionListener);
		optionsButton.setForeground(Color.orange);
		optionsButton.setBackground(new Color(0, 139, 139));
		optionsButton.setOpaque(false);
		optionsButton.setContentAreaFilled(false);
		ImageIcon fireButton = new ImageIcon("optionsButton.png");
		optionsButton.setIcon(fireButton);
		optionsButton.setVerticalAlignment(JButton.CENTER);
		optionsButton.setHorizontalAlignment(JButton.CENTER);
		optionsButton.setHorizontalTextPosition(JButton.CENTER);
		optionsButton.setVerticalTextPosition(JButton.BOTTOM);
		optionsButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

		quitButton = new JButton();
		quitButton.setBounds(515, 469, 250, 100);
		quitButton.addActionListener(actionListener);
		quitButton.setForeground(Color.orange);
		quitButton.setBackground(new Color(0, 139, 139));
		quitButton.setOpaque(false);
		quitButton.setContentAreaFilled(false);

		ImageIcon airButton = new ImageIcon("quitButton.png");
		quitButton.setIcon(airButton);
		quitButton.setVerticalAlignment(JButton.CENTER);
		quitButton.setHorizontalAlignment(JButton.CENTER);
		quitButton.setHorizontalTextPosition(JButton.CENTER);
		quitButton.setVerticalTextPosition(JButton.BOTTOM);
		quitButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		menuPane.add(optionsButton, Integer.valueOf(3));
		menuPane.add(playButton, Integer.valueOf(3));
		menuPane.add(quitButton, Integer.valueOf(3));
	}

	public static JButton getOptionsButton() {
		return optionsButton;
	}

	public static JButton getPlayButton() {
		return playButton;
	}

	public static JButton getQuitButton() {
		return quitButton;
	}

	public static JLayeredPane getMenuPane() {
		return menuPane;
	}
}
