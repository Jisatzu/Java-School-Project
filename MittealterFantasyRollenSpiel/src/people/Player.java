package people;

import java.util.ArrayList;
import java.util.HashMap;

import armor.Boot;
import armor.Chest;
import armor.Gauntlet;
import armor.Helmet;
import armor.Pants;
import bodyEquip.HandEquipment;
import bodyEquip.PouchForConsumable;
import bodyEquip.PouchForConsumable.Consumable;
import consolereader.ConsoleReader;
import equipment.Equipment;
import equipment.Inventory;
import equipment.TheArmorEquipment;
import repetitiveStuff.Error_Systemouts;
import repetitiveStuff.Tab;
import skills.DEFSkills;
import skills.DMGSkills;
import skills.HYBRIDSkills;
import skills.Positions;
import skills.Skill;
import skills.SkillTree;
// import skills.DEFSkills;
// import skills.DMGSkills;
// import skills.HYBRIDSkills;
// import skills.Positions;
// import skills.Skill;
import thebase.HumanBeeing;
import weapon.AxeWeapon;
import weapon.BluntWeapon;
import weapon.Shield;
import weapon.SpearWeapon;
import weapon.SwordWeapon;

/**
 * This class creates the characters that the player can use. It also generates an Inventory that all characters can use.
 * 
 * @author Batuhan Avci
 *
 */
public class Player extends HumanBeeing {

	private static final int t1skill = 1;
	private static final int t2skill = 2;
	private static final int t3skill = 3;

	public Player(String Name, int baseHP, int baseArmor, int baseDmg, int XP, int money, boolean playablechar, int mana) {
		super(Name, baseHP, baseArmor, baseDmg, XP, money, playablechar);
		skilllist = new ArrayList<Skill>();
		potions.clear();
		weaponEquipment.clear();
		armorEquipment.clear();
		this.baseMana = mana;
		this.maxMana = mana;
		inventory = new Inventory();
		// String name, int cd, int manacosten, int tierlvl, int def, int dmg, boolean learned, Positions pos
		// all hybrid skills
		skilllist.add(new HYBRIDSkills("Parry", 2, 5, t1skill, 3, 5, false, Positions.POSITIONSL1));
		skilllist.add(new HYBRIDSkills("hybridskill2", 2, 5, t2skill, 3, 5, false, Positions.POSITIONSL2));
		skilllist.add(new HYBRIDSkills("hybridskill3", 2, 5, t3skill, 3, 5, false, Positions.POSITIONSL3));
		skilllist.add(new HYBRIDSkills("hybridskill4", 2, 5, t1skill, 3, 5, false, Positions.POSITIONSM1));
		skilllist.add(new HYBRIDSkills("hybridskill5", 2, 5, t2skill, 3, 5, false, Positions.POSITIONSM2));
		skilllist.add(new HYBRIDSkills("hybridskill6", 2, 5, t3skill, 3, 5, false, Positions.POSITIONSM3));
		skilllist.add(new HYBRIDSkills("hybridskill7", 2, 5, t1skill, 3, 5, false, Positions.POSITIONSR1));
		skilllist.add(new HYBRIDSkills("hybridskill8", 2, 5, t2skill, 3, 5, false, Positions.POSITIONSR2));
		skilllist.add(new HYBRIDSkills("hybridskill9", 2, 5, t3skill, 3, 5, false, Positions.POSITIONSR3));
		// (String name, int cd, int manacosten, int tierlvl, int dmg, boolean learned, Positions pos)
		// all dmg skills
		skilllist.add(new DMGSkills("dmgskill1", 2, 5, t1skill, 5, false, Positions.POSITIONSL1));
		skilllist.add(new DMGSkills("dmgskill2", 2, 5, t2skill, 5, false, Positions.POSITIONSL2));
		skilllist.add(new DMGSkills("dmgskill3", 2, 5, t3skill, 5, false, Positions.POSITIONSL3));
		skilllist.add(new DMGSkills("dmgskill4", 2, 5, t1skill, 5, false, Positions.POSITIONSM1));
		skilllist.add(new DMGSkills("dmgskill5", 2, 5, t2skill, 5, false, Positions.POSITIONSM2));
		skilllist.add(new DMGSkills("dmgskill6", 2, 5, t3skill, 5, false, Positions.POSITIONSM3));
		skilllist.add(new DMGSkills("dmgskill7", 2, 5, t1skill, 5, false, Positions.POSITIONSR1));
		skilllist.add(new DMGSkills("dmgskill8", 2, 5, t2skill, 5, false, Positions.POSITIONSR2));
		skilllist.add(new DMGSkills("dmgskill9", 2, 5, t3skill, 5, false, Positions.POSITIONSR3));
		// all def skills
		skilllist.add(new DEFSkills("defskill1", 2, 5, t1skill, 2, false, Positions.POSITIONSL1));
		skilllist.add(new DEFSkills("defskill2", 2, 5, t2skill, 2, false, Positions.POSITIONSL2));
		skilllist.add(new DEFSkills("defskill3", 2, 5, t3skill, 2, false, Positions.POSITIONSL3));
		skilllist.add(new DEFSkills("defskill4", 2, 5, t1skill, 2, false, Positions.POSITIONSM1));
		skilllist.add(new DEFSkills("defskill5", 2, 5, t2skill, 2, false, Positions.POSITIONSM2));
		skilllist.add(new DEFSkills("defskill6", 2, 5, t3skill, 2, false, Positions.POSITIONSM3));
		skilllist.add(new DEFSkills("defskill7", 2, 5, t1skill, 2, false, Positions.POSITIONSR1));
		skilllist.add(new DEFSkills("defskill8", 2, 5, t2skill, 2, false, Positions.POSITIONSR2));
		skilllist.add(new DEFSkills("defskill9", 2, 5, t3skill, 2, false, Positions.POSITIONSR3));
	}

