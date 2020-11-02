package merchant;

import java.util.ArrayList;

import actions.Merchant;
import armor.Boot;
import armor.Chest;
import armor.Gauntlet;
import armor.Helmet;
import armor.Pants;
import equipment.Equipment;
import equipment.MaterialsForEquipment;
import equipment.MaterialsForEquipment.MaterialType;
import repetitiveStuff.checkAndleaveFuncitons;

/**
 * This Class if for all the Armor Trading needed in this Game.
 * 
 * @author Batuhan.avci
 *
 */
public class Armorer extends Merchant {
	private int ArmoryMoney;
	/**
	 * The Boolean to check if someone wants to leave this building.
	 */
	private boolean leave = false;
	/**
	 * String list with all boots made out of Metals.
	 */
	// private HashMap<String, TheArmorEquipment> allArmor;
	private ArrayList<Equipment> allArmor;
	private ArrayList<Integer> indexOfRealList;

	/**
	 * Constructor to creat an Armor mearchant.
	 * 
	 * @param Name         The name of the Armorer
	 * @param baseHP       the amount of hp the armorer has
	 * @param baseArmor    the amount of armor the armorer has
	 * @param baseDmg      the amount od dmg that armorer has
	 * @param XP           the amount of xp that the armorer has
	 * @param money        the maount of money the armorer has
	 * @param profession   the profession that the armorer has
	 * @param goods        the goods that the armorer is selling
	 * @param building     the name of the building
	 * @param city         the name of the city
	 * @param playablechar is this a playable char
	 */
	public Armorer(String Name, int baseHP, int baseArmor, int baseDmg, int XP, int money, String profession,
			String goods, String building, String city, boolean playablechar) {
		super(Name, baseHP, baseArmor, baseDmg, XP, money, profession, goods, building, city, playablechar);
		ArmoryMoney = money;
		randomiseAmount();
	}

	public void armoreChoose() {
		int z = 0;
		leave = false;
		while (!leave) {
			z = buyOrSell(false);
			if (z == 1) {
				boolean buy = false;
				while (!buy) {
					Character a;
					MaterialType b;
					b = getMatType(checkAndleaveFuncitons.charactertoSmallLetter(
							"What type of material do you wish for? m = metal | f = fabric | l = back"));
					if (b == null && getMatChoosing()) {
						buy = checkAndleaveFuncitons.leave(buy);
					} else if (b != null) {
						boolean armorType = false;
						while (!armorType) {
							a = checkAndleaveFuncitons.charactertoSmallLetter(
									("What type of armor do you wish for? b = boots | c = chest | h = helmets | g = gauntlets | p = pants | l = back"));
							if (a == 'l') {
								armorType = checkAndleaveFuncitons.leave(armorType);
							} else if (checkAndleaveFuncitons.actionChoos("bchgp", a)) {
								indexOfRealList = new ArrayList<Integer>();
								indexOfRealList = equipmentValueWriter(a, b, allArmor);
								buyingAndSelling(indexOfRealList, allArmor, ArmoryMoney, true);
							}
						}
					}
				}
			} else if (z == 2) {
				sellEquipment(false);
			} else {
				leave = true;
			}
		}
	}

	/**
	 * Creates the Inventory for the inn.
	 */
	private void creatInventar() {
		for (MaterialsForEquipment material : MaterialsForEquipment.getType(MaterialType.METAL)) {
			allArmor.add(new Boot(randomValueGenerator(), material));
			allArmor.add(new Chest(randomValueGenerator(), material));
			allArmor.add(new Helmet(randomValueGenerator(), material));
			allArmor.add(new Gauntlet(randomValueGenerator(), material));
			allArmor.add(new Pants(randomValueGenerator(), material));
		}
		for (MaterialsForEquipment material : MaterialsForEquipment.getType(MaterialType.FABRIC)) {
			allArmor.add(new Boot(randomValueGenerator(), material));
			allArmor.add(new Chest(randomValueGenerator(), material));
			allArmor.add(new Helmet(randomValueGenerator(), material));
			allArmor.add(new Gauntlet(randomValueGenerator(), material));
			allArmor.add(new Pants(randomValueGenerator(), material));
		}
	}

	/**
	 * Method to be sure that all the lists have been renewed.
	 */
	public void randomiseAmount() {
		allArmor = new ArrayList<Equipment>();
		creatInventar();
	}

}
