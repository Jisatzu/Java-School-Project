package repetitiveStuff;

import java.util.HashMap;

import consolereader.ConsoleReader;
import people.Player;

public abstract class checkAndleaveFuncitons {
	public static boolean leave(boolean back) {
		if (back) {
			back = false;
		} else {
			back = true;
		}
		return back;
	}

	public static boolean characterCheck(Character a) {
		if (Character.isLetter(a)) {
			return true;
		} else {
			return false;
		}
	}

	public static Character charactertoSmallLetter(String text) {
		Character a;
		a = ConsoleReader.readChar(text);
		if (Character.isLetter(a)) {
			Character.toLowerCase(a);
		}
		return a;
	}

	public static boolean playerInputInteger(int playerInput, int maxInput, String itemName) {
		if (playerInput > 0 && playerInput < maxInput) {
			return true;
		} else if (playerInput == 0) {
			return true;
		} else {
			if (itemName != null) {
				System.out.println("I am Sorry but we don't have that many " + itemName + " in stock at the moment.");
			} else {
				Error_Systemouts.invalidInput();
			}
			return false;
		}
	}

	public static boolean yesAndNo(Character a) {
		if (a == 'y') {
			return true;
		} else if (a == 'n') {
			return true;
		} else {
			Error_Systemouts.invalidInput();
			return false;
		}
	}

	public static boolean playerChoosage(HashMap<Character, Player> playerList, Character j) {
		boolean b = false;
		for (Character i : playerList.keySet()) {
			if (j == i) {
				b = true;
				break;
			} else {
				b = false;
			}
		}
		return b;
	}

	public static boolean actionChoos(String a, Character input) {
		Character c;
		boolean f = false;
		for (int i = 0; i < a.length(); i++) {
			c = (Character) a.charAt(i);
			if (c == input) {
				f = true;
				break;
			} else {
				f = false;
			}
		}
		return f;
	}
}