	private static ArrayList<Equipment> weaponEquipment = new ArrayList<>();
	private static ArrayList<Equipment> armorEquipment = new ArrayList<>();
	private static ArrayList<PouchForConsumable> potions = new ArrayList<>();
	private static int money = getPlayermoney();
	private Inventory inventory;
	private int playerHP = getBaseHP();
	private int playerMaxHP = getBaseHP();
	private int playerBaseArmor = getBaseArmor();
	private int playerTotalArmor;
	private int playerToatlDMG;
	private int playerBaseDMG = getBaseDmg();
	private int lvl = 1;
	private static final int exincreas = 500;
	private int exreq = 500;
	private int baseMana;
	private int maxMana;
	private boolean equipment = false;
	private static String exit = " 1 = Zurück | ";
	private static String choosing = "Welche Items wollen Sie sich ansehen oder Ausrüssten?";

	private static ArrayList<Integer> realBootIndex;
	private static ArrayList<Integer> realChestIndex;
	private static ArrayList<Integer> realGauntletIndex;
	private static ArrayList<Integer> realHelmetIndex;
	private static ArrayList<Integer> realPantsIndex;
	private static ArrayList<Integer> realAxeIndex;
	private static ArrayList<Integer> realBluntIndex;
	private static ArrayList<Integer> realShieldIndex;
	private static ArrayList<Integer> realSpearIndex;
	private static ArrayList<Integer> realSwordIndex;
	@SuppressWarnings("rawtypes")
	private static HashMap<Integer, ArrayList> realWeaponList;

	private static int iCheck(boolean z) {
		int c = 0;
		boolean x = true;
		if (z) {
			while (x) {
				c = ConsoleReader.readInteger(choosing + exit + "2 = Schuhe (im Inventar " + realBootIndex.size() + ") " + "| 3 = Brust (im Inventar " + realChestIndex.size() + ") " + "| 4 = Handschuhe (im Inventar " + realGauntletIndex.size() + ") " + "| 5 = Helme (im Inventar "
						+ realHelmetIndex.size() + ") " + "| 6 = Hosen(im Inventar " + realPantsIndex.size() + ") " + "");
				if (c > 0 && c < 7) {
					x = false;
				} else {
					x = true;
					System.out.println("Bitte geben Sie eine gültige Zahl ein.");
				}
			}
		} else {
			while (x) {
				c = ConsoleReader.readInteger(choosing + exit + "2 = Äxte (im Inventar " + realAxeIndex.size() + ") " + "| 3 = Knüppel  (im Inventar " + realBluntIndex.size() + ") " + "| 4 = Schilde  (im Inventar " + realShieldIndex.size() + ") " + "| 5 = Stangenwaffen  (im Inventar "
						+ realSpearIndex.size() + ") " + "| 6 = Schwerter (im Inventar " + realSwordIndex.size() + ") ");
				if (c > 0 && c < 7) {
					c += 5;
					x = false;
				} else {
					x = true;
					System.out.println("Bitte geben Sie eine gültige Zahl ein.");
				}
			}
		}
		return c;
	}

