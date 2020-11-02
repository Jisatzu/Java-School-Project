package town;

import java.util.ArrayList;

import actions.Fighting;
import actions.Help;
import actions.Merchant;
import armor.Boot;
import consolereader.ConsoleReader;
import enemy.*;
import equipment.MaterialsForEquipment;
import merchant.Armorer;
import merchant.InnKeeper;
import merchant.PotionDealer;
import merchant.Weaponsmith;
import people.Player;
import repetitiveStuff.VaiableInputShower;
import repetitiveStuff.checkAndleaveFuncitons;
import thebase.TheGame;

/**
 * This Class generates Citys with shops. Later the shop amount and the shop
 * type can differ.
 * 
 * @author Batuhan Avci
 *
 */
public class TownMajor {
	/**
	 * This boolean is for the moment when the player want's to end the game.
	 */
	private boolean finalAnswer = false;
	/**
	 * ArrayList for all people in the city.
	 */
	private ArrayList<Merchant> townPeopleList = new ArrayList<Merchant>();
	/**
	 * Creates the variable for the armorer in the city.
	 */
	private Armorer armorer;
	/**
	 * Creates the variable for the innceeper in the city.
	 */
	private InnKeeper innceeper;
	/**
	 * Creates the variable for the potionDealer in the city.
	 */
	private PotionDealer potionDealer;
	/**
	 * Creates the variable for the Weaponsmith in the city.
	 */
	private Weaponsmith weaponsmith;
	/**
	 * Checks if the game is over or not.
	 */
	private boolean endGame;
	/**
	 * The String that adds all the selections together.
	 */
	private String peopleList = "";
	/**
	 * The divider for selection.
	 */
	private String divider = " | ";
	/**
	 * String for the Cityname.
	 */
	private String cityName;

	/**
	 * This Constructor creates all Shops in a city.
	 * 
	 * @param cityName This is the city name that the city should have.
	 */
	public TownMajor(String cityName) {
		this.cityName = cityName;
		int f = 2;
		townPeopleList.add(armorer = new Armorer("Rüstungsschmied", 50, 0, 0, 0, 1000, "Rüstungshändler", "Rüstungen",
				"Rüstungsschmiede", cityName, false));
		peopleList += divider + "(" + f++ + ")" + " = " + armorer.getName();
		townPeopleList.add(innceeper = new InnKeeper("Tavernen Besitzer", 50, 0, 0, 0, 1000, "Tavernen Besitzer",
				"Essen, Getränke und Betten", "Der Wilde Eber", cityName, false));
		peopleList += divider + "(" + f++ + ")" + " = " + innceeper.getName();
		townPeopleList.add(potionDealer = new PotionDealer("Tränke Meister", 50, 0, 0, 0, 1000, "Tränkehändler",
				"Tränke", "Die Falschen Tränke", cityName, false));
		peopleList += divider + "(" + f++ + ")" + " = " + potionDealer.getName();
		townPeopleList.add(weaponsmith = new Weaponsmith("Waffenschmied", 50, 0, 0, 0, 1000, "Waffenhändler",
				"Ein- und Zweihänder Waffen, sowie Schilde", "Waffenschmiede", cityName, false));
		peopleList += divider + "(" + f++ + ")" + " = " + weaponsmith.getName();
	}

	/**
	 * This method creates Strings from the character name and a delimiter. If
	 * numbers are needed it can be checked with a true or false statement.
	 * 
	 * @param players   The list with all currently available characters.
	 * @param delimiter the string that should separates the names.
	 * @param indecies  checks if there are numbers needed for choosing.
	 * @return returns the string that is created.
	 */
	private void greetingOrChoosing(boolean choosing) {
		if (choosing) {
			VaiableInputShower.playerChoosingList(TheGame.getPlayerList());
		} else {
			System.out.println(VaiableInputShower.playerGreetingList(TheGame.getPlayerList(), this.cityName));
		}
	}

