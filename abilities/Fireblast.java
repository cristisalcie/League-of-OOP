package abilities;

import common.Constants;
import heroes.AbstractHero;
import terrain.AbstractTerrain;
import java.util.List;

public final class Fireblast extends AbstractSkill {

    public Fireblast() {
        super();
        setDmg(Constants.FIREBLASTDMG); // This is the startup dmg at lvl 0.
        setRawDmg();

        setVsKnightModif(Constants.FIREBLASTVSKNIGHTMODIF);
        setVsPyromancerModif(Constants.FIREBLASTVSPYROMANCERMODIF);
        setVsRogueModif(Constants.FIREBLASTVSROGUEMODIF);
        setVsWizardModif(Constants.FIREBLASTVSWIZARDMODIF);
    }

    @Override
    public void updateDmg(final int level) {
        setDmg(Constants.FIREBLASTDMG
                + Constants.EXTRAFIREBLASTDMGLVL * level);
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
