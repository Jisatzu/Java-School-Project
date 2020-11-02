package actions;

public abstract class Help {
	public static void basicHelp() {
		System.out.println("Das Spiel wird hauptsächlich mit einer Zahleneingabe in die Konsole bedient.");
		System.out.println("Die Charaktäre können Sie mit hilfe von den Shops ausrüssten.");
		System.out
				.println("Die Ausrüstung verleiht Ihmen Charachter mehr Verteidigung(DEF) und oder mehr Schaden(DMG)");
		System.out.println("Gegner besiegen Sie, indem Sie einfach darauf zuschlagen.");
		System.out.println(
				"Wenn Sie eine Gewisse anzahl an Gegnern getötet haben, steigen die Characktäre ein Level auf.");
		System.out.println(
				"Ein Levelaufstieg verleiht Ihren Characktären mehr Lebenspunkte(HP), mehr basis Schaden und basis Verteidigung.");
		System.out.println("Das Spiel endet wenn einer Ihrer Characktäre keine Lebenspunkte mehr hat.");
		System.out.println("Im Inventar können Sie Ihre Characktäre mit überschüssigen Ausrüstungen ausrüsten.");
		System.out.println();
		System.out.println(
				"Es sind noch Fehler im Spiel, diese sind aber nicht Spiel zerstörend. Sie können aber für einen Vorteil sorgen.");
		System.out.println(
				"Ausrüstung können Sie nicht verkaufen, da Ich(der Programmierer) den Verkauf falsch eingebaut habe.");
		System.out.println("Dennoch wünsche ich Ihnen viel spass beim Fehler ausnützen und beim Spielen.");
	}

	public Help() {
	}
}
