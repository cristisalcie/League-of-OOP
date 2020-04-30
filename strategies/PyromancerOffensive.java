package strategies;

import abilities.AbstractSkill;
import common.Constants;
import heroes.AbstractHero;

public class PyromancerOffensive implements Strategy {
    @Override
    public final void use(final AbstractHero hero) {
        hero.setHp(hero.getHp() - Constants.PYROOFFENSIVEHPNUMMODIF
                * hero.getHp() / Constants.PYROOFFENSIVEHPDENOMMODIF);
        for (AbstractSkill skill : hero.getSkills()) {
            skill.setVsKnightModif(skill.getVsKnightModif()
                    + Constants.PYROOFFENSIVEDMGMODIF);
            skill.setVsPyromancerModif(skill.getVsPyromancerModif()
                    + Constants.PYROOFFENSIVEDMGMODIF);
            skill.setVsRogueModif(skill.getVsRogueModif()
                    + Constants.PYROOFFENSIVEDMGMODIF);
            skill.setVsWizardModif(skill.getVsWizardModif()
                    + Constants.PYROOFFENSIVEDMGMODIF);
        }
    }
}
