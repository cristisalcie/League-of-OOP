package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class XPAngel extends AbstractAngel {
    public XPAngel(final int posX, final int posY) {
        super();
        setPosX(posX);
        setPosY(posY);
    }

    @Override
    public void affect(final Knight knight) {
        if (!knight.isDead()) {
            setHelped(true);
            getUtl().addHeroXp(knight, Constants.XPANGELONKNIGHTBONUS);
        }
    }
    @Override
    public void affect(final Pyromancer pyromancer) {
        if (!pyromancer.isDead()) {
            setHelped(true);
            getUtl().addHeroXp(pyromancer,
                    Constants.XPANGELONPYROMANCERBONUS);
        }
    }
    @Override
    public void affect(final Rogue rogue) {
        if (!rogue.isDead()) {
            setHelped(true);
            getUtl().addHeroXp(rogue, Constants.XPANGELONROGUEBONUS);
        }
    }
    @Override
    public void affect(final Wizard wizard) {
        if (!wizard.isDead()) {
            setHelped(true);
            getUtl().addHeroXp(wizard, Constants.XPANGELONWIZARDBONUS);
        }
    }

    @Override
    public String getName() {
        return "XPAngel";
    }
}
