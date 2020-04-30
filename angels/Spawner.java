package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class Spawner extends AbstractAngel {
    public Spawner(final int posX, final int posY) {
        super();
        setPosX(posX);
        setPosY(posY);
    }

    @Override
    public void affect(final Knight knight) {
        if (knight.isDead()) {
            setHelped(true);
            knight.setHp(Constants.SPAWNERONKNIGHTHP);
            knight.setBeResurrected(true);
        }
    }
    @Override
    public void affect(final Pyromancer pyromancer) {
        if (pyromancer.isDead()) {
            setHelped(true);
            pyromancer.setHp(Constants.SPAWNERONPYROMANCERHP);
            pyromancer.setBeResurrected(true);
        }
    }
    @Override
    public void affect(final Rogue rogue) {
        if (rogue.isDead()) {
            setHelped(true);
            rogue.setHp(Constants.SPAWNERONROGUEHP);
            rogue.setBeResurrected(true);
        }
    }
    @Override
    public void affect(final Wizard wizard) {
        if (wizard.isDead()) {
            setHelped(true);
            wizard.setHp(Constants.SPAWNERONWIZARDHP);
            wizard.setBeResurrected(true);
        }
    }

    @Override
    public String getName() {
        return "Spawner";
    }
}