	@SuppressWarnings("rawtypes")
	private static void createWeaponIDList() {
		realWeaponList = new HashMap<Integer, ArrayList>();
		realWeaponList.put(2, realBootIndex = new ArrayList<Integer>());
		realWeaponList.put(3, realChestIndex = new ArrayList<Integer>());
		realWeaponList.put(4, realGauntletIndex = new ArrayList<Integer>());
		realWeaponList.put(5, realHelmetIndex = new ArrayList<Integer>());
		realWeaponList.put(6, realPantsIndex = new ArrayList<Integer>());
		realWeaponList.put(7, realAxeIndex = new ArrayList<Integer>());
		realWeaponList.put(8, realBluntIndex = new ArrayList<Integer>());
		realWeaponList.put(9, realShieldIndex = new ArrayList<Integer>());
		realWeaponList.put(10, realSpearIndex = new ArrayList<Integer>());
		realWeaponList.put(11, realSwordIndex = new ArrayList<Integer>());
	}

	@SuppressWarnings("unchecked")
	public void inventoryOutPut() {
		createWeaponIDList();
		creatIndexList();
		Character f = ' ';
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
		boolean ergoProxy = true;
		while (ergoProxy) {
			boolean armor = false;
			boolean inventoryChoosing = true;
			while (inventoryChoosing) {
				f = ConsoleReader.readChar("Welche Items wollen Sie sich ansehen oder Ausrüssten?" + exit + "2 oder r = Rüstung | 3 oder w = Waffen");
				if (Character.isLetter(f)) {
					Character.toLowerCase(f);
				}
				if (f == '1') {
					ergoProxy = false;
					inventoryChoosing = false;
				} else if (f == 'r' || f == '2') {
					inventoryChoosing = false;
					armor = true;
				} else if (f == 'w' || f == '3') {
					inventoryChoosing = false;
					armor = false;
				} else {
					System.out.println("Bitte geben Sie eine erlaubte eingabe ein.");
					inventoryChoosing = true;
				}
			}
			if (!ergoProxy && !inventoryChoosing) {
				continue;
			}
			int c = 0;
			boolean ergo = true;
			while (ergo) {
				if (armor) {
					c = iCheck(armor); // chooser for armor
					if (c == 1) {
						ergo = false;
						break;
					} else {
						itemOutPut(realWeaponList.get(c), armor);
						int x = itemChoosage();
						equipArmor((TheArmorEquipment) realWeaponList.get(c).get(x), 0);
						ergo = false;
						ergoProxy = false;
					}
				} else {
					c = iCheck(!armor);
					if (c == 1) {
						ergo = false;
						break;
					} else {
						itemOutPut(realWeaponList.get(c), armor);
						int x = itemChoosage();
						equipHands((HandEquipment) realWeaponList.get(c).get(x), 0);
						ergo = false;
						ergoProxy = false;
					}
				}
			}
		}
	}

	private static int itemChoosage() {
		int c = ConsoleReader.readInteger("Welchen Gegnstand wollen Sie ausrüssten?");
		return c - 1;
	}

	private static void creatIndexList() {
		for (Equipment item : armorEquipment) {
			if (item.getAmount() <= 0) {
				armorEquipment.remove(item);
			} else if (item instanceof Boot) {
				realBootIndex.add(armorEquipment.indexOf(item));
			} else if (item instanceof Chest) {
				realChestIndex.add(armorEquipment.indexOf(item));
			} else if (item instanceof Gauntlet) {
				realGauntletIndex.add(armorEquipment.indexOf(item));
			} else if (item instanceof Helmet) {
				realHelmetIndex.add(armorEquipment.indexOf(item));
			} else if (item instanceof Pants) {
				realPantsIndex.add(armorEquipment.indexOf(item));
			} else {
				System.out.println("Error");
			}
		}
		for (Equipment item : weaponEquipment) {
			if (item.getAmount() <= 0) {
				weaponEquipment.remove(item);
			} else if (item instanceof AxeWeapon) {
				realAxeIndex.add(weaponEquipment.indexOf(item));
			} else if (item instanceof BluntWeapon) {
				realBluntIndex.add(weaponEquipment.indexOf(item));
			} else if (item instanceof Shield) {
				realShieldIndex.add(weaponEquipment.indexOf(item));
			} else if (item instanceof SpearWeapon) {
				realSpearIndex.add(weaponEquipment.indexOf(item));
			} else if (item instanceof SwordWeapon) {
				realSwordIndex.add(weaponEquipment.indexOf(item));
			} else {
				System.out.println("Error");
			}
		}
	}

