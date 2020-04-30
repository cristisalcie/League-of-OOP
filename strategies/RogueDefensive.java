package strategies;

import abilities.AbstractSkill;
import common.Constants;
import heroes.AbstractHero;

public class RogueDefensive implements Strategy {
    @Override
    public final void use(final AbstractHero hero) {
        for (AbstractSkill skill : hero.getSkills()) {
            skill.setVsKnightModif(skill.getVsKnightModif()
                    - Constants.ROGUEDEFENSIVEDMGMODIF);
            skill.setVsPyromancerModif(skill.getVsPyromancerModif()
                    - Constants.ROGUEDEFENSIVEDMGMODIF);
            skill.setVsRogueModif(skill.getVsRogueModif()
                    - Constants.ROGUEDEFENSIVEDMGMODIF);
            skill.setVsWizardModif(skill.getVsWizardModif()
                    - Constants.ROGUEDEFENSIVEDMGMODIF);
        }
        hero.setHp(hero.getHp() + Constants.ROGUEDEFENSIVEHPNUMMODIF
                * hero.getHp() / Constants.ROGUEDEFENSIVEHPDENOMMODIF);
    }
}
