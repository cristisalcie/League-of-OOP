package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class Dracula extends AbstractAngel {
    public Dracula(final int posX, final int posY) {
        super();
        setPosX(posX);
        setPosY(posY);
    }

    @Override
    public void affect(final Knight knight) {
        if (!knight.isDead()) {
            setHit(true);
            for (int i = 0; i < knight.getSkills().size(); i++) {
                knight.getSkills().get(i).
                        setVsKnightModif(knight.getSkills().get(i).
                                getVsKnightModif()
                                - Constants.DRACULAONKNIGHTDMGMODIF);
                knight.getSkills().get(i).
                        setVsPyromancerModif(knight.getSkills().get(i).
                                getVsPyromancerModif()
                                - Constants.DRACULAONKNIGHTDMGMODIF);
                knight.getSkills().get(i).
                        setVsRogueModif(knight.getSkills().get(i).
                                getVsRogueModif()
                                - Constants.DRACULAONKNIGHTDMGMODIF);
                knight.getSkills().get(i).
                        setVsWizardModif(knight.getSkills().get(i).
                                getVsWizardModif()
                                - Constants.DRACULAONKNIGHTDMGMODIF);
            }
            knight.setHp(knight.getHp() - Constants.DRACULAONKNIGHTHP);
            knight.setDamagedByAngel(true);
        }
    }
    @Override
    public void affect(final Pyromancer pyromancer) {
        if (!pyromancer.isDead()) {
            setHit(true);
            for (int i = 0; i < pyromancer.getSkills().size(); i++) {
                pyromancer.getSkills().get(i).
                        setVsKnightModif(pyromancer.getSkills().get(i).
                                getVsKnightModif()
                                - Constants.DRACULAONPYROMANCERDMGMODIF);
                pyromancer.getSkills().get(i).
                        setVsPyromancerModif(pyromancer.getSkills().get(i).
                                getVsPyromancerModif()
                                - Constants.DRACULAONPYROMANCERDMGMODIF);
                pyromancer.getSkills().get(i).
                        setVsRogueModif(pyromancer.getSkills().get(i).
                                getVsRogueModif()
                                - Constants.DRACULAONPYROMANCERDMGMODIF);
                pyromancer.getSkills().get(i).
                        setVsWizardModif(pyromancer.getSkills().get(i).
                                getVsWizardModif()
                                - Constants.DRACULAONPYROMANCERDMGMODIF);
            }
            pyromancer.setHp(pyromancer.getHp()
                    - Constants.DRACULAONPYROMANCERHP);
            pyromancer.setDamagedByAngel(true);
        }
    }
    @Override
    public void affect(final Rogue rogue) {
        if (!rogue.isDead()) {
            setHit(true);
            for (int i = 0; i < rogue.getSkills().size(); i++) {
                rogue.getSkills().get(i).
                        setVsKnightModif(rogue.getSkills().get(i).
                                getVsKnightModif()
                                - Constants.DRACULAONROGUEDMGMODIF);
                rogue.getSkills().get(i).
                        setVsPyromancerModif(rogue.getSkills().get(i).
                                getVsPyromancerModif()
                                - Constants.DRACULAONROGUEDMGMODIF);
                rogue.getSkills().get(i).
                        setVsRogueModif(rogue.getSkills().get(i).
                                getVsRogueModif()
                                - Constants.DRACULAONROGUEDMGMODIF);
                rogue.getSkills().get(i).
                        setVsWizardModif(rogue.getSkills().get(i).
                                getVsWizardModif()
                                - Constants.DRACULAONROGUEDMGMODIF);
            }
            rogue.setHp(rogue.getHp() - Constants.DRACULAONROGUEHP);
            rogue.setDamagedByAngel(true);
        }
    }
    @Override
    public void affect(final Wizard wizard) {
        if (!wizard.isDead()) {
            setHit(true);
            for (int i = 0; i < wizard.getSkills().size(); i++) {
                wizard.getSkills().get(i).
                        setVsKnightModif(wizard.getSkills().get(i).
                                getVsKnightModif()
                                - Constants.DRACULAONWIZARDDMGMODIF);
                wizard.getSkills().get(i).
                        setVsPyromancerModif(wizard.getSkills().get(i).
                                getVsPyromancerModif()
                                - Constants.DRACULAONWIZARDDMGMODIF);
                wizard.getSkills().get(i).
                        setVsRogueModif(wizard.getSkills().get(i).
                                getVsRogueModif()
                                - Constants.DRACULAONWIZARDDMGMODIF);
                wizard.getSkills().get(i).
                        setVsWizardModif(wizard.getSkills().get(i).
                                getVsWizardModif()
                                - Constants.DRACULAONWIZARDDMGMODIF);
            }
            wizard.setHp(wizard.getHp() - Constants.DRACULAONWIZARDHP);
            wizard.setDamagedByAngel(true);
        }
    }

    @Override
    public String getName() {
        return "Dracula";
    }
}