	private static void itemOutPut(ArrayList<Integer> realNumberListForItemIndex, boolean armor) {
		if (armor) {
			for (int i = 0; i < realNumberListForItemIndex.size(); i++) {
				System.out.println((i + 1) + " =" + armorEquipment.get(realNumberListForItemIndex.get(i)).getValues(armorEquipment.get(realNumberListForItemIndex.get(i)), i));
			}
		} else {
			for (int i = 0; i < realNumberListForItemIndex.size(); i++) {
				System.out.println((i + 1) + " =" + weaponEquipment.get(realNumberListForItemIndex.get(i)).getValues(weaponEquipment.get(realNumberListForItemIndex.get(i)), i));
			}
		}
	}

	private static int handSelection() {
		boolean handSelecting = true;
		int d = 0;
		while (handSelecting) {
			d = ConsoleReader.readInteger("In welche Hand wollen Sie die Waffe ausrüsten? 1 = Links | 2 = Rechts");
			if (d < 3 && d > 0) {
				handSelecting = false;
			} else {
				handSelecting = true;
			}
		}
		return d;
	}

	public void equipArmor(TheArmorEquipment item, int transferAmount) {
		if (item instanceof Boot) {
			if (inventory.getBoots() != null) {
				amountSetting(armorEquipment, inventory.getBoots(), 1);
			}
			inventory.equipingBoots(item);
			amountSetting(armorEquipment, item, transferAmount - 1);
		} else if (item instanceof Gauntlet) {
			if (inventory.getGauntlets() != null) {
				amountSetting(armorEquipment, inventory.getGauntlets(), 1);
			}
			inventory.equipingGauntlets(item);
			amountSetting(armorEquipment, item, transferAmount - 1);
		} else if (item instanceof Pants) {
			if (inventory.getPants() != null) {
				amountSetting(armorEquipment, inventory.getPants(), 1);
			}
			inventory.equipingPants(item);
			amountSetting(armorEquipment, item, transferAmount - 1);
		} else if (item instanceof Helmet) {
			if (inventory.getHelmet() != null) {
				amountSetting(armorEquipment, inventory.getHelmet(), 1);
			}
			inventory.equipingHelmets(item);
			amountSetting(armorEquipment, item, transferAmount - 1);
		} else if (item instanceof Chest) {
			if (inventory.getChest() != null) {
				amountSetting(armorEquipment, inventory.getChest(), 1);
			}
			inventory.equipingChest(item);
			amountSetting(armorEquipment, item, transferAmount - 1);
		} else {
			Error_Systemouts.Error();
		}
		equipment = true;
	}

	public void equipHands(HandEquipment item, int transferAmount) {
		if (item.getOneHanded()) {
			int f = handSelection();
			if (f == 1) {
				if (inventory.getRighthand() != null) {
					amountSetting(weaponEquipment, inventory.getRighthand(), 1);
				}
				inventory.equipingRightHand(item);
				amountSetting(weaponEquipment, item, transferAmount - 1);
			} else if (f == 2) {
				if (inventory.getLefthand() != null) {
					amountSetting(weaponEquipment, inventory.getLefthand(), 1);
				}
				inventory.equipingLeftHand(item);
				amountSetting(weaponEquipment, item, transferAmount - 1);
			} else {
				Error_Systemouts.Error();
			}
		} else {
			if (inventory.getBothhands() != null) {
				amountSetting(weaponEquipment, inventory.getBothhands(), 1);
			}
			amountSetting(weaponEquipment, item, transferAmount - 1);
			inventory.equipingBothHands(item);
		}
		equipment = true;
	}

