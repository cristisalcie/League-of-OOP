package strategies;

import abilities.AbstractSkill;
import common.Constants;
import heroes.AbstractHero;

public class PyromancerDefensive implements Strategy {
    @Override
    public final void use(final AbstractHero hero) {
        for (AbstractSkill skill : hero.getSkills()) {
            skill.setVsKnightModif(skill.getVsKnightModif()
                    - Constants.PYRODEFENSIVEDMGMODIF);
            skill.setVsPyromancerModif(skill.getVsPyromancerModif()
                    - Constants.PYRODEFENSIVEDMGMODIF);
            skill.setVsRogueModif(skill.getVsRogueModif()
                    - Constants.PYRODEFENSIVEDMGMODIF);
            skill.setVsWizardModif(skill.getVsWizardModif()
                    - Constants.PYRODEFENSIVEDMGMODIF);
        }
        hero.setHp(hero.getHp() + Constants.PYRODEFENSIVEHPNUMMODIF
                * hero.getHp() / Constants.PYRODEFENSIVEHPDENOMMODIF);
    }
}
