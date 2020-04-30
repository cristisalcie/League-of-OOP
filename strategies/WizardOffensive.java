package strategies;

import abilities.AbstractSkill;
import common.Constants;
import heroes.AbstractHero;

public class WizardOffensive implements Strategy {
    @Override
    public final void use(final AbstractHero hero) {
        hero.setHp(hero.getHp() - Constants.WIZARDOFFENSIVEHPNUMMODIF
                * hero.getHp() / Constants.WIZARDOFFENSIVEHPDENOMMODIF);
        for (AbstractSkill skill : hero.getSkills()) {
            skill.setVsKnightModif(skill.getVsKnightModif()
                    + Constants.WIZARDOFFENSIVEDMGMODIF);
            skill.setVsPyromancerModif(skill.getVsPyromancerModif()
                    + Constants.WIZARDOFFENSIVEDMGMODIF);
            skill.setVsRogueModif(skill.getVsRogueModif()
                    + Constants.WIZARDOFFENSIVEDMGMODIF);
            skill.setVsWizardModif(skill.getVsWizardModif()
                    + Constants.WIZARDOFFENSIVEDMGMODIF);
        }
    }
}