	private void amountSetting(ArrayList<Equipment> list, Equipment a, int amount) {
		try {
			list.get(list.indexOf(a)).setAmount(amount, false);
		} catch (Exception e) {
			list.add(a);
			list.get(list.indexOf(a)).setAmount(amount, true);
		}
	}

	private void potionListInventory() {
		if (getPotions().size() != 0) {
			for (int i = 0; i < getPotions().size(); i++)
				if (getPotions().get(i).getConsumableType() == Consumable.LEBEN) {
					System.out.println("Für Tränke " + getName() + " hat:  " + getPotions().get(i).getItemName() + " mit einer anzahl von " + getPotions().get(i).getItemAmount() + " Tränken, welche dich für" + getPotions().get(i).getHealthRecovery() + " Lebenspunkte Heilen.");
				} else {
					System.out.println("Für Tränke " + getName() + " hat:  " + getPotions().get(i).getItemName() + " mit einer anzahl von  " + getPotions().get(i).getItemAmount() + " Tränken, welche dich für" + getPotions().get(i).getManaRecovery() + " Mana Punkte.");
				}
		}
	}

	public void currentStats(HashMap<Character, Player> playerList) {
		int gap = 10;
		int startGap = 26;
		String valueOutput1 = Tab.left(startGap, "Name");
		String valueOutput2 = Tab.left(startGap, "Total DEF: ");
		String valueOutput3 = Tab.left(startGap, "Total DMG: ");
		String valueOutput4 = Tab.left(startGap, "Momentanes Mana: ");
		String valueOutput5 = Tab.left(startGap, "Maximales Mana");
		String valueOutput6 = Tab.left(startGap, "Momentanes HP: ");
		String valueOutput7 = Tab.left(startGap, "Maximales HP: ");
		String valueOutput8 = Tab.left(startGap, "Momentanes XP: ");
		String valueOutput9 = Tab.left(startGap, "XP für Level up: ");
		String valueOutput10 = Tab.left(startGap, "Level: ");
		for (Character p : playerList.keySet()) {
			valueOutput1 += Tab.right(gap, playerList.get(p).getName());
			valueOutput2 += Tab.right(gap, playerList.get(p).getArmorWithEquip(playerList.get(p)) + "");
			valueOutput3 += Tab.right(gap, playerList.get(p).getDmgWithEquip(playerList.get(p)) + "");
			valueOutput4 += Tab.right(gap, playerList.get(p).getMana() + "");
			valueOutput5 += Tab.right(gap, playerList.get(p).getMaxMana() + "");
			valueOutput6 += Tab.right(gap, playerList.get(p).getPlayerHP() + "");
			valueOutput7 += Tab.right(gap, playerList.get(p).getPlayerMaxHP() + "");
			valueOutput8 += Tab.right(gap, playerList.get(p).getXp() + "");
			valueOutput9 += Tab.right(gap, playerList.get(p).getExreq() + "");
			valueOutput10 += Tab.right(gap, playerList.get(p).getLvl() + "");
			gap = 15;
		}
		System.out.println(valueOutput1);
		System.out.println(valueOutput2);
		System.out.println(valueOutput3);
		System.out.println(valueOutput4);
		System.out.println(valueOutput5);
		System.out.println(valueOutput6);
		System.out.println(valueOutput7);
		System.out.println(valueOutput8);
		System.out.println(valueOutput9);
		System.out.println(valueOutput10);
	}

