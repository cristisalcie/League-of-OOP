package abilities;

import common.Constants;
import heroes.AbstractHero;
import terrain.AbstractTerrain;
import java.util.List;

public final class Ignite extends AbstractSkill {

    public Ignite() {
        super();
        setDmg(Constants.IGNITEDMG);
        setRawDmg();
        setAoTDmg(Constants.IGNITEDOT);
        setRawAoTDmg();
        // We set the AoT rounds depending on what terrain Ignite is.

        setVsKnightModif(Constants.IGNITEVSKNIGHTMODIF);
        setVsPyromancerModif(Constants.IGNITEVSPYROMANCERMODIF);
        setVsRogueModif(Constants.IGNITEVSROGUEMODIF);
        setVsWizardModif(Constants.IGNITEVSWIZARDMODIF);
    }

    @Override
    public void updateDmg(final int level) {
        setDmg(Constants.IGNITEDMG + Constants.EXTRAIGNITEDMGLVL * level);
        setRawDmg();
        setAoTDmg(Constants.IGNITEDOT + Constants.EXTRAIGNITEDOTLVL * level);
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
