package thebase;

// import java.util.ArrayList;
import java.util.HashMap;

import consolereader.ConsoleReader;
import people.Player;
import town.TownMajor;

public class TheGame {
	/**
	 * Creates a list for all playable characters.
	 */
	private static HashMap<Character, Player> playerList = new HashMap<Character, Player>();
	/**
	 * Checks if the player still want's to play or not.
	 */
	private static boolean playCheck = true;

	public static void main(String[] args) {
		while (playCheck) {
			playerList.clear();
			boolean gameEnd = false;
			Player player = new Player("Laraya", 50, 0, 10, 0, 50, true, 20);
			Player secondChar = new Player("Tiana", 20, 3, 15, 0, 0, true, 50);
			playerList.put(Character.toLowerCase(player.getName().charAt(0)), player);
			playerList.put(Character.toLowerCase(secondChar.getName().charAt(0)), secondChar);
			TownMajor townMajorOfJarof = new TownMajor("Zuerich");
			while (!gameEnd) {
				gameEnd = townMajorOfJarof.townAction();
			}
			impressum();
			if (townMajorOfJarof.getFinalAnswer()) {
				playCheck = false;
			} else {
				playCheck = playCheck();
			}
		}
	}

	/**
	 * Looks if the player want's to restart the game or not.
	 * 
	 * @return
	 */
	private static boolean playCheck() {
		boolean spellCheck = true;
		Character answer = ' ';
		while (spellCheck) {
			System.out.println("BITTE NEHMEN SIE ZUR KENNTNISS DASS DER ERSTE BUCHSTABE ANGENOMMEN WIRD!");
			answer = Character
					.toLowerCase(ConsoleReader.readChar("Wollen Sie das Spiel neu starten? JA = Y | NEIN = N "));
			switch (answer) {
			case 'y':
				playCheck = true;
				spellCheck = false;
				break;
			case 'n':
				playCheck = false;
				spellCheck = false;
				break;
			default:
				spellCheck = true;
				break;
			}
		}
		return playCheck;
	}

	public static HashMap<Character, Player> getPlayerList() {
		return playerList;
	}

	public static void setPlayerList(HashMap<Character, Player> playerList) {
		TheGame.playerList = playerList;
	}

	private static void impressum() {
		System.out.println();
		System.out.println();
		System.out.println("Impressum");
		System.out.println();
		System.out.println("Programmierer                       : Batuhan Avci");
		System.out.println("Programmname                        : Mittelalter Fantasy Spiel");
		System.out.println("Kontakt nöglichkeit bei Problemen   : Batuhan.Avci@outlook.de");
		System.out.println("ProjektLeiter                       : Markus Ruggiero");
		System.out.println("Firmenadresse                       : Hohlstrasse 535, 8048 Zürich, Schweiz");
		System.out.println("Firmenname                          : Topomedics");
	}
}
