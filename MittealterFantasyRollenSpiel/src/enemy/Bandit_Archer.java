package enemy;

import java.util.ArrayList;

import skills.Skill;
import skills.SkillTree;

public class Bandit_Archer extends Enemies {

	private static final int ID = 2;

	public Bandit_Archer(int a) {
		super("Bandit Archer " + a, enemyValueGenerator(10, 30)/* HP */, enemyValueGenerator(10, 15) /* DMG */,
				enemyValueGenerator(0, 9) /* DEF */, enemyValueGenerator(100, 200)/* XP */,
				enemyValueGenerator(10, 20)/* money */, enemyValueGenerator(10, 20)/* mana */);
		skilllist = new ArrayList<Skill>();
		skilllist = SkillTree.createEnemieSkills("Aimed Shot", 2/* cooldown */, 5/* manacost */, 20/* value */,
				skilllist, false/* def skill or not */);
		skilllist = SkillTree.createEnemieSkills("Dodge roll", 2/* cooldown */, 5/* manacost */, 20/* value */,
				skilllist, true/* def skill or not */);
		skilllist = SkillTree.createEnemieHYBRIDSkills("Fastshot", 2/* cooldown */, 5/* manacost */, 5/* dmg */,
				10/* def */, skilllist);
	}

	public static int getId() {
		return ID;
	}

}
