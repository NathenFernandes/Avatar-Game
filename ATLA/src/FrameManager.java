
/*
 * NATHEN FERNANDES
 * MR CHUS COMPUTER SCIENCE CLASS
 * DATE 01-22
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JSlider;
import javax.swing.border.Border;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FrameManager extends JFrame implements ActionListener, ChangeListener {
	// VARIABLES
	JButton playButton;
	JButton optionsButton;
	FloatControl gainControl;
	JLabel healthText;
	JLabel enemyHealthText;
	JLabel damageMultiplerText;
	FloatControl gainControl1;
	int num1;
	int frozen;
	int damage;
	Boolean attackClicked = false;
	Boolean enemyTurn = false;
	Character mainCharacter;
	Character bot;
	JButton quitButton;
	JLayeredPane menuPane;
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
	static JSlider slider1;
	static JButton backButton;
	JButton backButton1;
	JButton startButton;
	JButton zukoButton;
	JButton kataraButton;
	JButton aangButton;
	Boolean game = true;
	JButton sokkaButton;
	JButton tophButton;
	JButton finalQuitButton;
	JLayeredPane gamePane;
	JButton butAttack1;
	JButton butAttack2;
	JButton butAttack3;
	JButton butAttack4;
	JLabel fightText;
	JLabel enemyDamageMultiplerText;
	JLabel chooseText;
	Border borderOG;
	String player1;
	JLabel characterSprite;
	JLabel enemySprite;
	String player2;
	ImageIcon characterAttack1;
	ImageIcon characterIdle;

	// Array lists that track the buttons clicked in the character choosing menu
	ArrayList<JButton> buttonClicked = new ArrayList<JButton>();
	// Stores all the buttons for comparison
	ArrayList<JButton> allButtons = new ArrayList<JButton>();

	static AudioInputStream audioInput1;

	// FrameManager
	FrameManager() throws InterruptedException, FileNotFoundException {
		this.setSize(1296, 720);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if (isMenu == true) {
			MenuFrame menuFrame = new MenuFrame(this);
			// MENU FRAME
			menuPane = menuFrame.getMenuPane();
			optionsButton = menuFrame.getOptionsButton();
			playButton = menuFrame.getPlayButton();
			quitButton = menuFrame.getQuitButton();

			this.setResizable(false);

			// OPTIONS FRAME
			optionsPane = OptionsFrame.getFrame();
			OptionsFrame optionsFrame = new OptionsFrame(this, this, this);
			slider = optionsFrame.getSlider();
			optionsPane = OptionsFrame.getFrame();
			backButton = OptionsFrame.getBackButton();
			slider1 = OptionsFrame.getSlider1();
			if (clip == null) {
				playMusic("menuMusic.wav");
				gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(slider.getValue());
			}

			// CHARACTER SELECTION FRAME
			CharacterFrame characterFrame = new CharacterFrame(this);
			characterPane = characterFrame.getCharacterFrame();
			allButtons = characterFrame.getButtonArray();
			chooseText = characterFrame.getChooseText();
			backButton1 = characterFrame.getBackButton1();

			// adds the buttons to the array list
			tophButton = allButtons.get(0);
			sokkaButton = allButtons.get(1);
			aangButton = allButtons.get(2);
			kataraButton = allButtons.get(3);
			zukoButton = allButtons.get(4);
			startButton = characterFrame.getStartButton();
			borderOG = aangButton.getBorder();

			// ADDING/SETTING VISABILTY
			this.add(characterPane);
			characterPane.setVisible(false);
			optionsPane.setVisible(false);
			menuPane.setVisible(true);
			this.add(menuPane);
			this.setVisible(true);

		}
	}

	// AUDIO MANAGER
	public static void playMusic(String filepath) {
		InputStream music;
		File musicPath = new File(filepath);
		File clickPath = new File("click.wav");

		try {
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
			audioInput1 = AudioSystem.getAudioInputStream(clickPath);
			clip = AudioSystem.getClip();
			// clip2 = AudioSystem.getClip();

			clip.open(audioInput);
			// clip2.open(audioInput1);
			clip.start();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		try {
			audioInput1.close();
			File clickPath = new File("click.wav");
			audioInput1 = AudioSystem.getAudioInputStream(clickPath);
			clip2 = AudioSystem.getClip();
			clip2.open(audioInput1);
		} catch (Exception d) {
			System.out.println(d);
		}
		// Sets the volume based on the slider for the click sound
		gainControl1 = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl1.setValue(slider1.getValue());
		if (e.getSource() == finalQuitButton) {
			player1 = null;
			player2 = null;
			startButton.setVisible(false);
			chooseText.setText("PLAYER 1 CHOOSE YOUR CHARACTER");
			chooseText.setForeground(Color.GREEN);
			e.setSource(null);
			for (int i = 0; i < allButtons.size(); i++) {
				allButtons.get(i).setEnabled(true);
				allButtons.get(i).setBorder(borderOG);
			}
			gamePane.setVisible(false);
			menuPane.setVisible(true);
			clip2.start();
		}
		if (e.getSource() == startButton) {
			System.out.println("Start Button was clicked");
			buttonClicked.remove(1);
			buttonClicked.remove(0);

			try {
				mainCharacter = new Character(player1);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				bot = new Character(player2);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			GameFrame gameFrame = new GameFrame(this, mainCharacter, bot);

			finalQuitButton = GameFrame.getFinalQuitButton();
			// Intilizes game frame and the components within it
			gamePane = gameFrame.getGamePanel();
			butAttack1 = gameFrame.getbutAttack1();
			butAttack2 = gameFrame.getbutAttack2();
			damageMultiplerText = gameFrame.getDamageMultiplerText();
			enemyDamageMultiplerText = gameFrame.getEnemyDamageMultiplerText();
			butAttack3 = gameFrame.getbutAttack3();
			butAttack4 = gameFrame.getbutAttack4();
			characterSprite = gameFrame.getCharacterSprite();
			enemySprite = gameFrame.getEnemySprite();
			healthText = gameFrame.getHealthText();
			enemyHealthText = gameFrame.getEnemyHealthText();
			fightText = gameFrame.getFightText();
			this.add(gamePane);
			characterPane.setVisible(false);
			gamePane.setVisible(true);
			int time;
			if (mainCharacter.toString().equals("Katara") && mainCharacter.getCurrentHealth() == 100) {
				butAttack2.setEnabled(false);
			}
			// sets the animation for the players in the game
			if (player1.equals("Zuko")) {
				characterAttack1 = new ImageIcon("zukoFireBlast.gif");
				characterIdle = new ImageIcon("zuko.gif");
			}
			if (player1.equals("Katara")) {
				characterAttack1 = new ImageIcon("kataraAttack1.gif");
				characterIdle = new ImageIcon("kataraIdle.gif");
			}
			if (player1.equals("Toph")) {
				characterAttack1 = new ImageIcon("tophAttack2.gif");
				characterIdle = new ImageIcon("tophIdle.gif");
			}
			if (player1.equals("Aang")) {
				characterAttack1 = new ImageIcon("aangAttack.gif");
				characterIdle = new ImageIcon("aangIdle.gif");
			}
			if (player1.equals("Sokka")) {
				characterAttack1 = new ImageIcon("sokkaIdle.gif");
				characterIdle = new ImageIcon("sokkaIdle.gif");
			} else {

			}

		}
		// For when the player clicks attacks
		if (e.getSource() == butAttack1 && enemyTurn == false && gamePane != null) {
			characterSprite.setIcon(characterAttack1);
			damage = mainCharacter.getAttack(0);
			num1 = 0;
			attackClicked = true;
		}
		if (e.getSource() == butAttack2 && enemyTurn == false && gamePane != null) {
			characterSprite.setIcon(characterAttack1);
			damage = mainCharacter.getAttack(1);
			num1 = 1;
			attackClicked = true;
		}
		if (e.getSource() == butAttack3 && enemyTurn == false && gamePane != null) {
			characterSprite.setIcon(characterAttack1);
			damage = mainCharacter.getAttack(2);
			num1 = 2;
			attackClicked = true;
		}
		if (e.getSource() == butAttack4 && enemyTurn == false && gamePane != null) {
			characterSprite.setIcon(characterAttack1);
			damage = mainCharacter.getAttack(3);
			num1 = 3;
			attackClicked = true;

		}
		// To show the player the move he did as well as the result
		if (enemyTurn == false && gamePane != null && attackClicked == true) {
			clip2.start();
			if (mainCharacter.printAttack(num1) == "Rock Pellets") {
				fightText.setText("YOU USED " + mainCharacter.printAttack(num1) + ", YOU DID " + damage + " DAMAGE"
						+ "(" + damage / 3 + " pellets!)");
				bot.setHealth(damage);
			} else if (damage == -9) {
				fightText.setText("YOU USED " + mainCharacter.printAttack(num1)
						+ ", YOUR DAMAGE MULTIPLER WAS INCREASE TO " + mainCharacter.getDamageMultipler());
			} else if (damage == -11) {
				fightText.setText("YOU USED " + mainCharacter.printAttack(num1) + " YOU ARE CHARING UP!");
			} else if (damage == -55 || damage == -100) {
				fightText.setText("YOU TRIED " + mainCharacter.printAttack(num1) + " BUT IT FAILED");
			} else if (damage == -99) {
				fightText.setText("YOU USED " + mainCharacter.printAttack(num1) + " ENEMY IS FROZEN FOR 2 TURNS!");
				frozen = 2;
			} else if (damage == -15) {
				if (mainCharacter.getCurrentHealth() + 15 >= 100) {
					fightText.setText("YOU USED " + mainCharacter.printAttack(num1) + " AND NOW HAVE 100HP");
					mainCharacter.setFinalHealth(100);
					healthText.setText(mainCharacter.getCurrentHealth() + "");
				} else {
					fightText.setText("YOU USED " + mainCharacter.printAttack(num1) + " AND REGAINED 15 HEALTH!");
					mainCharacter.setFinalHealth(mainCharacter.getCurrentHealth() + 15);
					healthText.setText(mainCharacter.getCurrentHealth() + "");
				}
			} else {
				fightText.setText("YOU USED " + mainCharacter.printAttack(num1) + ", YOU DID " + damage + " DAMAGE");
				bot.setHealth(damage);
			}
			// If the player is frozen
			if (!(frozen > 0)) {
				enemyTurn = true;
			}

			else {
				if (frozen == 1) {
					fightText.setText("ENEMY IS FROZEN FOR 1 MORE TURN!");
				}
				characterSprite.setIcon(characterIdle);
				frozen--;
			}
			// Prevents the game from bugging
			attackClicked = false;
			enemyHealthText.setText(bot.getCurrentHealth() + "");
			damageMultiplerText.setText("DAMAGE MULTIPLED : " + mainCharacter.getDamageMultipler() + "x");

		}
		// For the animations tracks time
		if (gamePane != null && enemyTurn == true) {
			new java.util.Timer().schedule(new java.util.TimerTask() {
				public void run() {
					characterSprite.setIcon(characterIdle);
				}
			}, 500);
			new java.util.Timer().schedule(new java.util.TimerTask() {
				public void run() {
					if (game == true) {
						fightText.setText("ENEMYS MOVE");
					}
				}
			}, 2000);

			// Win check for player
			if (bot.getCurrentHealth() < 1) {
				bot.setFinalHealth(0);
				enemySprite.setEnabled(false);
				fightText.setText("YOU WIN CONGRATULATIONS!");
				fightText.setFont(new Font("FV Almelo", Font.BOLD, 50)); // changes font
				butAttack1.setEnabled(false);
				butAttack2.setEnabled(false);
				finalQuitButton.setVisible(true);
				butAttack3.setEnabled(false);
				butAttack4.setEnabled(false);
				enemyTurn = false;
				game = false;
				attackClicked = false;
				healthText.setText(mainCharacter.getCurrentHealth() + "");
				enemyHealthText.setText(bot.getCurrentHealth() + "");
			} else if (mainCharacter.getCurrentHealth() < 1) { // Win check for bot
				mainCharacter.setFinalHealth(0);
				characterSprite.setEnabled(false);
				fightText.setText("YOU LOST!");
				fightText.setFont(new Font("FV Almelo", Font.BOLD, 50)); // changes font
				butAttack1.setEnabled(false);
				butAttack2.setEnabled(false);
				finalQuitButton.setVisible(true);
				butAttack3.setEnabled(false);
				game = false;
				butAttack4.setEnabled(false);
				enemyTurn = false;
				healthText.setText(mainCharacter.getCurrentHealth() + "");
				enemyHealthText.setText(bot.getCurrentHealth() + "");
				attackClicked = false;
			}
			butAttack1.setEnabled(false);
			butAttack2.setEnabled(false);
			butAttack3.setEnabled(false);
			butAttack4.setEnabled(false);
		}

		if (enemyTurn == true) { // when its the enemies turn
			new java.util.Timer().schedule(new java.util.TimerTask() {
				public void run() {
					Random rand = new Random();
					int random = rand.nextInt(4);
					int num = random;
					if (bot.getCharge() == 1) {
						if (bot.toString().equals("Zuko") || bot.toString().equals("Aang")) {
							num = 2;
						} else if (bot.toString().equals("Toph")) {
							num = 3;
						}
					} else if (mainCharacter.getCurrentHealth() < 15) {
						num = 0;
					} else if (bot.getCurrentHealth() > 85 && bot.getCharacter().equals("Katara") && num == 1) {
						num = 0;
					}
					int damage = bot.getAttack(num);
					System.out.println("NUM: " + num + "  DAMGE:" + damage + "  ATTACK:" + bot.printAttack(num)
							+ "  MULT:" + bot.getDamageMultipler() + "  CHARGE:" + bot.getCharge());
					if (bot.printAttack(random) == "Rock Pellets") { // Shows the player the moves the bot made as well
																		// as the result
						fightText.setText("ENEMY USED " + bot.printAttack(num) + ", YOU TOOK " + damage + " DAMAGE"
								+ "(" + damage / 3 + " PELLETS!)");
						mainCharacter.setHealth(damage);
					}
					if (bot.printAttack(random) == "Air Swipes") {
						fightText.setText("ENEMY USED " + bot.printAttack(num) + ", YOU TOOK " + damage + " DAMAGE"
								+ "(" + damage / 3 + " SWIPES!)");
						mainCharacter.setHealth(damage);
					}
					if (bot.printAttack(random) == "Boomerang") {
						fightText.setText("ENEMY USED " + bot.printAttack(num) + ", YOU TOOK " + damage + " DAMAGE"
								+ "(" + damage / 8 + " HITS!)");
						mainCharacter.setHealth(damage);
					} else if (damage == -9) {
						fightText.setText("ENEMY USED " + bot.printAttack(num)
								+ ", THEIR DAMAGE MULTIPLER WAS INCREASE TO " + bot.getDamageMultipler());
					} else if (damage == -11) {
						fightText.setText("ENEMY USED " + bot.printAttack(num) + " THEY ARE CHARGING UP!");
					} else if (damage == -55 || damage == -100) {
						fightText.setText("ENEMY TRIED " + bot.printAttack(num) + " BUT IT FAILED");
					} else if (damage == -99) {
						fightText.setText("ENEMY USED " + bot.printAttack(num) + " YOUR FROZEN FOR 1 TURN!");
					} else if (damage == -15) {
						fightText.setText("ENEMY USED " + bot.printAttack(num) + " AND GAINED 15 HEALTH!");
						bot.setHealth(-15);
						enemyHealthText.setText(bot.getCurrentHealth() + "");
					} else {
						fightText.setText("ENEMY USED " + bot.printAttack(num) + ", YOU TOOK " + damage + " DAMAGE");
						mainCharacter.setHealth(damage);
					}
					healthText.setText(mainCharacter.getCurrentHealth() + "");
					new java.util.Timer().schedule(new java.util.TimerTask() {
						public void run() {
						}
					}, 2000);
					enemyHealthText.setText(bot.getCurrentHealth() + "");
					enemyDamageMultiplerText.setText("DAMAGE MULTIPLED : " + bot.getDamageMultipler() + "x");
					if (damage != -99) {
						enemyTurn = false;
					} else {
						enemyTurn = true;
					}
					// Win check for player
					if (bot.getCurrentHealth() < 1) {
						bot.setFinalHealth(0);
						enemySprite.setEnabled(false);
						fightText.setText("YOU WIN CONGRATULATIONS!"); // shows a congrats message
						butAttack1.setEnabled(false);
						butAttack2.setEnabled(false);
						butAttack3.setEnabled(false);
						game = false;
						finalQuitButton.setVisible(true); // sets quit button visable
						attackClicked = false;
						fightText.setFont(new Font("FV Almelo", Font.BOLD, 50)); // changes font
						butAttack4.setEnabled(false);
						enemyTurn = false; // prevents game from looping
						healthText.setText(mainCharacter.getCurrentHealth() + "");
						enemyHealthText.setText(bot.getCurrentHealth() + "");
					} else if (mainCharacter.getCurrentHealth() < 1) { // Win check for Bot
						mainCharacter.setFinalHealth(0);
						characterSprite.setEnabled(false);
						fightText.setText("YOU LOST!");
						butAttack1.setEnabled(false);
						butAttack2.setEnabled(false);
						attackClicked = false;
						game = false;
						fightText.setFont(new Font("FV Almelo", Font.BOLD, 50)); // changes font
						finalQuitButton.setVisible(true);
						butAttack3.setEnabled(false);
						butAttack4.setEnabled(false);
						enemyTurn = false; // prevents game from looping
						healthText.setText(mainCharacter.getCurrentHealth() + "");
						enemyHealthText.setText(bot.getCurrentHealth() + "");
					}
					butAttack1.setEnabled(true);
					if (mainCharacter.toString().equals("Katara") && mainCharacter.getCurrentHealth() > 99) {
						butAttack2.setEnabled(false);
					} else {
						butAttack2.setEnabled(true);
					}
					butAttack3.setEnabled(true);
					butAttack4.setEnabled(true);
				}
			}, 2000);

		}

		if (e.getSource() == playButton) {
			System.out.println("Play Button was clicked");
			menuPane.setVisible(false);
			characterPane.setVisible(true);

			clip2.start();
		}
		if (e.getSource() == optionsButton) {
			System.out.println("Options Button was clicked");
			clip2.start();
			menuPane.setVisible(false);
			optionsPane.setVisible(true);
			// menuPane.setVisible(true);
		}
		if (e.getSource() == quitButton) {
			this.dispose();
			clip2.start();
			clip.close();
			clip.stop();
		}
		if (e.getSource() == backButton) {
			optionsPane.setVisible(false);
			menuPane.setVisible(true);

			clip2.start();

		}
		if (e.getSource() == backButton1) { // Back button in the menu
			if (player1 == null && player2 == null) {
				optionsPane.setVisible(false);
				menuPane.setVisible(true);
				startButton.setVisible(false);
				characterPane.setVisible(false);
			} else if (player1 != null && player2 == null) {
				player1 = null;
				player2 = null;
				startButton.setVisible(false);
				buttonClicked.get(0).setBorder(borderOG);
				buttonClicked.get(0).setEnabled(true);
				chooseText.setText("PLAYER 1 CHOOSE YOUR CHARACTER");
				chooseText.setForeground(Color.GREEN);
				buttonClicked.remove(0);
			} else if (player1 != null && player2 != null) {
				buttonClicked.get(1).setBorder(borderOG);
				buttonClicked.get(1).setEnabled(true);
				startButton.setVisible(false);
				chooseText.setText("CHOOSE AI CHARACTER");
				buttonClicked.remove(1);
				player2 = null;
				for (int i = 0; i < allButtons.size(); i++) {
					if (allButtons.get(i) != buttonClicked.get(0)) {
						allButtons.get(i).setEnabled(true);
					}
				}
			}
			clip2.start();

		}
		/*
		 * if (e.getSource() == aangButton) {
		 * 
		 * if (player1 == (null)) { Border border =
		 * BorderFactory.createLineBorder(Color.WHITE, 3); aangButton.setBorder(border);
		 * buttonClicked.add(aangButton); buttonClicked.get(0).setEnabled(true); player1
		 * = "Aang"; chooseText.setText("PLAYER 2 CHOOSE YOUR CHARACTER");
		 * 
		 * chooseText.setForeground(Color.MAGENTA);
		 * buttonClicked.get(0).setEnabled(false); } }
		 */
		if (e.getSource() == tophButton || e.getSource() == aangButton || e.getSource() == sokkaButton
				|| e.getSource() == zukoButton || e.getSource() == kataraButton) {
			buttonClicked.add((JButton) e.getSource());

			if (e.getSource() == tophButton) {
				player = "Toph";
			}
			if (e.getSource() == aangButton) {
				player = "Aang";
			}
			if (e.getSource() == sokkaButton) {
				player = "Sokka";
			}
			if (e.getSource() == kataraButton) {
				player = "Katara";
			}
			if (e.getSource() == zukoButton) {
				player = "Zuko";
			}
			if (player1 == (null)) {
				Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
				buttonClicked.get(0).setBorder(border);
				buttonClicked.get(0).setEnabled(true);
				player1 = player;
				chooseText.setText("CHOOSE AI CHARACTER");
				chooseText.setForeground(Color.RED);
				startButton.setVisible(false);
				buttonClicked.get(0).setEnabled(false);
			} else if (player1 != null && player2 == null) {
				Border border = BorderFactory.createLineBorder(Color.RED, 3);
				player2 = player;
				buttonClicked.get(1).setBorder(border);
				buttonClicked.get(1).setEnabled(true);
				chooseText.setText("START GAME");
				startButton.setVisible(true);
				buttonClicked.get(0).setEnabled(false);
				buttonClicked.get(1).setEnabled(false);
				for (int i = 0; i < allButtons.size(); i++) {
					allButtons.get(i).setEnabled(false);
				}
			}
			clip2.start();
		}
		System.out.println("PLAYER1 = " + player1);
		System.out.println("PLAYER2 = " + player2);

		e.setSource(null);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(slider.getValue());
		gainControl1 = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl1.setValue(slider1.getValue());
	}
}