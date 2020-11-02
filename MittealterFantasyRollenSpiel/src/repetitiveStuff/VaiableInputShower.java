package repetitiveStuff;

import java.util.ArrayList;
import java.util.HashMap;

import people.Player;

public abstract class VaiableInputShower {

	public static void playerChoosingList(HashMap<Character, Player> playerList) {
		String list = "";
		for (Character i : playerList.keySet()) {
			Character a = playerList.get(i).getName().charAt(0);
			list += String.format(" %c = %s |", a, playerList.get(i).getName());
		}
		System.out.println(list);
	}

	public static String playerGreetingList(HashMap<Character, Player> playerList, String cityName) {
		int i = 1;
		String g = "";
		ArrayList<String> f = new ArrayList<String>();
		for (Character a : playerList.keySet()) {
			f.add(playerList.get(a).getName());
			if (i + 1 == playerList.size()) {
				g = String.join(", ", f);
			} else if (i == playerList.size()) {
				g += "and " + playerList.get(a).getName() + " arrived in " + cityName;
			}
			i++;
		}
		return g;
	}
}
