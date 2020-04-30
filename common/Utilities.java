package common;

import abilities.AbstractSkill;
import admins.Admin;
import admins.AdminType;
import admins.AdminsFactory;
import angels.AbstractAngel;
import heroes.AbstractHero;
import terrain.AbstractTerrain;
import java.util.ArrayList;
import java.util.List;

public final class Utilities {

    private List<String> output = null;
    private List<Admin> admins = null;
    private AdminsFactory adminsFactory;
    private static Utilities utl = null;

    private Utilities() {
        // It's singleton.
        adminsFactory = AdminsFactory.getInstance();
    }

    public static Utilities getInstance() {
        if (utl == null) {
            utl = new Utilities();
        }
        return utl;
    }

    public void prepareAdmins() {
        // We add the admins.
        getAdmins().add(getAdminsFactory().getAdmin(
                AdminType.TheGreatMagician));
    }

    public void notifyAdmins(final AbstractAngel angel) {
        for (Admin admin : getAdmins()) {
            admin.checkAngel(angel);
        }
    }

    public void notifyAdmins(final AbstractHero hero) {
        for (Admin admin : getAdmins()) {
            admin.checkHero(hero);
        }
    }

    public void fight(final AbstractHero hero1, final AbstractHero hero2,
                             final List<List<AbstractTerrain>> map) {
        if (!hero1.hasFought() && !hero2.hasFought()) {
            /* Side Note: We access the terrain they are on, by one of the
            * heroes's position that are fighting. */

            damageHero(hero1, hero2, map);
            damageHero(hero2, hero1, map);

            updateStrikeCounters(hero1, hero2);

            // Determine if any of them died
            checkStatus(hero1);
            checkStatus(hero2);

            if (hero1.isDead() && hero2.isDead()) {
                hero1.setKiller(hero2);
                hero2.setKiller(hero1);
            } else if (hero2.isDead()) {
                hero2.setKiller(hero1);
                // hero1 won -> apply xp.
                addWinnerXp(hero1, hero2.getLevel());
            } else if (hero1.isDead()) {
                hero1.setKiller(hero2);
                // hero2 won -> apply xp.
                addWinnerXp(hero2, hero1.getLevel());
            }
            // Else they are both alive - nothing to do.
        }
        hero1.setFought(true);
        hero2.setFought(true);
    }

    public void addWinnerXp(final AbstractHero heroWinner,
                                   final int levelLoser) {
        int xpObtained = Math.max(0,
                Constants.XPCONST2 - ((heroWinner.getLevel() - levelLoser)
                        * Constants.XPCONST4));
        addHeroXp(heroWinner, xpObtained);
    }

    public void addHeroXp(final AbstractHero hero,
                                 final int xpObtained) {
        hero.setXp(hero.getXp() + xpObtained);
        while (hero.getXp() >= Constants.XPCONST1
                + hero.getLevel() * Constants.XPCONST3) {
            levelUp(hero);
        }
    }

    public void levelUp(final AbstractHero hero) {
        hero.setLevel(hero.getLevel() + 1);
        hero.setLeveledUp(true);
        if (!hero.isDead()) {
            hero.healHpAtLvlUp(); // This also notifies admins through setHp().
        }
        for (int i = 0; i < hero.getSkills().size(); i++) {
            hero.updateDmgAtLvlUp(hero.getSkills().get(i));
        }
    }

    /**
     * @param hero1 is the hero that attacks
     * @param hero2 is the one who is being attacked.
     * @param map  is the map they damage each other on.
     */
    public void damageHero(final AbstractHero hero1,
                           final AbstractHero hero2,
                           final List<List<AbstractTerrain>> map) {

        for (int i = 0; i < hero1.getSkills().size(); i++) {

            hero1.getSkills().get(i).tryToKill(
                    hero2, hero1.getLevel(), map);

            /* It checks if aoTRounds > 0 of the ability, if it is, then
            * overwrite the previous effect if there was one. */
            if (hero1.getSkills().get(i).isAoTAbility()) {
                /* Skill's aoTDmg should be 0 if it is just a root ability
                * like slam. */
                hero2.setAoTDmgToApply(hero1.getSkills().get(i).getAoTDmg());

                /* hero2's rooted field should be false if hero1's ability
                * is not a root ability. */
                hero2.setRooted(hero1.getSkills().get(i).isRootAbility());

                hero2.setAffectedByAoTRounds(
                        hero1.getSkills().get(i).getAoTRounds());
            }
            /* Restoring hero1's damage back to before the modifiers were
            * applied. */
            restoreDamage(hero1.getSkills().get(i));
        }
        hero2.setLastHitBy(hero1);
    }

    public void restoreDamage(final AbstractSkill skill) {
        skill.setDmg(skill.getRawDmg());
        skill.setAoTDmg(skill.getRawAoTDmg());
    }

    public void applyAoT(final AbstractHero hero) {
        // Hp remains the same if it is an ability like slam.
        hero.setHp(hero.getHp() - Math.round(hero.getAoTDmgToApply()));
        /* If hero.getAffectedByAoTRounds - 1 == 0 then when it will get to
        * check whether a hero isAffectedByAoT it will set root effect to
        * false.*/
        checkStatus(hero);
        if (hero.isDead()) {
            /* We set the killer to null because he died by an DoT. However if
            * we wanted to know who gave him the DoT he died from we simply set
            * the killer to hero.getLastHitBy(); */
            hero.setKiller(null);
        }
    }

    /**
     * This method updates for all skills the strike counter as it might be
     * useful in the future. (for example more abilities have to do stuff
     * depending on amount of strikes that they have done).
     * @param hero1 - updates for hero1
     * @param hero2 - updates for hero2
     */
    public void updateStrikeCounters(final AbstractHero hero1,
                                     final AbstractHero hero2) {
        for (int i = 0; i < hero1.getSkills().size(); i++) {
            hero1.getSkills().get(i).setStrikeCounter(
                    hero1.getSkills().get(i).getStrikeCounter() + 1);
        }
        for (int i = 0; i < hero2.getSkills().size(); i++) {
            hero2.getSkills().get(i).setStrikeCounter(
                    hero2.getSkills().get(i).getStrikeCounter() + 1);
        }
    }

    public void spawnAngel(final AbstractAngel angel) {
        notifyAdmins(angel);
    }

    public void affectHeroByAngel(final AbstractAngel angel,
                                  final AbstractHero hero) {
        hero.getAffectedBy(angel);
    }

    public void checkStatus(final AbstractHero hero) {
        if (hero.getHp() <= 0 && !hero.isDead()) {
            hero.setDead(true);
        } else if (hero.getHp() > 0 && hero.isDead()) {
            hero.setDead(false);
        }
    }

    public void printRound(final int round) {
        getOutput().add("~~ Round " + round + " ~~\n");
    }

    public List<String> getOutput() {
        if (output == null) {
            output = new ArrayList<>();
        }
        return output;
    }

    public List<Admin> getAdmins() {
        if (admins == null) {
            admins = new ArrayList<>();
        }
        return admins;
    }

    public AdminsFactory getAdminsFactory() {
        return adminsFactory;
    }
}
