package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class DamageAngel extends AbstractAngel {
    public DamageAngel(final int posX, final int posY) {
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
                                + Constants.DAMAGEANGELONKNIGHTDMGMODIF);
                knight.getSkills().get(i).
                        setVsPyromancerModif(knight.getSkills().get(i).
                                getVsPyromancerModif()
                                + Constants.DAMAGEANGELONKNIGHTDMGMODIF);
                knight.getSkills().get(i).
                        setVsRogueModif(knight.getSkills().get(i).
                                getVsRogueModif()
                                + Constants.DAMAGEANGELONKNIGHTDMGMODIF);
                knight.getSkills().get(i).
                        setVsWizardModif(knight.getSkills().get(i).
                                getVsWizardModif()
                                + Constants.DAMAGEANGELONKNIGHTDMGMODIF);
            }
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
                                + Constants.DAMAGEANGELONPYROMANCERDMGMODIF);
                pyromancer.getSkills().get(i).
                        setVsPyromancerModif(pyromancer.getSkills().get(i).
                                getVsPyromancerModif()
                                + Constants.DAMAGEANGELONPYROMANCERDMGMODIF);
                pyromancer.getSkills().get(i).
                        setVsRogueModif(pyromancer.getSkills().get(i).
                                getVsRogueModif()
                                + Constants.DAMAGEANGELONPYROMANCERDMGMODIF);
                pyromancer.getSkills().get(i).
                        setVsWizardModif(pyromancer.getSkills().get(i).
                                getVsWizardModif()
                                + Constants.DAMAGEANGELONPYROMANCERDMGMODIF);
            }
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
                                + Constants.DAMAGEANGELONROGUEDMGMODIF);
                rogue.getSkills().get(i).
                        setVsPyromancerModif(rogue.getSkills().get(i).
                                getVsPyromancerModif()
                                + Constants.DAMAGEANGELONROGUEDMGMODIF);
                rogue.getSkills().get(i).
                        setVsRogueModif(rogue.getSkills().get(i).
                                getVsRogueModif()
                                + Constants.DAMAGEANGELONROGUEDMGMODIF);
                rogue.getSkills().get(i).
                        setVsWizardModif(rogue.getSkills().get(i).
                                getVsWizardModif()
                                + Constants.DAMAGEANGELONROGUEDMGMODIF);
            }
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
                                + Constants.DAMAGEANGELONWIZARDDMGMODIF);
                wizard.getSkills().get(i).
                        setVsPyromancerModif(wizard.getSkills().get(i).
                                getVsPyromancerModif()
                                + Constants.DAMAGEANGELONWIZARDDMGMODIF);
                wizard.getSkills().get(i).
                        setVsRogueModif(wizard.getSkills().get(i).
                                getVsRogueModif()
                                + Constants.DAMAGEANGELONWIZARDDMGMODIF);
                wizard.getSkills().get(i).
                        setVsWizardModif(wizard.getSkills().get(i).
                                getVsWizardModif()
                                + Constants.DAMAGEANGELONWIZARDDMGMODIF);
            }
        }
    }

    @Override
    public String getName() {
        return "DamageAngel";
    }


}
