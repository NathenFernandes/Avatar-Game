import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

public class OptionsFrame extends JLabel {
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

	OptionsFrame(ChangeListener a, ActionListener b, JFrame c) {
		JLabel optionsText = new JLabel("OPTIONS");
		optionsText.setHorizontalAlignment(JLabel.CENTER);
		optionsText.setBounds(0, 20, 1280, 720);
		optionsText.setIconTextGap(1000);
		optionsText.setVerticalAlignment(JLabel.TOP);
		optionsText.setFont(new Font("FV Almelo", Font.BOLD, 50)); // changes font
		optionsText.setForeground(new Color(0, 128, 128));

		JLabel musicText = new JLabel("MUSIC");
		musicText.setHorizontalAlignment(JLabel.CENTER);
		musicText.setBounds(0, 20, 1280, 200);
		musicText.setIconTextGap(1000);
		musicText.setVerticalAlignment(JLabel.BOTTOM);
		musicText.setFont(new Font("FV Almelo", Font.BOLD, 50)); // changes font
		musicText.setForeground(new Color(0, 128, 128));

		JLabel soundText = new JLabel("SOUND EFFECTS");
		soundText.setHorizontalAlignment(JLabel.CENTER);
		soundText.setBounds(0, 20, 1280, 350);
		soundText.setIconTextGap(1000);
		soundText.setVerticalAlignment(JLabel.BOTTOM);
		soundText.setFont(new Font("FV Almelo", Font.BOLD, 50)); // changes font
		soundText.setForeground(new Color(0, 128, 128));

		optionsPane = new JLayeredPane();
		optionsPane.setBounds(0, 0, 1280, 720);
		optionsPane.setForeground(Color.BLACK);
		optionsPane.add(optionsText, Integer.valueOf(1));
		optionsPane.add(musicText, Integer.valueOf(1));
		optionsPane.add(soundText, Integer.valueOf(1));

		slider = new JSlider(-80, 6, -20);
		slider.setBounds(440, 150, 400, 200);
		slider.setOpaque(false);

		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(10);

		slider.setPaintTrack(true);
		// slider.setMajorTickSpacing(25);

		slider.setPaintLabels(true);
		slider.addChangeListener(a);

		slider1 = new JSlider(-80, 6, -20);
		slider1.setBounds(440, 350, 400, 150);
		slider1.setOpaque(false);

		slider1.setPaintTicks(true);
		slider1.setMinorTickSpacing(10);

		slider1.setPaintTrack(true);
		// slider.setMajorTickSpacing(25);

		slider1.setPaintLabels(true);
		slider1.addChangeListener(a);
		ImageIcon backgroundImage1 = new ImageIcon("background.png");
		ImageIcon rockButton = new ImageIcon("backButton.png");

		JLabel background1 = new JLabel("", backgroundImage1, JLabel.CENTER);
		backButton = new JButton();
		backButton.setBounds(515, 500, 250, 100);
		backButton.setIcon(rockButton);
		backButton.addActionListener(b);
		backButton.setForeground(Color.orange);
		backButton.setBackground(new Color(0, 139, 139));

		background1.setOpaque(true);
		background1.setLayout(new GridBagLayout());
		background1.setBounds(0, 0, 1280, 720);
		background1.setIcon(backgroundImage1);
		optionsPane.add(background1, Integer.valueOf(0));
		slider.setFont(new Font("FV Almelo", Font.BOLD, 15));
		optionsPane.add(slider, Integer.valueOf(2));
		optionsPane.add(slider1, Integer.valueOf(2));
		optionsPane.add(backButton, Integer.valueOf(2));
		slider.setForeground(new Color(0, 128, 128));
		c.add(optionsPane);
	}

	public static JLayeredPane getFrame() {
		return optionsPane;
	}

	public static JSlider getSlider() {
		return slider;
	}

	public static JSlider getSlider1() {
		return slider1;
	}

	public static JButton getBackButton() {
		return backButton;
	}
}
