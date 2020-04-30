package strategies;

import abilities.AbstractSkill;
import common.Constants;
import heroes.AbstractHero;

public class KnightDefensive implements Strategy {
    @Override
    public final void use(final AbstractHero hero) {
        for (AbstractSkill skill : hero.getSkills()) {
            skill.setVsKnightModif(skill.getVsKnightModif()
                    - Constants.KNIGHTDEFENSIVEDMGMODIF);
            skill.setVsPyromancerModif(skill.getVsPyromancerModif()
                    - Constants.KNIGHTDEFENSIVEDMGMODIF);
            skill.setVsRogueModif(skill.getVsRogueModif()
                    - Constants.KNIGHTDEFENSIVEDMGMODIF);
            skill.setVsWizardModif(skill.getVsWizardModif()
                    - Constants.KNIGHTDEFENSIVEDMGMODIF);
        }
        hero.setHp(hero.getHp() + Constants.KNIGHTDEFENSIVEHPNUMMODIF
                * hero.getHp() / Constants.KNIGHTDEFENSIVEHPDENOMMODIF);
    }
}
