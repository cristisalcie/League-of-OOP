package abilities;

import common.Constants;
import heroes.AbstractHero;
import terrain.AbstractTerrain;
import java.util.List;

public final class Backstab extends AbstractSkill {

    public Backstab() {
        super();
        setDmg(Constants.BACKSTABDMG);
        setRawDmg();

        setVsKnightModif(Constants.BACKSTABVSKNIGHTMODIF);
        setVsPyromancerModif(Constants.BACKSTABVSPYROMANCERMODIF);
        setVsRogueModif(Constants.BACKSTABVSROGUEMODIF);
        setVsWizardModif(Constants.BACKSTABVSWIZARDMODIF);
    }

    @Override
    public void updateDmg(final int level) {
        setDmg(Constants.BACKSTABDMG + Constants.EXTRABACKSTABDMGLVL * level);
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
