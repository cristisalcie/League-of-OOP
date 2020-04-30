package heroes;

import abilities.AbstractSkill;
import abilities.SkillFactory;
import abilities.Execute;
import abilities.Slam;
import abilities.Fireblast;
import abilities.Ignite;
import abilities.Backstab;
import abilities.Paralysis;
import abilities.Drain;
import abilities.Deflect;
import angels.AbstractAngel;
import common.Utilities;
import strategies.Strategy;
import strategies.StrategyFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHero implements HeroSubject {

    private Utilities utl;
    private StrategyFactory strategyFactory;
    private SkillFactory skillFactory;

    private int id;
    private int hp;
    private int fullHp;
    private int xp;
    private int level;

    private int posX;
    private int posY;

    private boolean fought;
    private boolean dead;
    private boolean beResurrected;
    private boolean damagedByAngel;
    private boolean leveledUp;
    /**
     *  Decided to make affectedByAoT an int so it can store the amount of
     *  rounds that he is affected by DoT for.*/
    private int affectedByAoT;
    private float aoTDmgToApply;
    private boolean rooted;

    private List<AbstractSkill> skills;

    private AbstractHero killer;
    private AbstractHero lastHitBy;
    private AbstractAngel spawner;

    public AbstractHero() {
        utl = Utilities.getInstance();
        strategyFactory = StrategyFactory.getInstance();
        skillFactory = SkillFactory.getInstance();
        setSkills(new ArrayList<>());
        setXp(0);
        setLevel(0);
        setFought(false);
        setDead(false);
        setAffectedByAoTRounds(0);
        setAoTDmgToApply(0);
        setRooted(false);
        setKiller(null);
        setLastHitBy(null);
        setSpawner(null);
        setBeResurrected(false);
        setDamagedByAngel(false);
        setLeveledUp(false);
    }

    /**
     * @param action - The move to perform.
     */
    public void move(final char action) {
        if (action == 'U') {
            setPosX(--posX);
        }
        if (action == 'D') {
            setPosX(++posX);
        }
        if (action == 'L') {
            setPosY(--posY);
        }
        if (action == 'R') {
            setPosY(++posY);
        }
        // Else does nothing (including _ action).
    }

    @Override
    public final void checkForDeath() {
        if (isDead() && isDamagedByAngel()) {
            getUtl().getOutput().add("Player " + getName() + " " + getId()
                    + " was killed by an angel\n");
        }
        if (isDead() && !isDamagedByAngel() &&  getKiller() != null) {
            getUtl().getOutput().add("Player " + getName() + " " + getId()
                    + " was killed by " + getKiller().getName() + " "
                    + getKiller().getId() + "\n");
            setKiller(null);
        }
        setDamagedByAngel(false);
    }
    @Override
    public final void checkForResurrected() {
        if (mustBeResurrected()) {
            getUtl().getOutput().add("Player " + getName() + " " + getId()
                    + " was brought to life by an angel\n");
            setBeResurrected(false);
        }
    }
    @Override
    public final void checkForLevelUp() {
        if (hasLeveledUp()) {
            getUtl().getOutput().add(getName() + " " + getId()
                    + " reached level " + getLevel() + "\n");
            setLeveledUp(false);
        }
    }

    public final void useStrategy(final Strategy strategy) {
        strategy.use(this);
    }


    public final List<AbstractSkill> getSkills() {
        return skills;
    }
    public final void setSkills(final List<AbstractSkill> pSkills) {
        skills = pSkills;
    }

    public final AbstractHero getKiller() {
        return killer;
    }
    public final void setKiller(final AbstractHero pKiller) {
        killer = pKiller;
        getUtl().notifyAdmins(this);
    }

    /**
     * Exists for future changes.
     * @return - last hero that hit this hero.
     */
    public final AbstractHero getLastHitBy() {
        return lastHitBy;
    }
    public final void setLastHitBy(final AbstractHero pLastHitBy) {
        lastHitBy = pLastHitBy;
    }

    public final AbstractAngel getSpawner() {
        return spawner;
    }
    public final void setSpawner(final AbstractAngel pSpawner) {
        spawner = pSpawner;
    }

    public final boolean isRooted() {
        return rooted;
    }
    public final void setRooted(final boolean pRooted) {
        rooted = pRooted;
    }

    public final float getAoTDmgToApply() {
        return aoTDmgToApply;
    }
    public final void setAoTDmgToApply(final float pAoTDmg) {
        aoTDmgToApply = pAoTDmg;
    }

    public final boolean isAffectedByAoT() {
        return getAffectedByAoTRounds() > 0;
    }
    public final int getAffectedByAoTRounds() {
        return affectedByAoT;
    }
    public final void setAffectedByAoTRounds(final int pAffectedByAoT) {
        affectedByAoT = pAffectedByAoT;
        if (getAffectedByAoTRounds() <= 0) {
            setRooted(false);
        }
    }

    public final boolean hasLeveledUp() {
        return leveledUp;
    }
    public final void setLeveledUp(final boolean pLeveledUp) {
        leveledUp = pLeveledUp;
    }

    public final boolean isDamagedByAngel() {
        return damagedByAngel;
    }
    public final void setDamagedByAngel(final boolean pDamagedByAngel) {
        damagedByAngel = pDamagedByAngel;
    }

    public final boolean mustBeResurrected() {
        return beResurrected;
    }
    public final void setBeResurrected(final boolean pResurrected) {
        beResurrected = pResurrected;
        /* No need to notify admins because when he is being resurrected,
        * setHp() method will be used and through it, admins will get
        * notification. */
    }

    public final boolean isDead() {
        return dead;
    }
    public final void setDead(final boolean pDead) {
        dead = pDead;
        getUtl().notifyAdmins(this);
    }

    public final boolean hasFought() {
        return fought;
    }
    public final void setFought(final boolean pFought) {
        fought = pFought;
    }

    public final int getPosX() {
        return posX;
    }
    public final void setPosX(final int pPosX) {
        posX = pPosX;
    }

    public final int getPosY() {
        return posY;
    }
    public final void setPosY(final int pPosY) {
        posY = pPosY;
    }

    public final int getLevel() {
        return level;
    }
    public final void setLevel(final int pLevel) {
        level = pLevel;
    }

    public final int getXp() {
        return xp;
    }
    public final void setXp(final int pXp) {
        xp = pXp;
    }

    public final int getFullHp() {
        return fullHp;
    }
    public final void setFullHp(final int pFullHp) {
        fullHp = pFullHp;
    }

    public final int getHp() {
        return hp;
    }
    public final void setHp(final int pHp) {
        hp = pHp;
        getUtl().notifyAdmins(this);
    }

    public final int getId() {
        return id;
    }
    public final void setId(final int pId) {
        id = pId;
    }

    public final SkillFactory getSkillFactory() {
        return skillFactory;
    }
    public final StrategyFactory getStrategyFactory() {
        return strategyFactory;
    }
    public final Utilities getUtl() {
        return utl;
    }

    public abstract void addSkills();
    public abstract void healHpAtLvlUp();
    public abstract void updateDmgAtLvlUp(AbstractSkill skill);
    public abstract void chooseStrategy();

    public abstract void affect(Execute execute);
    public abstract void affect(Slam slam);

    public abstract void affect(Fireblast fireblast);
    public abstract void affect(Ignite ignite);

    public abstract void affect(Backstab backstab);
    public abstract void affect(Paralysis paralysis);

    public abstract void affect(Drain drain);
    public abstract void affect(Deflect deflect);

    public abstract void getAffectedBy(AbstractAngel angel);

    public abstract String getName();
}
