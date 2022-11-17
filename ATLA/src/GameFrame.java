
/*
 * NATHEN FERNANDES
 * MR CHUS COMPUTER SCIENCE CLASS
 * DATE 01-22
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class GameFrame extends JFrame {
	static JLayeredPane gamePane;
	static JButton butAttack1;
	static JButton butAttack2;
	static JButton butAttack3;
	static JButton butAttack4;
	static JLabel characterSprite;
	static JLabel enemySprite;
	static JLabel text;
	static JLabel healthText;
	static JLabel damageMultiplerText;
	static JLabel enemyDamageMultiplerText;
	static JLabel enemyHealthText;
	static JButton quitButton;

	ImageIcon characterImage;
	ImageIcon characterImage1;

	GameFrame(ActionListener actionListener, Character character, Character bot) {
		gamePane = new JLayeredPane();
		// JLabel background = new JLabel("");
		ImageIcon backgroundImage = new ImageIcon("fightingBackground.png");
		ImageIcon heart = new ImageIcon("heart.png");

		JLabel background = new JLabel("", backgroundImage, JLabel.CENTER);
		background.setOpaque(true);
		background.setBounds(0, 0, 1280, 720);
		background.setIcon(backgroundImage);

		text = new JLabel("3");
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setBounds(0, 20, 1280, 720);
		text.setIconTextGap(1000);
		text.setVerticalAlignment(JLabel.TOP);
		text.setFont(new Font("FV Almelo", Font.BOLD, 33)); // changes font
		text.setForeground(new Color(0, 128, 128));

		healthText = new JLabel(character.getCurrentHealth() + "", heart, JLabel.RIGHT);
		healthText.setFont(new Font("FV Almelo", Font.BOLD, 20)); // changes font
		healthText.setForeground(Color.GREEN);
		healthText.setBounds(0, 0, 100, 100);

		// shows the players damage multipler
		damageMultiplerText = new JLabel();
		damageMultiplerText.setFont(new Font("FV Almelo", Font.BOLD, 19)); // changes font
		damageMultiplerText.setForeground(Color.GREEN);
		damageMultiplerText.setBounds(20, 0, 190, 200);
		damageMultiplerText.setText("DAMAGE MULTIPLED : " + character.getDamageMultipler() + "x");

		// shows the enemys damage multipler
		enemyDamageMultiplerText = new JLabel();
		enemyDamageMultiplerText.setFont(new Font("FV Almelo", Font.BOLD, 19)); // changes font
		enemyDamageMultiplerText.setForeground(Color.red);
		enemyDamageMultiplerText.setBounds(1080, 0, 190, 200);
		enemyDamageMultiplerText.setText("DAMAGE MULTIPLED : " + bot.getDamageMultipler() + "x");

		enemyHealthText = new JLabel(bot.getCurrentHealth() + "", heart, JLabel.LEFT);
		enemyHealthText.setFont(new Font("FV Almelo", Font.BOLD, 20)); // changes font
		enemyHealthText.setForeground(Color.RED);
		enemyHealthText.setBounds(1150, 0, 100, 100);

		// sets player starting idle animation
		if (character.toString().equals("Zuko")) {
			characterImage = new ImageIcon("zuko.gif");
		} else if (character.toString().equals("Aang")) {
			characterImage = new ImageIcon("aangIdle.gif");
		} else if (character.toString().equals("Katara")) {
			characterImage = new ImageIcon("kataraIdle.gif");
		} else if (character.toString().equals("Toph")) {
			characterImage = new ImageIcon("tophIdle.gif");
		} else if (character.toString().equals("Sokka")) {
			characterImage = new ImageIcon("sokkaIdle.gif");
		}
		// sets bots animation
		if (bot.toString().equals("Zuko")) {
			characterImage1 = new ImageIcon("zukoFlipped.gif");
		} else if (bot.toString().equals("Aang")) {
			characterImage1 = new ImageIcon("aangFlipped.gif");
		} else if (bot.toString().equals("Katara")) {
			characterImage1 = new ImageIcon("kataraFlipped.gif");
		} else if (bot.toString().equals("Toph")) {
			characterImage1 = new ImageIcon("tophFlipped.gif");
		} else if (bot.toString().equals("Sokka")) {
			characterImage1 = new ImageIcon("sokkaFlipped.gif");
		}

		// charcterSprite Label
		characterSprite = new JLabel("", characterImage, JLabel.CENTER);
		characterSprite.setOpaque(false);
		characterSprite.setBounds(250, 50, 600, 590);
		characterSprite.setIcon(characterImage);

		// Enemy sprite Label
		enemySprite = new JLabel("sdfdsf", characterImage1, JLabel.CENTER);
		enemySprite.setOpaque(false);
		enemySprite.setBounds(450, 50, 600, 590);
		enemySprite.setIcon(characterImage1);
		text.setText("FIGHT");

		// Move 1 button
		butAttack1 = new JButton();
		butAttack1.setBounds(70, 480, 250, 100);
		butAttack1.addActionListener(actionListener);
		butAttack1.setForeground(Color.BLUE);
		butAttack1.setFont(new Font("FV Almelo", Font.BOLD, 25)); // changes font
		butAttack1.setText(character.printAttack(0));
		butAttack1.setBackground(Color.orange);

		// Move 2 button
		butAttack2 = new JButton();
		butAttack2.setBounds(370, 480, 250, 100);
		butAttack2.addActionListener(actionListener);
		butAttack2.setForeground(Color.BLUE);
		butAttack2.setFont(new Font("FV Almelo", Font.BOLD, 25)); // changes font
		butAttack2.setText(character.printAttack(1));
		butAttack2.setBackground(Color.orange);

		// Move 3 button
		butAttack3 = new JButton();
		butAttack3.setBounds(670, 480, 250, 100);
		butAttack3.addActionListener(actionListener);
		butAttack3.setForeground(Color.BLUE);
		butAttack3.setFont(new Font("FV Almelo", Font.BOLD, 25)); // changes font
		butAttack3.setText(character.printAttack(2));
		butAttack3.setBackground(Color.orange);

		// Move 4 button
		butAttack4 = new JButton();
		butAttack4.setBounds(970, 480, 250, 100);
		butAttack4.addActionListener(actionListener);
		butAttack4.setForeground(Color.BLUE);
		butAttack4.setFont(new Font("FV Almelo", Font.BOLD, 25)); // changes font
		butAttack4.setText(character.printAttack(3));
		butAttack4.setBackground(Color.orange);

		// quitButton for when someone wins
		ImageIcon airButton = new ImageIcon("quitButton.png");
		quitButton = new JButton();
		quitButton.setIcon(airButton);
		quitButton.addActionListener(actionListener);
		quitButton.setBounds(515, 200, 250, 100);
		quitButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		quitButton.setVisible(false);

		// sets bounds and foreground and then adds all the components
		gamePane.setBounds(0, 0, 1280, 720);
		gamePane.setForeground(Color.BLACK);
		gamePane.add(background, Integer.valueOf(0));
		gamePane.add(text, Integer.valueOf(1));
		gamePane.add(characterSprite, Integer.valueOf(1));
		gamePane.add(butAttack1, Integer.valueOf(1));
		gamePane.add(butAttack2, Integer.valueOf(1));
		gamePane.add(butAttack3, Integer.valueOf(1));
		gamePane.add(butAttack4, Integer.valueOf(1));
		gamePane.add(healthText, Integer.valueOf(1));
		gamePane.add(enemyHealthText, Integer.valueOf(1));
		gamePane.add(enemySprite, Integer.valueOf(1));
		gamePane.add(quitButton, Integer.valueOf(1));
		gamePane.add(damageMultiplerText, Integer.valueOf(1));
		gamePane.add(enemyDamageMultiplerText, Integer.valueOf(1));

	}

	// for the FrameManager to get everything
	public static JLayeredPane getGamePanel() {
		return gamePane;
	}

	public static JButton getbutAttack1() {
		return butAttack1;
	}

	public static JButton getbutAttack2() {
		return butAttack2;
	}

	public static JButton getbutAttack3() {
		return butAttack3;
	}

	public static JButton getbutAttack4() {
		return butAttack4;
	}

	public static JLabel getCharacterSprite() {
		return characterSprite;
	}

	public static JLabel getEnemySprite() {
		return characterSprite;
	}

	public static JLabel getFightText() {
		return text;
	}

	public static JLabel getHealthText() {
		return healthText;
	}

	public static JLabel getEnemyHealthText() {
		return enemyHealthText;
	}

	public static JButton getFinalQuitButton() {
		return quitButton;
	}

	public static JLabel getDamageMultiplerText() {
		return damageMultiplerText;
	}

	public static JLabel getEnemyDamageMultiplerText() {
		return enemyDamageMultiplerText;
	}

}
