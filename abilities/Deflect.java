package abilities;

import common.Constants;
import terrain.AbstractTerrain;
import heroes.AbstractHero;
import java.util.List;

public final class Deflect extends AbstractSkill {

    public Deflect() {
        super();
        setDmg(Constants.DEFLECTPERCENTAGE);
        setRawDmg();

        setVsKnightModif(Constants.DEFLECTVSKNIGHTMODIF);
        setVsPyromancerModif(Constants.DEFLECTVSPYROMANCERMODIF);
        setVsRogueModif(Constants.DEFLECTVSROGUEMODIF);
        setVsWizardModif(Constants.DEFLECTVSWIZARDMODIF);
    }

    @Override
    public void updateDmg(final int level) {
        // For wizard: deflect's getDmg, getRawDmg contains the percentage.
        setDmg(Constants.DEFLECTPERCENTAGE
                + Constants.EXTRADEFLECTPERCENTAGELVL * level);
        if (getDmg() > Constants.MAXDEFLECTPERCENTAGE) {
            setDmg(Constants.MAXDEFLECTPERCENTAGE);
        }
        setRawDmg();
    }

    @Override
    public void tryToKill(final AbstractHero hero,
                          final int level,
                          final List<List<AbstractTerrain>> map) {
        float totalDmg = 0;
        for (int i = 0; i < hero.getSkills().size(); i++) {
            // Get terrain modifier on to deflect skill.
            hero.getSkills().get(i).getEffect(
                    map.get(hero.getPosX()).get(hero.getPosY()));
            // Add to total damage to deflect.
            totalDmg += hero.getSkills().get(i).getDmg();
            /* Reset the terrain modifier applied from the skill to deflect.
            * It's only necessary when we fight Wizard vs Wizard on Desert
            * because we need to reset the second wizard's drain terrain
            * modifier back to raw modifier. If we don't do that then the
            * second wizard will attack the first wizard with a percentage
            * that has terrain modifier from when first wizard attacked. */
            hero.getSkills().get(i).setDmg(
                    hero.getSkills().get(i).getRawDmg());
            hero.getSkills().get(i).setAoTDmg(
                    hero.getSkills().get(i).getRawAoTDmg());
        }
        // getDmg() contains the percentage of to deflect damage.
        totalDmg = totalDmg * getDmg();
        /* We setDmg because we need to apply effects to it, on top of that
        * it's the actual damage now, not the percentage. */
        setDmg(Math.round(totalDmg));
        getEffect(map.get(hero.getPosX()).get(hero.getPosY()));
        getEffect(hero);


        /* Following line is because in tests Math.round(1.45 * 110) = 159
        * instead of 160. */
        setDmg(getDmg() - Constants.FLOATERROR);


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