	/**
	 * This method shows the current eqipment from a player.
	 * 
	 * @param player player that is getting his equipment shown.
	 */
	public void currentEquipment(Player player) {
		if (equipment) {
			System.out.println(getName() + " hat momentan nichts ausgerüstet");
			if (player.inventory.getBoots() != null) {
				System.out.println("Für Schuhe " + getName() + " hat:  " + player.inventory.getBoots().getItemName() + " mit " + player.inventory.getBootsdef() + " DEF und mit " + player.inventory.getBootsdmg() + "DMG");
				System.out.println();
			}
			if (player.inventory.getChest() != null) {
				System.out.println("Als Brustplatte " + getName() + " hat:  " + player.inventory.getChest().getItemName() + " mit " + player.inventory.getChestdef() + " DEF und mit " + player.inventory.getChestdmg() + "DMG");
				System.out.println();
			}
			if (player.inventory.getGauntlets() != null) {
				System.out.println("Für Handschuhe " + getName() + " hat:  " + player.inventory.getGauntlets().getItemName() + " mit " + player.inventory.getGauntletsdef() + " DEF und mit " + player.inventory.getGauntletsdmg() + "DMG");
				System.out.println();
			}
			if (player.inventory.getPants() != null) {
				System.out.println("Als Hose " + getName() + " hat:  " + player.inventory.getPants().getItemName() + " Ausgerüstet, mit" + player.inventory.getPantsdef() + " DEF und mit " + player.inventory.getPantsdmg() + "DMG");
				System.out.println();
			}
			if (player.inventory.getHelmet() != null) {
				System.out.println("Als Helm " + getName() + " hat:  " + player.inventory.getHelmet().getItemName() + "Ausgerüstet, mit " + player.inventory.getHelmetdef() + "DEF und mit " + player.inventory.getHelmetdmg() + "DMG");
				System.out.println();
			}
			if (player.inventory.getLefthand() != null) {
				System.out.println("Für die linke Hand " + getName() + " hat:  " + player.inventory.getLefthand().getItemName() + " Ausgerüstet, mit " + player.inventory.getWeapondefleft() + " DEF und mit " + player.inventory.getWeapondmgleft() + " DMG");
				System.out.println();
			}
			if (player.inventory.getRighthand() != null) {
				System.out.println("Für die rechte Hand " + getName() + " hat:  " + player.inventory.getRighthand().getItemName() + " Ausgerüstet, mit " + player.inventory.getWeapondefright() + " DEF und mit " + player.inventory.getWeapondmgright() + " DMG");
				System.out.println();
			}
			if (player.inventory.getBothhands() != null) {
				System.out.println("Alls Zweihänder hat " + getName() + " " + player.inventory.getBothhands().getItemName() + " Ausgerüstet, mit " + player.inventory.getWeapondefboth() + " DEF und mit " + player.inventory.getWeapondmgboth() + " DMG");
				System.out.println();
			}
			potionListInventory();
		} else {
			System.out.println(getName() + " hat nichts ausgerüstet.");
			System.out.println();
		}
	}

	/**
	 * Levels up the character
	 */

	private void lvlCalc() {
		lvl++;
		playerBaseDMG *= 1.15;
		if (playerBaseArmor < 7) {
			playerBaseArmor += 1;
		} else {
			playerBaseArmor *= 1.15;
		}
		playerMaxHP *= 1.15;
		setHp(playerMaxHP);
		maxMana *= 1.15;
		setMana(maxMana);
	}

	private void skillLearning() {
		int a = 0;
		a = ConsoleReader.readInteger("Hybrid = 1 | Deffensive = 2 | Agressive = 3");
		switch (a) {
			case 1:
				SkillTree.createSkillTree(true, false, getSkilllist());
				break;
			case 2:
				SkillTree.createSkillTree(false, true, getSkilllist());
				break;
			case 3:
				SkillTree.createSkillTree(false, false, getSkilllist());
				break;
		}
	}

	public void skillOutPut(boolean use) {
		int i = 1;
		if (!use) {
			for (Skill l : getSkilllist()) {
				if (l.getLearned()) {
					System.out.println(i + " = " + l.getName());
				}
			}
		} else {
			for (Skill l : getSkilllist()) {
				if (l.getLearned()) {
					if (l instanceof HYBRIDSkills) {
						if (l.getActiveCD() == 0) {
							System.out.println(i + " = " + l.getName() + " " + l.getCd() + l.getManacosten() + l.getDMG() + l.getDEF());
						}
					} else {
						if (l.getActiveCD() == 0) {
							System.out.println(i + " = " + l.getName() + " " + l.getCd() + l.getManacosten() + l.getValue());
						}
					}
				}
			}
		}
	}

	/**
	 * This Method let's the player select what he wan'ts to do. Attack or use a Potion.
	 * 
	 * @return Returns the choosen action the player want's to happen.
	 */
	// public int standChoose() {
	// boolean stancheChoose = false;
	// int stanceTyp = 0;
	// while (stancheChoose != true) {
	// stanceTyp = ConsoleReader.readInteger("Angreifen = (1) | Trank = (2) | Skill = (3)");
	// if (stanceTyp < 0 || stanceTyp > 3) {
	// System.out.println("Bitte geben Sie eine Gültige eingabe ein!");
	// stancheChoose = false;
	// } else {
	// stancheChoose = true;
	// }
	// }
	// return stanceTyp;
	// }

