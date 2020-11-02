package enemy;

public class Pixie extends Enemies {

	private static final int ID = 7;

	public Pixie(int i) {
		super("Pixie", enemyValueGenerator(10, 30)/* HP */, enemyValueGenerator(10, 15) /* DMG */,
				enemyValueGenerator(0, 9) /* DEF */, enemyValueGenerator(100, 200)/* XP */,
				enemyValueGenerator(10, 20)/* money */, enemyValueGenerator(10, 20)/* mana */);
	}

	public static int getId() {
		return ID;
	}

}
