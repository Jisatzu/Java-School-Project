package enemy;

import java.util.ArrayList;

import skills.*;

public class Assasin extends Enemies {

	private static final int ID = 1;

	public Assasin(int a) {
		super("Assasin " + a, enemyValueGenerator(10, 30)/* HP */, enemyValueGenerator(10, 15) /* DMG */,
				enemyValueGenerator(0, 9) /* DEF */, enemyValueGenerator(100, 200)/* XP */,
				enemyValueGenerator(10, 20)/* money */, enemyValueGenerator(10, 20)/* mana */);
		skilllist = new ArrayList<Skill>();
		skilllist = SkillTree.createEnemieSkills("Piercing", 2/* cooldown */, 5/* manacost */, 20/* value */, skilllist,
				false/* def skill or not */);
		skilllist = SkillTree.createEnemieSkills("Smokescreen", 2/* cooldown */, 5/* manacost */, 20/* value */,
				skilllist, true/* def skill or not */);
		skilllist = SkillTree.createEnemieHYBRIDSkills("Parry", 2/* cooldown */, 5/* manacost */, 5/* dmg */,
				10/* def */, skilllist);
	}

	public static int getId() {
		return ID;
	}

}