	/**
	 * This Method is for the time when the player has it's turn to do something. First it let's you choose if the player wants to use a Potion or want's to attack an Enemy. If he want's to attack, he can choose the enemy, if there is more than one
	 * Enemy.
	 * 
	 * @param player gets the player that can do something this turn.
	 */
	// private static void standExecuting(Player player) {
	// boolean playerAttacks = false;
	// while (playerAttacks != true) {
	// int stanceTyp = player.standChoose();
	// switch (stanceTyp) {
	// case 1:
	// playerAttacks = playerAttacking(player);
	// break;
	// case 2:
	// playerAttacks = skillUse(player, null);
	// break;
	// case 3:
	// playerAttacks = consumableItems(player);
	// break;
	// }
	// }
	// }

	/**
	 * This Method is used to calculate the damage dealt and damage received from one participant.
	 * 
	 * @param DMG   /The damage that is dealt.
	 * @param DEF   /The amount of damage that is blocked.
	 * @param enemy /checks if it's an enemy that is dealing the damage
	 */
	// private void attack(Player player, int DMG, int DEF, boolean enemy, int playerTarget) {
	// if (DMG > DEF) {
	// int dealtdmg = DMG - DEF;
	// if (enemy == true) {
	// player.setHp(dealtdmg * -1);
	// System.out.println(enemieList.get(playerTarget).getName() + " griff " + player.getName() + " mit " + DMG + " an.");
	// System.out.println(player.getName() + " verlor " + dealtdmg + " HP");
	// System.out.println(player.getName() + " HP" + player.getPlayerHP());
	// } else {
	// enemieList.get(playerTarget).setHp(enemieList.get(playerTarget).getHp() - dealtdmg);
	// System.out.println(player.getName() + " verursachte " + dealtdmg + " DMG and " + enemieList.get(playerTarget).getName());
	// System.out.println(enemieList.get(playerTarget).getName() + " HP" + enemieList.get(playerTarget).getHp());
	// if (enemieList.get(playerTarget).getHp() <= 0) {
	// enemieList.get(playerTarget).setDead();
	// }
	// }
	// } else {
	// System.out.println("Kein schaden wurde Verursacht.");
	// }
	// }
	/**
	 * This method let's the player consume a Potion that he bought before hand. If he has no Potions he can still chose to attack.
	 * 
	 * @param player This is the player that can select a potion to use.
	 * @return Returns if a potion has been used.
	 */
	// private boolean consumableItems(Player player) {
	// boolean potionChoosing = true;
	// boolean noItem = false;
	// while (potionChoosing) {
	// if (Player.getPotions().size() > 0) {
	// int potionChoose = ConsoleReader.readInteger("Welche art Trank wollen Sie benutzen? 1 = Heilungstrank | 2 = Manatrank");
	// switch (potionChoose) {
	// case 1:
	// for (PouchForConsumable p : Player.getPotions())
	// if (p.getConsumableType() == Consumable.LEBEN) {
	// int f = Player.getPotions().indexOf(p);
	// System.out.print((f + 1) + " = " + p.getItemName() + " ");
	// }
	// int a = ConsoleReader.readInteger("Welchen Trank wollen Sie trinken?") - 1;
	// player.setHp(Player.getPotions().get(a).getHealthRecovery());
	// Player.getPotions().get(a).setItemAmount(Player.getPotions().get(a).getItemAmount() - 1);
	// System.out.println(player.getName() + " hat " + Player.getPotions().get(a).getHealthRecovery() + " Leben regeneriert." + player.getName() + " hat nun " + player.getPlayerHP() + " HP.");
	// potionChoosing = false;
	// noItem = true;
	// break;
	// case 2:
	// for (PouchForConsumable p : Player.getPotions())
	// if (p.getConsumableType() == Consumable.MANA) {
	// int f = Player.getPotions().indexOf(p);
	// System.out.print((f + 1) + " = " + p.getItemName() + " ");
	// }
	// int c = ConsoleReader.readInteger("Welchen Trank wollen Sie trinken?") - 1;
	// player.setMana(Player.getPotions().get(c).getManaRecovery());
	// Player.getPotions().get(c).setItemAmount(Player.getPotions().get(c).getItemAmount() - 1);
	// System.out.println(player.getName() + " hat " + Player.getPotions().get(c).getManaRecovery() + " Mana regeneriert. " + player.getName() + " hat nun " + player.getMana() + " Mana.");
	// potionChoosing = false;
	// noItem = true;
	// break;
	// default:
	// System.out.println("Bitte geen Sie eine Gültige eingabe ein!");
	// potionChoosing = true;
	// break;
	// }
	// } else {
	// potionChoosing = false;
	// System.out.println(potionChoosing);
	// noItem = false;
	// }
	// }
	// return noItem;
	// }