	/**
	 * This method let's the player use all town functions. In this version (0.5) it
	 * is also the main navigation point.
	 * 
	 * @param playerList Is needed to greet all characters and to let the player
	 *                   select what character should be equipped in the stores.
	 * @return In this version it checks if the player died in a fight.
	 */
	public boolean townAction() {
		greetingOrChoosing(false);
		boolean leave = false;
		// int c = 0;
		while (leave != true) {
			Character x;
			System.out.println("Wohin wollen Sie gehen?");
			System.out.println("(1) = Stadt verlassen " + peopleList);
			System.out.println();
			System.out.println(
					"(C) = Momentane Ausrüstung | (I) = Inventar | (H) = Hilfe | (S) = Statistiken | (V) = Spiel Verlassen | (9) = Learned Skills");
			x = ConsoleReader.readChar("");
			if (Character.isLetter(x)) {
				Character.toLowerCase(x);
			}
			switch (x) {
			case '1':
				leave = Fighting.fight();
				if (leave) {
					endGame = true;
				} else {
					endGame = false;
					greetingOrChoosing(false);
					itemGenerator();
				}
				break;
			case '2':
				System.out.println("Welcome to the " + armorer.getBuilding());
				armorer.armoreChoose();
				break;
			case '3':
				System.out.println("Welcome to the " + innceeper.getBuilding());
				innceeper.innInterAction();
				break;
			case '4':
				System.out.println("Welcome to the " + potionDealer.getBuilding());
				potionDealer.choosePotion();
				break;
			case '5':
				System.out.println("Welcome to the " + weaponsmith.getBuilding());
				weaponsmith.weaponChoosing();
				break;
			case '6':
				for (Character p : TheGame.getPlayerList().keySet()) {
					TheGame.getPlayerList().get(p).currentEquipment(TheGame.getPlayerList().get(p));
				}
				System.out.println(Player.getMoneyFromPlayer());
				System.out.println();
				break;
			case '8':
				System.out.println("Cheater");
				System.out.println(Player.getArmorEquipment()
						.add(new Boot(armorer.randomValueGenerator(), MaterialsForEquipment.ALCHEMIESEIDE)));
				Player.getArmorEquipment()
						.add(new Boot(armorer.randomValueGenerator(), MaterialsForEquipment.DRACHENLEDER));
				Player.getArmorEquipment().add(new Boot(armorer.randomValueGenerator(), MaterialsForEquipment.EISEN));
				Player.getArmorEquipment()
						.add(new Boot(armorer.randomValueGenerator(), MaterialsForEquipment.FELLLEDER));
				Player.getArmorEquipment()
						.add(new Boot(armorer.randomValueGenerator(), MaterialsForEquipment.GEHAERTETESLEDER));
				Player.getArmorEquipment()
						.add(new Boot(armorer.randomValueGenerator(), MaterialsForEquipment.KAMPFLEDER));
				break;
			case 's':
				TheGame.getPlayerList().get('t').currentStats(TheGame.getPlayerList());
				break;
			case 'h':
				Help.basicHelp();
				break;
			case 'i':
				if (Player.getWeaponEquipment().size() != 0 || Player.getArmorEquipment().size() != 0) {
					VaiableInputShower.playerChoosingList(TheGame.getPlayerList());
					Character f = ' ';
					checkAndleaveFuncitons.playerChoosage(TheGame.getPlayerList(), f = ConsoleReader.readChar(""));
					TheGame.getPlayerList().get(f).inventoryOutPut();
				} else {
					System.out.println("Sie haben keine Gegenstände im Inventar.");
				}
				break;
			case 'v':
				leave = true;
				endGame = true;
				finalAnswer = true;
				break;
			/*
			 * test if enemys are created with there skills and stats
			 */
			case 'e':
				ArrayList<Enemies> enemyList = new ArrayList<Enemies>();
				enemyList.add(new Assasin(1));
				enemyList.add(new Assasin(2));
				enemyList.add(new Bandit_Archer(1));
				enemyList.add(new Bandit_Archer(2));
				for (Enemies alfa : enemyList) {
					System.out.println(alfa.getName());
					int f = alfa.getSkilllist().size();
					for (int i = 0; i < f; i++) {
						System.out.println(alfa.getSkilllist().get(i).getName());
					}
					System.out.println(Enemies.getAllStats(alfa));
					System.out.println();
				}
				break;
			case '9':
				boolean playerChoosing1 = false;
				Character o2 = 0;
				while (!playerChoosing1) {
					VaiableInputShower.playerChoosingList(TheGame.getPlayerList());
					playerChoosing1 = checkAndleaveFuncitons.playerChoosage(TheGame.getPlayerList(),
							Character.toLowerCase(o2 = ConsoleReader.readChar("")));
				}
				TheGame.getPlayerList().get(o2).skillOutPut(false);
				break;
			default:
				System.out.println("Bitte geben Sie eine gültige eingabe ein!");
				break;
			}
		}
		return endGame;
	}

	/**
	 * This method generates a new inventory for all townshops. It also checks if
	 * there is a shop like this available.
	 */
	private void itemGenerator() {
		for (Merchant a : townPeopleList) {
			if (a instanceof Armorer) {
				((Armorer) a).randomiseAmount();
			} else if (a instanceof PotionDealer) {
				((PotionDealer) a).randomiseAmount();
			} else if (a instanceof InnKeeper) {
				((InnKeeper) a).randomiseAmount();
			} else if (a instanceof Weaponsmith) {
				((Weaponsmith) a).randomiseAmount();
			} else {
				System.out.println("There went something wrong");
			}
		}
	}

	public boolean getFinalAnswer() {
		return finalAnswer;
	}
}
