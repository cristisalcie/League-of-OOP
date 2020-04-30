package abilities;

import common.Constants;
import heroes.AbstractHero;
import terrain.AbstractTerrain;
import java.util.List;

public final class Paralysis extends AbstractSkill {

    public Paralysis() {
        super();
        setDmg(Constants.PARALYSISDMG);
        setRawDmg();
        setAoTDmg(Constants.PARALYSISDOT);
        setRawAoTDmg();
        setRootAbility(true);
        // We set the AoT rounds depending on what terrain Paralysis is.

        setVsKnightModif(Constants.PARALYSISVSKNIGHTMODIF);
        setVsPyromancerModif(Constants.PARALYSISVSPYROMANCERMODIF);
        setVsRogueModif(Constants.PARALYSISVSROGUEMODIF);
        setVsWizardModif(Constants.PARALYSISVSWIZARDMODIF);
    }

    @Override
    public void updateDmg(final int level) {
        setDmg(Constants.PARALYSISDMG + Constants.EXTRAPARALYSISDMGLVL * level);
        setRawDmg();
        setAoTDmg(Constants.PARALYSISDOT
                + Constants.EXTRAPARALYSISDOTLVL * level);
        setRawAoTDmg();
    }

    @Override
    public void tryToKill(final AbstractHero hero,
                          final int level,
                          final List<List<AbstractTerrain>> map) {
        // Applying to skill of hero the extra modifiers.
        getEffect(map.get(hero.getPosX()).get(hero.getPosY()));
        setDmg(Math.round(getDmg()));
        setAoTDmg(Math.round(getAoTDmg()));
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
