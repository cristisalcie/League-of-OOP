package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class TheDoomer extends AbstractAngel {
    public TheDoomer(final int posX, final int posY) {
        super();
        setPosX(posX);
        setPosY(posY);
    }

    @Override
    public void affect(final Knight knight) {
        if (!knight.isDead()) {
            setHit(true);
            knight.setHp(0);
            knight.setDamagedByAngel(true);
        }
    }
    @Override
    public void affect(final Pyromancer pyromancer) {
        if (!pyromancer.isDead()) {
            setHit(true);
            pyromancer.setHp(0);
            pyromancer.setDamagedByAngel(true);
        }
    }
    @Override
    public void affect(final Rogue rogue) {
        if (!rogue.isDead()) {
            setHit(true);
            rogue.setHp(0);
            rogue.setDamagedByAngel(true);
        }
    }
    @Override
    public void affect(final Wizard wizard) {
        if (!wizard.isDead()) {
            setHit(true);
            wizard.setHp(0);
            wizard.setDamagedByAngel(true);
        }
    }

    @Override
    public String getName() {
        return "TheDoomer";
    }
}
