package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class LifeGiver extends AbstractAngel {
    public LifeGiver(final int posX, final int posY) {
        super();
        setPosX(posX);
        setPosY(posY);
    }

    @Override
    public void affect(final Knight knight) {
        if (!knight.isDead()) {
            setHelped(true);
            knight.setHp(Math.min(knight.getHp()
                    + Constants.LIFEGIVERONKNIGHTHP, knight.getFullHp()));
        }
    }
    @Override
    public void affect(final Pyromancer pyromancer) {
        if (!pyromancer.isDead()) {
            setHelped(true);
            pyromancer.setHp(Math.min(pyromancer.getHp()
                    + Constants.LIFEGIVERONPYROMANCERHP,
                    pyromancer.getFullHp()));
        }
    }
    @Override
    public void affect(final Rogue rogue) {
        if (!rogue.isDead()) {
            setHelped(true);
            rogue.setHp(Math.min(rogue.getHp()
                    + Constants.LIFEGIVERONROGUEHP, rogue.getFullHp()));
        }
    }
    @Override
    public void affect(final Wizard wizard) {
        if (!wizard.isDead()) {
            setHelped(true);
            wizard.setHp(Math.min(wizard.getHp()
                    + Constants.LIFEGIVERONWIZARDHP, wizard.getFullHp()));
        }
    }

    @Override
    public String getName() {
        return "LifeGiver";
    }
}
