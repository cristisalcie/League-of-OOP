package abilities;

import common.Constants;
import heroes.AbstractHero;
import terrain.AbstractTerrain;
import java.util.List;

public final class Drain extends AbstractSkill {

    public Drain() {
        super();
        setDmg(Constants.DRAINPERCENTAGE);
        setRawDmg();

        setVsKnightModif(Constants.DRAINVSKNIGHTMODIF);
        setVsPyromancerModif(Constants.DRAINVSPYROMANCERMODIF);
        setVsRogueModif(Constants.DRAINVSROGUEMODIF);
        setVsWizardModif(Constants.DRAINVSWIZARDMODIF);
    }

    @Override
    public void updateDmg(final int level) {
        setDmg(Constants.DRAINPERCENTAGE
                + Constants.EXTRADRAINPERCENTAGELVL * level);
        setRawDmg();
    }

    @Override
    public void tryToKill(final AbstractHero hero,
                          final int level,
                          final List<List<AbstractTerrain>> map) {
        getEffect(hero); // We apply on percentage the race modifier.
        float baseHp = Math.min(Constants.DRAINBASEHPFORMULAMODIF
                * hero.getFullHp(), hero.getHp());
        // getDmg() for Drain contains the percentage.
        float dmg = (getDmg() * baseHp);
        // We setDmg to be the actual damage to give.
        setDmg(dmg);
            // We apply the terrain modifier on dmg field.
        getEffect(map.get(hero.getPosX()).get(hero.getPosY()));
        hero.setHp(hero.getHp() - Math.round(getDmg()));
    }

    @Override
    public void getEffect(final AbstractTerrain terrain) {
        terrain.affect(this);
    }
    @Override
    public void getEffect(final AbstractHero hero) {
        hero.affect(this);
    }
}