	/**
	 * calculates your LVL
	 * 
	 * @param player The player that is getting a level up
	 * @param xp     gets the xp gained from the enemy.
	 * 
	 */
	public void xpCalc(Player player, int xp) {
		while (xp != 0 || xp >= exreq) {
			if (xp >= exreq) {
				xp -= exreq;
				exreq -= exreq;
				if (exreq <= 0) {
					player.lvlCalc();
					skillLearning();
					System.out.println(getName() + " hat aufgelevelt!");
					System.out.println(getName() + " ist nun Level " + lvl);
					exreq = lvl * exincreas;
					System.out.println(getName() + " braucht nun " + exreq + " für das nächste Levelup.");
				}
			} else {
				exreq -= xp;
				System.out.println(getName() + " braucht noch" + exreq + " XP.");
				xp = 0;
			}
		}
	}

	/**
	 * This Method calculates the total armor of one character.
	 * 
	 * @param player The player that should be checked.
	 * @return Returns the total amount of defense that this character has.
	 */
	public int getArmorWithEquip(Player player) {
		playerTotalArmor = playerBaseArmor;
		playerTotalArmor += player.inventory.getBootsdef();
		playerTotalArmor += player.inventory.getChestdef();
		playerTotalArmor += player.inventory.getGauntletsdef();
		playerTotalArmor += player.inventory.getHelmetdef();
		playerTotalArmor += player.inventory.getPantsdef();
		playerTotalArmor += player.inventory.getWeapondefleft();
		playerTotalArmor += player.inventory.getWeapondefright();
		playerTotalArmor += player.inventory.getWeapondefboth();
		return playerTotalArmor;
	}

	/**
	 * This Method calculates the total damage of one character.
	 * 
	 * @param player The player that should be checked.
	 * @return Returns the total amount of damage that this character has.
	 */
	public int getDmgWithEquip(Player player) {
		playerToatlDMG = playerBaseDMG;
		playerToatlDMG += player.inventory.getWeapondmgleft();
		playerToatlDMG += player.inventory.getWeapondmgright();
		playerToatlDMG += player.inventory.getWeapondmgboth();
		playerToatlDMG += player.inventory.getBootsdmg();
		playerToatlDMG += player.inventory.getChestdmg();
		playerToatlDMG += player.inventory.getGauntletsdmg();
		playerToatlDMG += player.inventory.getHelmetdmg();
		playerToatlDMG += player.inventory.getPantsdmg();
		return playerToatlDMG;
	}

	public void setHp(int hp) {
		if (hp + playerHP >= playerMaxHP) {
			playerHP = playerMaxHP;
		} else {
			this.playerHP += hp;
		}
	}

	public static void setMoney(int playerMoney) {
		Player.money += playerMoney;
	}

	public static int getMoneyFromPlayer() {
		return Player.money;
	}

	public int getMana() {
		return baseMana;
	}

	public void setMana(int mana) {
		if (mana + baseMana >= maxMana) {
			baseMana = maxMana;
		} else {
			this.baseMana += mana;
		}
	}

	public int getPlayerBaseArmor() {
		return playerBaseArmor;
	}

	public int getPlayerBaseDMG() {
		return playerBaseDMG;
	}

	public static ArrayList<Equipment> getArmorEquipment() {
		return armorEquipment;
	}

	public static ArrayList<Equipment> getWeaponEquipment() {
		return weaponEquipment;
	}

	public static ArrayList<PouchForConsumable> getPotions() {
		return potions;
	}

	public int getPlayerHP() {
		return playerHP;
	}

	public int getLvl() {
		return lvl;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public int getPlayerMaxHP() {
		return playerMaxHP;
	}

	public int getExreq() {
		return exreq;
	}

	public Inventory getInventory() {
		return inventory;
	}
}
