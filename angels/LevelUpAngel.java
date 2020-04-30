package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class LevelUpAngel extends AbstractAngel {
    public LevelUpAngel(final int posX, final int posY) {
        super();
        setPosX(posX);
        setPosY(posY);
    }

    @Override
    public void affect(final Knight knight) {
        if (!knight.isDead()) {
            setHelped(true);
            int xpGift = Constants.XPCONST1 + knight.getLevel()
                    * Constants.XPCONST3 - knight.getXp();
            getUtl().addHeroXp(knight, xpGift);
            for (int i = 0; i < knight.getSkills().size(); i++) {
                knight.getSkills().get(i).
                        setVsKnightModif(knight.getSkills().get(i).
                                getVsKnightModif()
                                + Constants.LEVELUPANGELONKNIGHTDMGMODIF);
                knight.getSkills().get(i).
                        setVsPyromancerModif(knight.getSkills().get(i).
                                getVsPyromancerModif()
                                + Constants.LEVELUPANGELONKNIGHTDMGMODIF);
                knight.getSkills().get(i).
                        setVsRogueModif(knight.getSkills().get(i).
                                getVsRogueModif()
                                + Constants.LEVELUPANGELONKNIGHTDMGMODIF);
                knight.getSkills().get(i).
                        setVsWizardModif(knight.getSkills().get(i).
                                getVsWizardModif()
                                + Constants.LEVELUPANGELONKNIGHTDMGMODIF);
            }
        }
    }
    @Override
    public void affect(final Pyromancer pyromancer) {
        if (!pyromancer.isDead()) {
            setHelped(true);
            int xpGift = Constants.XPCONST1 + pyromancer.getLevel()
                    * Constants.XPCONST3 - pyromancer.getXp();
            getUtl().addHeroXp(pyromancer, xpGift);
            for (int i = 0; i < pyromancer.getSkills().size(); i++) {
                pyromancer.getSkills().get(i).
                        setVsKnightModif(pyromancer.getSkills().get(i).
                                getVsKnightModif()
                                + Constants.LEVELUPANGELONPYROMANCERDMGMODIF);
                pyromancer.getSkills().get(i).
                        setVsPyromancerModif(pyromancer.getSkills().get(i).
                                getVsPyromancerModif()
                                + Constants.LEVELUPANGELONPYROMANCERDMGMODIF);
                pyromancer.getSkills().get(i).
                        setVsRogueModif(pyromancer.getSkills().get(i).
                                getVsRogueModif()
                                + Constants.LEVELUPANGELONPYROMANCERDMGMODIF);
                pyromancer.getSkills().get(i).
                        setVsWizardModif(pyromancer.getSkills().get(i).
                                getVsWizardModif()
                                + Constants.LEVELUPANGELONPYROMANCERDMGMODIF);
            }
        }
    }
    @Override
    public void affect(final Rogue rogue) {
        if (!rogue.isDead()) {
            setHelped(true);
            int xpGift = Constants.XPCONST1 + rogue.getLevel()
                    * Constants.XPCONST3 - rogue.getXp();
            getUtl().addHeroXp(rogue, xpGift);
            for (int i = 0; i < rogue.getSkills().size(); i++) {
                rogue.getSkills().get(i).
                        setVsKnightModif(rogue.getSkills().get(i).
                                getVsKnightModif()
                                + Constants.LEVELUPANGELONROGUEDMGMODIF);
                rogue.getSkills().get(i).
                        setVsPyromancerModif(rogue.getSkills().get(i).
                                getVsPyromancerModif()
                                + Constants.LEVELUPANGELONROGUEDMGMODIF);
                rogue.getSkills().get(i).
                        setVsRogueModif(rogue.getSkills().get(i).
                                getVsRogueModif()
                                + Constants.LEVELUPANGELONROGUEDMGMODIF);
                rogue.getSkills().get(i).
                        setVsWizardModif(rogue.getSkills().get(i).
                                getVsWizardModif()
                                + Constants.LEVELUPANGELONROGUEDMGMODIF);
            }
        }
    }
    @Override
    public void affect(final Wizard wizard) {
        if (!wizard.isDead()) {
            setHelped(true);
            int xpGift = Constants.XPCONST1 + wizard.getLevel()
                    * Constants.XPCONST3 - wizard.getXp();
            getUtl().addHeroXp(wizard, xpGift);
            for (int i = 0; i < wizard.getSkills().size(); i++) {
                wizard.getSkills().get(i).
                        setVsKnightModif(wizard.getSkills().get(i).
                                getVsKnightModif()
                                + Constants.LEVELUPANGELONWIZARDDMGMODIF);
                wizard.getSkills().get(i).
                        setVsPyromancerModif(wizard.getSkills().get(i).
                                getVsPyromancerModif()
                                + Constants.LEVELUPANGELONWIZARDDMGMODIF);
                wizard.getSkills().get(i).
                        setVsRogueModif(wizard.getSkills().get(i).
                                getVsRogueModif()
                                + Constants.LEVELUPANGELONWIZARDDMGMODIF);
                wizard.getSkills().get(i).
                        setVsWizardModif(wizard.getSkills().get(i).
                                getVsWizardModif()
                                + Constants.LEVELUPANGELONWIZARDDMGMODIF);
            }
        }
    }

    @Override
    public String getName() {
        return "LevelUpAngel";
    }
}
