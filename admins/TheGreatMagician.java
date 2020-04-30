package admins;

import angels.AbstractAngel;
import heroes.AbstractHero;

public final class TheGreatMagician implements Admin {

    private static TheGreatMagician theGreatMagician = null;

    private TheGreatMagician() {
        // It's singleton.
    }

    public static TheGreatMagician getInstance() {
        if (theGreatMagician == null) {
            theGreatMagician = new TheGreatMagician();
        }
        return theGreatMagician;
    }

    @Override
    public void checkAngel(final AbstractAngel angel) {
        angel.checkForSpawned();
        angel.checkForHit();
        angel.checkForHelp();
    }
    @Override
    public void checkHero(final AbstractHero hero) {
        hero.checkForDeath();
        hero.checkForResurrected();
        hero.checkForLevelUp();
    }
}
