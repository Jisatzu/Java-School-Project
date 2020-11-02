package actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import bodyEquip.PouchForConsumable;
import bodyEquip.PouchForConsumable.Consumable;
// import bodyEquip.PouchForConsumable;
import consolereader.ConsoleReader;
import enemy.Enemies;
import people.Player;
import repetitiveStuff.Error_Systemouts;
import repetitiveStuff.Tab;
import skills.Skill;
import thebase.HumanBeeing;
import thebase.TheGame;

public abstract class Fighting {
//	/**
//	 * String variable for all enemy names that exist in one fight.
//	 */
//	private static String enemyNames;
//	/**
//	 * Variable for choosing the enemy.
//	 */
//	private static Character enemyTarget;
//	/**
//	 * Variable to check if the fight is still going or not.
//	 */
//	private static boolean fight = false;
//	/**
//	 * The Boolean to check if the player won the Battle or not.
//	 */
//	private static boolean win = false;
//	/**
//	 * ArrayList that contains all enemy's for a single fight.
//	 */
//	private static ArrayList<Enemies> enemieList;
//	private static final String enemyParameters = Tab.left(20, "Gegner Nummer") + Tab.left(20, "Gegner Name")
//			+ Tab.left(20, "Gegner momentanes Leben");
//
//	/**
//	 * This method exist to create a random amount of enemys for the player.
//	 * 
//	 * @param playerList for the amount of maximal possible enemys.
//	 * @return Returns the amount of Enemys that he player has to fight.
//	 */
//	private static int randomEnemy(int x) {
//		int pick = new Random().nextInt(x) + 1;
//		return pick;
//	}
//
//	/**
//	 * This Method is for randomizing the player that is getting attacked.
//	 * 
//	 * @param playerList The list with all players, that can be attacked.
//	 * @return Returns the target that the enemy "choose".
//	 */
//	private static Character attackRandomPlayer(HashMap<Character, Player> playerList) {
//		int f = new Random().nextInt(playerList.size()) + 1;
//		int c = 0;
//		for (Character p : playerList.keySet()) {
//			if (c != f) {
//				enemyTarget = p;
//			} else {
//				c++;
//			}
//		}
//		return enemyTarget;
//	}
//
//	/**
//	 * This Method let's the player select what he wan'ts to do. Attack or use a
//	 * Potion.
//	 * 
//	 * @return Returns the choosen action the player want's to happen.
//	 */
//	private static int standChoose() {
//		boolean stancheChoose = false;
//		int stanceTyp = 0;
//		while (stancheChoose != true) {
//			stanceTyp = ConsoleReader.readInteger("Angreifen = (1) | Trank = (2) | Skill = (3)");
//			if (stanceTyp < 0 || stanceTyp > 3) {
//				System.out.println("Bitte geben Sie eine Gültige eingabe ein!");
//				stancheChoose = false;
//			} else {
//				stancheChoose = true;
//			}
//		}
//		return stanceTyp;
//	}
//
//	private static boolean playerAttacking(Player player) {
//		if (enemieList.size() == 1) {
//			attack(player, player.getDmgWithEquip(player), enemieList.get(0).getDef(), false, 0);
//			return true;
//		} else {
//			int c = playerSelectingEnemy() - 1;
//			if (enemieList.get(c).getDead()) {
//				System.out.println("Diese gegner ist schon tot, bitte wählen Sie einen anderen Gegner aus.");
//				return false;
//			} else {
//				attack(player, player.getDmgWithEquip(player), enemieList.get(c).getDef(), false, c);
//				return true;
//			}
//		}
//	}
//
//	/**
//	 * This Method is for the time when the player has it's turn to do something.
//	 * First it let's you choose if the player wants to use a Potion or want's to
//	 * attack an Enemy. If he want's to attack, he can choose the enemy, if there is
//	 * more than one Enemy.
//	 * 
//	 * @param player gets the player that can do something this turn.
//	 */
//	private static void playerAttacked(Player player) {
//		boolean playerAttacks = false;
//		while (playerAttacks != true) {
//			int stanceTyp = standChoose();
//			switch (stanceTyp) {
//			case 1:
//				playerAttacks = playerAttacking(player);
//				break;
//			case 2:
//				playerAttacks = skillUse(player, null);
//				break;
//			case 3:
//				playerAttacks = consumableItems(player);
//				break;
//			}
//		}
//	}
//
//	private static boolean skillUse(HumanBeeing skillUser, Character enemyTarget) {
//		int f = 0;
//		if (skillUser instanceof Enemies) {
//			f = new Random().nextInt(skillUser.getSkilllist().size());
//			skillUser.getSkilllist().get(f).CDactivate(skillUser.getSkilllist().get(f).getCd());
//			// if (DMG > DEF) {
//			// int dealtdmg = DMG - DEF;
//			// if (enemy == true) {
//			// player.setHp(dealtdmg * -1);
//			// System.out.println(enemieList.get(playerTarget).getName() + " griff " +
//			// player.getName() + " mit " + DMG + " an.");
//			// System.out.println(player.getName() + " verlor " + dealtdmg + " HP");
//			// System.out.println(player.getName() + " HP" + player.getPlayerHP());
//			// } else {
//			// enemieList.get(playerTarget).setHp(enemieList.get(playerTarget).getHp() -
//			// dealtdmg);
//			// System.out.println(player.getName() + " verursachte " + dealtdmg + " DMG and
//			// " + enemieList.get(playerTarget).getName());
//			// System.out.println(enemieList.get(playerTarget).getName() + " HP" +
//			// enemieList.get(playerTarget).getHp());
//			// if (enemieList.get(playerTarget).getHp() <= 0) {
//			// enemieList.get(playerTarget).setDead();
//			// }
//			// }
//			// } else {
//			// System.out.println("Kein schaden wurde Verursacht.");
//			// }
//		} else if (skillUser instanceof Player) {
//
//		} else {
//			Error_Systemouts.Error();
//		}
//		return false;
//	}
//
//	/**
//	 * If there is more than 1 enemy, this method will allow the player to choose
//	 * the enemy he want's to attack.
//	 * 
//	 * @return Returns the choosen enemy.
//	 */
//	private static int playerSelectingEnemy() {
//		int x = 0;
//		int c = 1;
//		boolean enemyChoosing = true;
//		while (enemyChoosing) {
//			System.out.println("Wen wollen Sie angreifen?");
//			System.out.println(enemyParameters);
//			for (int i = 0; i < enemieList.size(); i++) {
//				System.out.println(Tab.left(20, c + "") + Tab.left(20, enemieList.get(i).getName())
//						+ Tab.right(20, enemieList.get(i).getHp() + ""));
//				c++;
//			}
//			x = ConsoleReader.readInteger("");
//			if (x > 0 && x <= c) {
//				enemyChoosing = false;
//			} else {
//				enemyChoosing = true;
//			}
//		}
//		return x;
//	}
//
//	/**
//	 * This method simulates a fight between the player and enemy's.
//	 * 
//	 * @param playerList The playerlist that can participate in a fight.
//	 * @return Returns the playerlist with all players. In later stages it could be
//	 *         possible to buy more playable chars that can die.
//	 */
//	public static boolean fight() {
//		fight = true;
//		int enemyAmount = randomEnemy(TheGame.getPlayerList().size());
//		createEnemys(TheGame.getPlayerList(), enemyAmount);
//		enemyNames = "";
//		for (int a = 0; a < enemieList.size(); a++) {
//			if (a + 1 == enemieList.size()) {
//				enemyNames += enemieList.get(a).getName() + " ";
//			} else {
//				enemyNames += enemieList.get(a).getName() + " und ";
//			}
//		}
//		if (enemieList.size() != 1) {
//			System.out.println("Deine Gegner sind " + enemyNames);
//		} else {
//			System.out.println("Dein Gegner ist " + enemyNames);
//		}
//		while (fight == true) {
//			for (Character i : TheGame.getPlayerList().keySet()) {
//				fight = playerLoseOrWin();
//				if (!fight) {
//					System.out.println(TheGame.getPlayerList().get(i).getName() + " ist and der Reihe!");
//					playerAttacked(TheGame.getPlayerList().get(i));
//				} else {
//					break;
//				}
//			}
//			if (!fight) {
//				break;
//			}
//			for (int i = 0; i < enemieList.size(); i++) {
//				if (!enemieList.get(i).getDead()) {
//					Character x = attackRandomPlayer(TheGame.getPlayerList());
//
//					attack(TheGame.getPlayerList().get(x), enemieList.get(i).getDmg(),
//							TheGame.getPlayerList().get(x).getArmorWithEquip(TheGame.getPlayerList().get(x)), true, 0);
//				}
//			}
//			for (Player p : TheGame.getPlayerList().values()) {
//				Skill.CDManagement(p.getSkilllist(), false);
//			}
//			for (Enemies e : enemieList) {
//				Skill.CDManagement(e.getSkilllist(), false);
//			}
//			fight = playerLoseOrWin();
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		for (Player p : TheGame.getPlayerList().values()) {
//			Skill.CDManagement(p.getSkilllist(), true);
//		}
//		return win;
//	}
//
//	/**
//	 * This Method is to check if the fight has been won or has been lost. If either
//	 * one of the chars is on or below 0 Health Points, the game will end.
//	 * 
//	 * @param player  get's the main char
//	 * @param player2 get's the second char
//	 * @return
//	 */
//	private static boolean playerLoseOrWin() {
//		int winOrLose = 1;
//		boolean enemyDead = false;
//		for (int i = 0; i < enemieList.size(); i++) {
//			if (enemieList.get(i).getDead()) {
//				enemyDead = true;
//			} else {
//				enemyDead = false;
//				break;
//			}
//		}
//		if (enemyDead) {
//			winOrLose = 2;
//		}
//		for (
//
//		Character p : TheGame.getPlayerList().keySet()) {
//			if (TheGame.getPlayerList().get(p).getPlayerHP() <= 0) {
//				winOrLose = 3;
//				break;
//			}
//		}
//		switch (winOrLose) {
//		case 1:
//			fight = true;
//			break;
//		case 2:
//			int enemyTotalXP = 0;
//			int enemyTotalMoney = 0;
//			for (int i = 0; i < enemieList.size(); i++) {
//				enemyTotalXP += enemieList.get(i).getXp();
//				enemyTotalMoney += enemieList.get(i).getMoney();
//			}
//			System.out.println("Sie haben insgesamt " + enemyTotalXP + " XP und " + enemyTotalMoney + " Gold von "
//					+ enemyNames + " erhalten.");
//			Player.setMoney(enemyTotalMoney);
//			for (Character p : TheGame.getPlayerList().keySet()) {
//				TheGame.getPlayerList().get(p).xpCalc(TheGame.getPlayerList().get(p),
//						enemyTotalXP / TheGame.getPlayerList().size());
//				System.out.println(TheGame.getPlayerList().get(p).getName() + " erhält "
//						+ enemyTotalXP / TheGame.getPlayerList().size() + "XP.");
//			}
//			win = false;
//			fight = false;
//			break;
//		case 3:
//			System.out.println("Game Over");
//			win = true;
//			fight = false;
//			break;
//		}
//		return fight;
//	}
//
//	/**
//	 * This Method is used to calculate the damage dealt and damage received from
//	 * one participant.
//	 * 
//	 * @param DMG   /The damage that is dealt.
//	 * @param DEF   /The amount of damage that is blocked.
//	 * @param enemy /checks if it's an enemy that is dealing the damage
//	 */
//	private static void attack(Player player, int DMG, int DEF, boolean enemy, int playerTarget) {
//		if (DMG > DEF) {
//			int dealtdmg = DMG - DEF;
//			if (enemy == true) {
//				player.setHp(dealtdmg * -1);
//				System.out.println(
//						enemieList.get(playerTarget).getName() + " griff " + player.getName() + " mit " + DMG + " an.");
//				System.out.println(player.getName() + " verlor " + dealtdmg + " HP");
//				System.out.println(player.getName() + " HP" + player.getPlayerHP());
//			} else {
//				enemieList.get(playerTarget).setHp(enemieList.get(playerTarget).getHp() - dealtdmg);
//				System.out.println(player.getName() + " verursachte " + dealtdmg + " DMG and "
//						+ enemieList.get(playerTarget).getName());
//				System.out
//						.println(enemieList.get(playerTarget).getName() + " HP" + enemieList.get(playerTarget).getHp());
//				if (enemieList.get(playerTarget).getHp() <= 0) {
//					enemieList.get(playerTarget).setDead();
//				}
//			}
//		} else {
//			System.out.println("Kein schaden wurde Verursacht.");
//		}
//	}
//
//	/**
//	 * This method let's the player consume a Potion that he bought before hand. If
//	 * he has no Potions he can still chose to attack.
//	 * 
//	 * @param player This is the player that can select a potion to use.
//	 * @return Returns if a potion has been used.
//	 */
//	private static boolean consumableItems(Player player) {
//		boolean potionChoosing = true;
//		boolean noItem = false;
//		while (potionChoosing) {
//			if (Player.getPotions().size() > 0) {
//				int potionChoose = ConsoleReader
//						.readInteger("Welche art Trank wollen Sie benutzen? 1 = Heilungstrank | 2 = Manatrank");
//				switch (potionChoose) {
//				case 1:
//					for (PouchForConsumable p : Player.getPotions())
//						if (p.getConsumableType() == Consumable.LEBEN) {
//							int f = Player.getPotions().indexOf(p);
//							System.out.print((f + 1) + " = " + p.getItemName() + " ");
//						}
//					int a = ConsoleReader.readInteger("Welchen Trank wollen Sie trinken?") - 1;
//					player.setHp(Player.getPotions().get(a).getHealthRecovery());
//					Player.getPotions().get(a).setItemAmount(Player.getPotions().get(a).getItemAmount() - 1);
//					System.out.println(player.getName() + " hat " + Player.getPotions().get(a).getHealthRecovery()
//							+ " Leben regeneriert." + player.getName() + " hat nun " + player.getPlayerHP() + " HP.");
//					potionChoosing = false;
//					noItem = true;
//					break;
//				case 2:
//					for (PouchForConsumable p : Player.getPotions())
//						if (p.getConsumableType() == Consumable.MANA) {
//							int f = Player.getPotions().indexOf(p);
//							System.out.print((f + 1) + " = " + p.getItemName() + " ");
//						}
//					int c = ConsoleReader.readInteger("Welchen Trank wollen Sie trinken?") - 1;
//					player.setMana(Player.getPotions().get(c).getManaRecovery());
//					Player.getPotions().get(c).setItemAmount(Player.getPotions().get(c).getItemAmount() - 1);
//					System.out.println(player.getName() + " hat " + Player.getPotions().get(c).getManaRecovery()
//							+ " Mana regeneriert. " + player.getName() + " hat nun " + player.getMana() + " Mana.");
//					potionChoosing = false;
//					noItem = true;
//					break;
//				default:
//					System.out.println("Bitte geen Sie eine Gültige eingabe ein!");
//					potionChoosing = true;
//					break;
//				}
//			} else {
//				potionChoosing = false;
//				System.out.println(potionChoosing);
//				noItem = false;
//			}
//		}
//		return noItem;
//	}
//
//	private static void createRandomEnemys(HashMap<Character, Player> playerList) {
//		int playerLevels = 0;
//
//		for (Character p : playerList.keySet()) {
//			playerLevels += playerList.get(p).getLvl();
//		}
//	}
//
//	/**
//	 * This Method creates all enemy's in one fight. The ArrayList in that the
//	 * enemy's are saved will be always cleared if a new fight happens.
//	 * 
//	 * @param playerList  The enemy's are based on the player level.
//	 * @param enemyAmount The amount of enemy's that can be in on fight.
//	 */
//	private static void createEnemys(HashMap<Character, Player> playerList, int enemyAmount) {
//		enemieList = new ArrayList<Enemies>();
//		int playerLevels = 0;
//		for (Character p : playerList.keySet()) {
//			playerLevels += playerList.get(p).getLvl();
//		}
//		playerLevels /= playerList.size();
//		for (int f = 0; f < enemyAmount; f++) {
//			if (playerLevels != 1) {
//				playerLevels = new Random().nextInt(playerLevels + 1);
//			}
//		}
//	}
	private Enemies randomEnemy() {
		Enemies e = new 
				return e;
	}

	private void generateEncounter() {
		enemieList = new ArrayList<Enemies>();
		for (int i = 0; i < TheGame.getPlayerList().size(); i++) {
			enemieList.add(e)
		}
			
		
	}

}
