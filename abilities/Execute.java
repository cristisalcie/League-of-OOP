package abilities;

import common.Constants;
import heroes.AbstractHero;
import terrain.AbstractTerrain;
import java.util.List;

public final class Execute extends AbstractSkill {

    public Execute() {
        super();
        setDmg(Constants.EXECUTEDMG);
        setRawDmg();

        setVsKnightModif(Constants.EXECUTEVSKNIGHTMODIF);
        setVsPyromancerModif(Constants.EXECUTEVSPYROMANCERMODIF);
        setVsRogueModif(Constants.EXECUTEVSROGUEMODIF);
        setVsWizardModif(Constants.EXECUTEVSWIZARDMODIF);
    }

    @Override
    public void updateDmg(final int level) {
        setDmg(Constants.EXECUTEDMG + Constants.EXTRAEXECUTEDMGLVL * level);
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
        float executeLimit = Constants.EXECUTELIMIT
                + Constants.EXTRAEXECUTELIMITLVL * level;
        if (executeLimit > Constants.MAXEXECUTELIMIT) {
            executeLimit = Constants.MAXEXECUTELIMIT;
        }

        if (hero.getHp() <= executeLimit * hero.getFullHp()) {
            setDmg(hero.getHp());
        }
        // Attack with calculated damage like everyone else.
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
