package strategies;

import abilities.AbstractSkill;
import common.Constants;
import heroes.AbstractHero;

public class RogueOffensive implements Strategy {
    @Override
    public final void use(final AbstractHero hero) {
        hero.setHp(hero.getHp() - Constants.ROGUEOFFENSIVEHPNUMMODIF
                * hero.getHp() / Constants.ROGUEOFFENSIVEHPDENOMMODIF);
        for (AbstractSkill skill : hero.getSkills()) {
            skill.setVsKnightModif(skill.getVsKnightModif()
                    + Constants.ROGUEOFFENSIVEDMGMODIF);
            skill.setVsPyromancerModif(skill.getVsPyromancerModif()
                    + Constants.ROGUEOFFENSIVEDMGMODIF);
            skill.setVsRogueModif(skill.getVsRogueModif()
                    + Constants.ROGUEOFFENSIVEDMGMODIF);
            skill.setVsWizardModif(skill.getVsWizardModif()
                    + Constants.ROGUEOFFENSIVEDMGMODIF);
        }
    }
}
