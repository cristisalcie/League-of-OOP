package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class SmallAngel extends AbstractAngel {
    public SmallAngel(final int posX, final int posY) {
        super();
        setPosX(posX);
        setPosY(posY);
    }

    @Override
    public void affect(final Knight knight) {
        if (!knight.isDead()) {
            setHelped(true);
            for (int i = 0; i < knight.getSkills().size(); i++) {
                knight.getSkills().get(i).
                        setVsKnightModif(knight.getSkills().get(i).
                                getVsKnightModif()
                                + Constants.SMALLANGELONKNIGHTDMGMODIF);
                knight.getSkills().get(i).
                        setVsPyromancerModif(knight.getSkills().get(i).
                                getVsPyromancerModif()
                                + Constants.SMALLANGELONKNIGHTDMGMODIF);
                knight.getSkills().get(i).
                        setVsRogueModif(knight.getSkills().get(i).
                                getVsRogueModif()
                                + Constants.SMALLANGELONKNIGHTDMGMODIF);
                knight.getSkills().get(i).
                        setVsWizardModif(knight.getSkills().get(i).
                                getVsWizardModif()
                                + Constants.SMALLANGELONKNIGHTDMGMODIF);
            }
            knight.setHp(Math.min(knight.getHp()
                    + Constants.SMALLANGELONKNIGHTHP, knight.getFullHp()));
        }
    }
    @Override
    public void affect(final Pyromancer pyromancer) {
        if (!pyromancer.isDead()) {
            setHelped(true);
            for (int i = 0; i < pyromancer.getSkills().size(); i++) {
                pyromancer.getSkills().get(i).
                        setVsKnightModif(pyromancer.getSkills().get(i).
                                getVsKnightModif()
                                + Constants.SMALLANGELONPYROMANCERDMGMODIF);
                pyromancer.getSkills().get(i).
                        setVsPyromancerModif(pyromancer.getSkills().get(i).
                                getVsPyromancerModif()
                                + Constants.SMALLANGELONPYROMANCERDMGMODIF);
                pyromancer.getSkills().get(i).
                        setVsRogueModif(pyromancer.getSkills().get(i).
                                getVsRogueModif()
                                + Constants.SMALLANGELONPYROMANCERDMGMODIF);
                pyromancer.getSkills().get(i).
                        setVsWizardModif(pyromancer.getSkills().get(i).
                                getVsWizardModif()
                                + Constants.SMALLANGELONPYROMANCERDMGMODIF);
            }
            pyromancer.setHp(Math.min(pyromancer.getHp()
                    + Constants.SMALLANGELONPYROMANCERHP,
                    pyromancer.getFullHp()));
        }
    }
    @Override
    public void affect(final Rogue rogue) {
        if (!rogue.isDead()) {
            setHelped(true);
            for (int i = 0; i < rogue.getSkills().size(); i++) {
                rogue.getSkills().get(i).
                        setVsKnightModif(rogue.getSkills().get(i).
                                getVsKnightModif()
                                + Constants.SMALLANGELONROGUEDMGMODIF);
                rogue.getSkills().get(i).
                        setVsPyromancerModif(rogue.getSkills().get(i).
                                getVsPyromancerModif()
                                + Constants.SMALLANGELONROGUEDMGMODIF);
                rogue.getSkills().get(i).
                        setVsRogueModif(rogue.getSkills().get(i).
                                getVsRogueModif()
                                + Constants.SMALLANGELONROGUEDMGMODIF);
                rogue.getSkills().get(i).
                        setVsWizardModif(rogue.getSkills().get(i).
                                getVsWizardModif()
                                + Constants.SMALLANGELONROGUEDMGMODIF);
            }
            rogue.setHp(Math.min(rogue.getHp()
                    + Constants.SMALLANGELONROGUEHP, rogue.getFullHp()));
        }
    }
    @Override
    public void affect(final Wizard wizard) {
        if (!wizard.isDead()) {
            setHelped(true);
            for (int i = 0; i < wizard.getSkills().size(); i++) {
                wizard.getSkills().get(i).
                        setVsKnightModif(wizard.getSkills().get(i).
                                getVsKnightModif()
                                + Constants.SMALLANGELONWIZARDDMGMODIF);
                wizard.getSkills().get(i).
                        setVsPyromancerModif(wizard.getSkills().get(i).
                                getVsPyromancerModif()
                                + Constants.SMALLANGELONWIZARDDMGMODIF);
                wizard.getSkills().get(i).
                        setVsRogueModif(wizard.getSkills().get(i).
                                getVsRogueModif()
                                + Constants.SMALLANGELONWIZARDDMGMODIF);
                wizard.getSkills().get(i).
                        setVsWizardModif(wizard.getSkills().get(i).
                                getVsWizardModif()
                                + Constants.SMALLANGELONWIZARDDMGMODIF);
            }
            wizard.setHp(Math.min(wizard.getHp()
                    + Constants.SMALLANGELONWIZARDHP, wizard.getFullHp()));
        }
    }

    @Override
    public String getName() {
        return "SmallAngel";
    }
}
