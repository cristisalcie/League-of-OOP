package abilities;

import common.Constants;
import heroes.AbstractHero;
import terrain.AbstractTerrain;
import java.util.List;

public final class Slam extends AbstractSkill {

    public Slam() {
        super();
        setDmg(Constants.SLAMDMG);
        setRawDmg();
        setRootAbility(true);
        // We set the AoT rounds depending on what terrain Slam is.

        setVsKnightModif(Constants.SLAMVSKNIGHTMODIF);
        setVsPyromancerModif(Constants.SLAMVSPYROMANCERMODIF);
        setVsRogueModif(Constants.SLAMVSROGUEMODIF);
        setVsWizardModif(Constants.SLAMVSWIZARDMODIF);
    }

    @Override
    public void updateDmg(final int level) {
        setDmg(Constants.SLAMDMG + Constants.EXTRASLAMDMGLVL * level);
        setRawDmg();
    }

    @Override
    public void tryToKill(final AbstractHero hero,
                          final int level,
                          final List<List<AbstractTerrain>> map) {
        // Applying to skill of hero the extra modifiers.
        getEffect(map.get(hero.getPosX()).get(hero.getPosY()));
        setDmg(Math.round(getDmg()));
        getEffect(hero);
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
