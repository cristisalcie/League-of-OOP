package angels;

import common.Utilities;
import heroes.AbstractHero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public abstract class AbstractAngel implements AngelSubject {

    private Utilities utl;

    private int posX;
    private int posY;

    private boolean spawned;
    private boolean hit;
    private boolean helped;

    private AbstractHero affectedHero;

    public AbstractAngel() {
        utl = Utilities.getInstance();
        setSpawned(true);
        setHit(false);
        setHelped(false);
        setAffectedHero(null);
    }

    @Override
    public final void checkForSpawned() {
        if (isSpawned()) {
            getUtl().getOutput().add("Angel " + getName() + " was spawned at "
                    + getPosX() + " " + getPosY() + "\n");
            setSpawned(false);
        }
    }
    @Override
    public final void checkForHit() {
        if (hasHit()) {
            getUtl().getOutput().add(getName() + " hit "
                    + getAffectedHero().getName() + " "
                    + getAffectedHero().getId() + "\n");
            setHit(false);
        }
    }
    @Override
    public final void checkForHelp() {
        if (hasHelped()) {
            getUtl().getOutput().add(getName() + " helped "
                    + getAffectedHero().getName() + " "
                    + getAffectedHero().getId() + "\n");
            setHelped(false);
        }
    }

    public final Utilities getUtl() {
        return utl;
    }

    public final int getPosX() {
        return posX;
    }
    public final void setPosX(final int pPosX) {
        posX = pPosX;
    }
    public final int getPosY() {
        return posY;
    }
    public final void setPosY(final int pPosY) {
        posY = pPosY;
    }

    public final boolean isSpawned() {
        return spawned;
    }
    public final void setSpawned(final boolean pSpawned) {
        spawned = pSpawned;
    }

    public final boolean hasHit() {
        return hit;
    }
    public final void setHit(final boolean pHit) {
        hit = pHit;
        getUtl().notifyAdmins(this);
    }

    public final boolean hasHelped() {
        return helped;
    }
    public final void setHelped(final boolean pHelped) {
        helped = pHelped;
        getUtl().notifyAdmins(this);
    }

    public final AbstractHero getAffectedHero() {
        return affectedHero;
    }
    public final void setAffectedHero(final AbstractHero hero) {
        affectedHero = hero;
    }

    public abstract void affect(Knight knight);
    public abstract void affect(Pyromancer pyromancer);
    public abstract void affect(Rogue rogue);
    public abstract void affect(Wizard wizard);

    public abstract String getName();
}
