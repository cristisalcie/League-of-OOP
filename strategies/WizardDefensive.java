package strategies;

import abilities.AbstractSkill;
import common.Constants;
import heroes.AbstractHero;

public class WizardDefensive implements Strategy {
    @Override
    public final void use(final AbstractHero hero) {
        for (AbstractSkill skill : hero.getSkills()) {
            skill.setVsKnightModif(skill.getVsKnightModif()
                    - Constants.WIZARDDEFENSIVEDMGMODIF);
            skill.setVsPyromancerModif(skill.getVsPyromancerModif()
                    - Constants.WIZARDDEFENSIVEDMGMODIF);
            skill.setVsRogueModif(skill.getVsRogueModif()
                    - Constants.WIZARDDEFENSIVEDMGMODIF);
            skill.setVsWizardModif(skill.getVsWizardModif()
                    - Constants.WIZARDDEFENSIVEDMGMODIF);
        }
        hero.setHp(hero.getHp() + Constants.WIZARDDEFENSIVEHPNUMMODIF
                * hero.getHp() / Constants.WIZARDDEFENSIVEHPDENOMMODIF);
    }
}
