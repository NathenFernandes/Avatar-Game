
/*
 * NATHEN FERNANDES
 * MR CHUS COMPUTER SCIENCE CLASS
 * DATE 01-22
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Character {

	int startingHealth;
	String character;
	// -4 for when an attack fails
	int health; // -2 will show health
	double damageIncrease = 1; // -0 is the return value
	int charge = 0; // - 11 will show the charge
	ArrayList<String> zukoMoves = new ArrayList<String>();
	ArrayList<String> tophMoves = new ArrayList<String>();
	ArrayList<String> kataraMoves = new ArrayList<String>();
	ArrayList<String> aangMoves = new ArrayList<String>();
	ArrayList<String> sokkaMoves = new ArrayList<String>();

	ArrayList<String> moves = new ArrayList<String>();
	ArrayList<String> movesDamage = new ArrayList<String>();
	ArrayList<String> healths = new ArrayList<String>();

	Character(String character1) throws FileNotFoundException {
		File myObj = new File("values.txt");
		Scanner myReader = new Scanner(myObj);
		int counter = 0;
		String index = "null";
		while (myReader.hasNextLine()) {
			counter++;
			String data = myReader.nextLine();
			System.out.println("DATA: "  +data+ "  COUNTER: " + counter);
			if (counter == 1) {
				index = data;
			}
			if (counter == 2) {
				healths.add(data);
			}
			else if(counter == 7) {
				counter =0;
			}
			else if(counter > 2 && counter < 7) {
				if(index.equals("ZUKO")) {
					zukoMoves.add(data);

				}
				else if(index.equals("KATARA")) {
					kataraMoves.add(data);
				}
				else if(index.equals("TOPH")) {
					tophMoves.add(data);
				}
				else if(index.equals("SOKKA")) {
					sokkaMoves.add(data);
				}
				else if(index.equals("AANG")) {
					aangMoves.add(data);
				}
			}
		}
		System.out.println(aangMoves.get(1));
		this.character = character1;
		character = character1;
		// if character is Zuko add these moves
		if (character.equals("Zuko")) {
			this.startingHealth = Integer.parseInt(healths.get(0));
			health =  Integer.parseInt(healths.get(0));
			for(int i = 0; i < 4; i++) {
				moves.add(zukoMoves.get(i));
			}
		}
		// if character is Katara add these moves
		if (character.equals("Katara")) {
			this.startingHealth = Integer.parseInt(healths.get(1));
			health =  Integer.parseInt(healths.get(1));
			for(int i = 0; i < 4; i++) {
				moves.add(kataraMoves.get(i));
			}
		}
		// if character is Toph add these moves
		if (character.equals("Toph")) {
			this.startingHealth = Integer.parseInt(healths.get(2));
			health = Integer.parseInt(healths.get(2));;
			for(int i = 0; i < 4; i++) {
				moves.add(tophMoves.get(i));
			}
		}
		// if character is Sokka add these moves
		if (character.equals("Sokka")) {
			this.startingHealth = Integer.parseInt(healths.get(3));;
			health = Integer.parseInt(healths.get(3));;
			for(int i = 0; i < 4; i++) {
				moves.add(sokkaMoves.get(i));
			}
		}
		// if character is Aang add these moves
		if (character.equals("Aang")) {
			this.startingHealth = Integer.parseInt(healths.get(4));;
			health = Integer.parseInt(healths.get(4));;
			for(int i = 0; i < 4; i++) {
				moves.add(aangMoves.get(i));
			}
		}

	}

	public String getCharacter() { // Prints Character
		System.out.println(character);
		return character;
	}

	public int getStartingHealth() { // Gets the starting Health
		return startingHealth;
	}

	public int getCurrentHealth() { // Returns Current health of player/bot
		return health;
	}

	public int getCharge() { // Returns the charge of the player/bot
		return charge;
	}

	public void setHealth(int num) { // used to health or damage character
		health = health - num;
	}

	public void setFinalHealth(int num) { // set the health to a value using the parameter
		health = num;
	}

	public double getDamageMultipler() { // shows the damage multiplier
		return damageIncrease;
	}

	public String printAttack(int index) { // Prints the attack being used
		String attack = moves.get(index);
		// System.out.println(attack);
		return attack;
	}

	public String toString() { // toString for when they print the Card
		return character;
	}

	public int getAttack(int move) { // gets the attack stats and probability
		Random rand = new Random();
		int boom = rand.nextInt(2);
		boom++;
		int n = rand.nextInt(10);
		n++;
		System.out.println(character);
		double damage = 0;
		if (character.equals("Zuko")) {
			if (move == 0) {
				damage = 15 * (damageIncrease);
				return (int) damage;
			}
			if (move == 1) {
				damageIncrease = damageIncrease + 0.5;
				return -9; // if its ever = to - 9 then later we will right a method to show the user their
							// upgraded damage
			}
			if (move == 2) {
				if (charge == 1) {
					damage = (int) (35 * (damageIncrease)); // increases damage multipler
					charge = 0;
					return (int) damage;
				} else {
					charge++;
					return -11;
				}

			}
			if (move == 3) {
				if (n > 7) { // 30% chance
					damage = (int) (65 * (damageIncrease));
					return (int) damage;
				} else {
					return -55;
				}
			}

		}

		if (character.equals("Toph")) {
			if (move == 0) {
				damage = (int) (3 * (n));
				return (int) damage; // if its ever = to - 3 then later we will right a method to show the user their
				// upgraded damage
			}
			if (move == 1) {
				damage = (int) (12 * (damageIncrease));
				return (int) damage;
			}
			if (move == 2) {
				damageIncrease = damageIncrease + 0.5;// increases damage
				return -9;
			}
			if (move == 3) {
				if (charge == 1) {
					damage = (int) (35 * (damageIncrease));
					charge = 0;
					return (int) damage;
				} else {
					charge++;
					return -11;
				}
			}

		}
		if (character.equals("Katara")) {
			if (move == 0) {
				damage = (int) (13 * (damageIncrease));
				return (int) damage;
			}
			if (move == 1) {
				return -15;
			}
			if (move == 2) {
				if (n > 5) {
					return -100;
				} else {
					return -99;
				}
			}
			if (move == 3) {
				damageIncrease = damageIncrease + 0.5; // increases damage
				return -9;
			}

		}
		if (character.equals("Sokka")) {
			if (move == 0) {
				damage = (int) (10 * (damageIncrease));
				return (int) damage;
			}
			if (move == 1) {
				if (n > 3) {
					damage = (int) (15 * (damageIncrease));
					return (int) damage;
				} else {
					return -55;
				}
			}
			if (move == 2) {
				damage = (int) (8 * (boom));
				return (int) damage; // if its ever = to - 3 then later we will right a method to show the user their
				// upgraded damage
			}
			if (move == 3) {
				if (n > 9) {
					return 95;
				} else {
					return -55;
				}
			}

		}
		if (character.equals("Aang")) {
			if (move == 0) {
				damage = 12 * (damageIncrease);
				return (int) damage;
			}
			if (move == 1) {
				damage = (int) (3 * (n));
				return (int) damage;
			}
			if (move == 2) {
				if (charge == 1) {
					damage = (int) (30 * (damageIncrease));
					charge = 0;
					return (int) damage;
				} else {
					charge++;
					return -11;
				}
			}
			if (move == 3) {
				if (n > 6) { // 40% chance
					damage = (int) (40 * (damageIncrease));
					return (int) damage;
				} else {
					return -55;
				}
			}

		}
		damage = 0;
		return (int) damage;
	}

}
