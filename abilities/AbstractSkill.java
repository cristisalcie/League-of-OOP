package abilities;

import heroes.AbstractHero;
import terrain.AbstractTerrain;
import java.util.List;

public abstract class AbstractSkill {
    private float dmg;
    private float rawDmg;
    private float aoTDmg;
    private float rawAoTDmg;
    private int strikeCounter; // Only used to Backstab at the moment.
    private int aoTRounds;
    private boolean rootAbility;

    private float vsKnightModif;
    private float vsPyromancerModif;
    private float vsRogueModif;
    private float vsWizardModif;

    public AbstractSkill() {
        setDmg(0);
        setRawDmg();
        setAoTDmg(0);
        setRawAoTDmg();
        setStrikeCounter(0);
        setAoTRounds(0);
        setRootAbility(false);
    }

    public final boolean isRootAbility() {
        return rootAbility;
    }
    public final void setRootAbility(final boolean pRootAbility) {
        rootAbility = pRootAbility;
    }

    public final int getAoTRounds() {
        return aoTRounds;
    }
    public final void setAoTRounds(final int pAoTRounds) {
        aoTRounds = pAoTRounds;
    }

    public final int getStrikeCounter() {
        return strikeCounter;
    }
    public final void setStrikeCounter(final int pStrikeCounter) {
        strikeCounter = pStrikeCounter;
    }

    public final boolean isAoTAbility() {
        return getAoTRounds() > 0;
    }

    public final float getRawAoTDmg() {
        return rawAoTDmg;
    }
    public final void setRawAoTDmg() {
        rawAoTDmg = getAoTDmg();
    }

    public final float getAoTDmg() {
        return aoTDmg;
    }
    public final void setAoTDmg(final float pAoTDmg) {
        aoTDmg = pAoTDmg;
    }

    public final float getRawDmg() {
        return rawDmg;
    }
    public final void setRawDmg() {
        rawDmg = getDmg();
    }

    public final float getDmg() {
        return dmg;
    }
    public final void setDmg(final float pDmg) {
        dmg = pDmg;
    }

    public final float getVsKnightModif() {
        return vsKnightModif;
    }
    public final void setVsKnightModif(final float pVsKnightModif) {
        vsKnightModif = pVsKnightModif;
    }
    public final float getVsPyromancerModif() {
        return vsPyromancerModif;
    }
    public final void setVsPyromancerModif(final float pVsPyromancerModif) {
        vsPyromancerModif = pVsPyromancerModif;
    }
    public final float getVsRogueModif() {
        return vsRogueModif;
    }
    public final void setVsRogueModif(final float pVsRogueModif) {
        vsRogueModif = pVsRogueModif;
    }
    public final float getVsWizardModif() {
        return vsWizardModif;
    }
    public final void setVsWizardModif(final float pVsWizardModif) {
        vsWizardModif = pVsWizardModif;
    }

    public abstract void updateDmg(int level);
    public abstract void tryToKill(AbstractHero hero, int level,
                                   List<List<AbstractTerrain>> map);
    public abstract void getEffect(AbstractTerrain terrain);
    public abstract void getEffect(AbstractHero hero);
}
