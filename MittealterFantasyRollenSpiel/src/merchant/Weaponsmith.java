package merchant;

import java.util.ArrayList;

import actions.Merchant;
import equipment.Equipment;
import equipment.MaterialsForEquipment;
import equipment.MaterialsForEquipment.MaterialType;
import repetitiveStuff.checkAndleaveFuncitons;
import weapon.AxeWeapon;
import weapon.BluntWeapon;
import weapon.Shield;
import weapon.SpearWeapon;
import weapon.SwordWeapon;

public class Weaponsmith extends Merchant {
	/**
	 * The amount of money that the Armorer has.
	 */
	private int ArmoryMoney;
	/**
	 * The Boolean to check if someone wants to leave this building.
	 */
	private boolean leave = false;
	/**
	 * ArrayList with all one handed wooden Axes
	 */
	private ArrayList<Equipment> allWeapon;
	/**
	 * String List with all Two handed metal Axes
	 */
	private ArrayList<Integer> indexOfRealList;

	/**
	 * Constructor to creat an Weaponsmith mearchant.
	 * 
	 * @param Name         The name of the Weaponsmith
	 * @param baseHP       the amount of hp the Weaponsmith has
	 * @param baseArmor    the amount of armor the Weaponsmith has
	 * @param baseDmg      the amount od dmg that Weaponsmith has
	 * @param XP           the amount of xp that the Weaponsmith has
	 * @param money        the maount of money the Weaponsmith has
	 * @param profession   the profession that the Weaponsmith has
	 * @param goods        the goods that the armorer is selling
	 * @param building     the name of the building
	 * @param city         the name of the city
	 * @param playablechar is this a playable char
	 */
	public Weaponsmith(String Name, int baseHP, int baseArmor, int baseDmg, int XP, int money, String profession,
			String goods, String building, String city, boolean playablechar) {
		super(Name, baseHP, baseArmor, baseDmg, XP, money, profession, goods, building, city, playablechar);
		ArmoryMoney = money;
		randomiseAmount();
	}

	/**
	 * Here the player can buy Weapons
	 * 
	 * @param player the player that is buying weapons
	 * @return retunrs the equipped player
	 */
	public void weaponChoosing() {
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
							"What type of material do you wish for? m = metal | w = wood | l = back"));
					if (b == null && getMatChoosing()) {
						buy = checkAndleaveFuncitons.leave(buy);
					} else if (b != null) {
						boolean armorType = false;
						while (!armorType) {
							a = checkAndleaveFuncitons.charactertoSmallLetter(
									("What type of armor do you wish for? s = sword | a = axe | b = bluntweapons | p = polearms | d = shields | l = back"));
							if (a == 'l') {
								armorType = checkAndleaveFuncitons.leave(armorType);
							} else {
								indexOfRealList = new ArrayList<Integer>();
								indexOfRealList = equipmentValueWriter(a, b, allWeapon);
								buyingAndSelling(indexOfRealList, allWeapon, ArmoryMoney, true);
							}
						}
					}
				}
			} else if (z == 2) {
				sellEquipment(true);
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
			allWeapon.add(new AxeWeapon(randomValueGenerator(), material, true));
			allWeapon.add(new BluntWeapon(randomValueGenerator(), material, true));
			allWeapon.add(new SpearWeapon(randomValueGenerator(), material, true));
			allWeapon.add(new SwordWeapon(randomValueGenerator(), material, true));
			allWeapon.add(new Shield(randomValueGenerator(), material));
			allWeapon.add(new AxeWeapon(randomValueGenerator(), material, false));
			allWeapon.add(new BluntWeapon(randomValueGenerator(), material, false));
			allWeapon.add(new SpearWeapon(randomValueGenerator(), material, false));
			allWeapon.add(new SwordWeapon(randomValueGenerator(), material, false));
		}
		for (MaterialsForEquipment material : MaterialsForEquipment.getType(MaterialType.WOOD)) {
			allWeapon.add(new AxeWeapon(randomValueGenerator(), material, true));
			allWeapon.add(new BluntWeapon(randomValueGenerator(), material, true));
			allWeapon.add(new SpearWeapon(randomValueGenerator(), material, true));
			allWeapon.add(new SwordWeapon(randomValueGenerator(), material, true));
			allWeapon.add(new Shield(randomValueGenerator(), material));
			allWeapon.add(new AxeWeapon(randomValueGenerator(), material, false));
			allWeapon.add(new BluntWeapon(randomValueGenerator(), material, false));
			allWeapon.add(new SpearWeapon(randomValueGenerator(), material, false));
			allWeapon.add(new SwordWeapon(randomValueGenerator(), material, false));
			;
		}
	}

	/**
	 * Method to be sure that all the lists have been renewed.
	 */
	public void randomiseAmount() {
		allWeapon = new ArrayList<Equipment>();
		creatInventar();
	}
}