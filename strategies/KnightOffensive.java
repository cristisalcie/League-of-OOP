package strategies;

import abilities.AbstractSkill;
import common.Constants;
import heroes.AbstractHero;

public class KnightOffensive implements Strategy {
    @Override
    public final void use(final AbstractHero hero) {
        hero.setHp(hero.getHp() - Constants.KNIGHTOFFENSIVEHPNUMMODIF
                * hero.getHp() / Constants.KNIGHTOFFENSIVEHPDENOMMODIF);
        for (AbstractSkill skill : hero.getSkills()) {
            skill.setVsKnightModif(skill.getVsKnightModif()
                    + Constants.KNIGHTOFFENSIVEDMGMODIF);
            skill.setVsPyromancerModif(skill.getVsPyromancerModif()
                    + Constants.KNIGHTOFFENSIVEDMGMODIF);
            skill.setVsRogueModif(skill.getVsRogueModif()
                    + Constants.KNIGHTOFFENSIVEDMGMODIF);
            skill.setVsWizardModif(skill.getVsWizardModif()
                    + Constants.KNIGHTOFFENSIVEDMGMODIF);
        }
    }
}
