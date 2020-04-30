package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class DarkAngel extends AbstractAngel {
    public DarkAngel(final int posX, final int posY) {
        super();
        setPosX(posX);
        setPosY(posY);
    }

    @Override
    public void affect(final Knight knight) {
        if (!knight.isDead()) {
            setHit(true);
            knight.setHp(knight.getHp() - Constants.DARKANGELONKNIGHTHP);
            knight.setDamagedByAngel(true);
        }
    }
    @Override
    public void affect(final Pyromancer pyromancer) {
        if (!pyromancer.isDead()) {
            setHit(true);
            pyromancer.setHp(pyromancer.getHp()
                    - Constants.DARKANGELONPYROMANCERHP);
            pyromancer.setDamagedByAngel(true);
        }
    }
    @Override
    public void affect(final Rogue rogue) {
        if (!rogue.isDead()) {
            setHit(true);
            rogue.setHp(rogue.getHp() - Constants.DARKANGELONROGUEHP);
            rogue.setDamagedByAngel(true);
        }
    }
    @Override
    public void affect(final Wizard wizard) {
        if (!wizard.isDead()) {
            setHit(true);
            wizard.setHp(wizard.getHp() - Constants.DARKANGELONWIZARDHP);
            wizard.setDamagedByAngel(true);
        }
    }

    @Override
    public String getName() {
        return "DarkAngel";
    }
}
