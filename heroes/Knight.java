package heroes;

import abilities.AbstractSkill;
import abilities.SkillType;
import abilities.Execute;
import abilities.Slam;
import abilities.Fireblast;
import abilities.Ignite;
import abilities.Backstab;
import abilities.Paralysis;
import abilities.Drain;
import abilities.Deflect;
import angels.AbstractAngel;
import common.Constants;
import strategies.StrategyType;

public final class Knight extends AbstractHero {

    public Knight(final int posX, final int posY, final int id) {
        super();
        setPosX(posX);
        setPosY(posY);
        setId(id);
        setHp(Constants.KNIGHTHP); // This is the startup hp at lvl 0.
        setFullHp(getHp());
        addSkills();
    }

    @Override
    public void addSkills() {
        getSkills().add(getSkillFactory().getSkill(SkillType.Execute));
        getSkills().add(getSkillFactory().getSkill(SkillType.Slam));
    }

    @Override
    public void healHpAtLvlUp() {
        setHp(Constants.KNIGHTHP + Constants.EXTRAKNIGHTHPLVL * getLevel());
        setFullHp(getHp());
    }

    @Override
    public void updateDmgAtLvlUp(final AbstractSkill skill) {
            skill.updateDmg(getLevel());
    }

    @Override
    public void chooseStrategy() {
        if (Constants.KNIGHTOFFENSIVEMINNUMMODIF * getFullHp()
                / Constants.KNIGHTOFFENSIVEMINDENOMMODIF < getHp()
                && getHp() < Constants.KNIGHTOFFENSIVEMAXNUMMODIF
                * getFullHp() / Constants.KNIGHTOFFENSIVEMAXDENOMMODIF) {
            useStrategy(getStrategyFactory().getStrategy(
                    StrategyType.KnightOffensive));
        } else if (getHp() < Constants.KNIGHTDEFENSIVENUMMODIF
                * getFullHp() / Constants.KNIGHTDEFENSIVEDENOMMODIF) {
            useStrategy(getStrategyFactory().getStrategy(
                    StrategyType.KnightDefensive));
        }

        // Else, will play normally
    }

    @Override
    public void affect(final Execute execute) {
        // Execute vs Knight will never change modifier.
        execute.setDmg(execute.getDmg() * Constants.EXECUTEVSKNIGHTMODIF);
    }
    @Override
    public void affect(final Slam slam) {
        slam.setDmg(slam.getDmg() * slam.getVsKnightModif());
    }
    @Override
    public void affect(final Fireblast fireblast) {
        fireblast.setDmg(fireblast.getDmg() * fireblast.getVsKnightModif());
    }
    @Override
    public void affect(final Ignite ignite) {
        ignite.setDmg(ignite.getDmg() * ignite.getVsKnightModif());
        ignite.setAoTDmg(ignite.getAoTDmg() * ignite.getVsKnightModif());
    }
    @Override
    public void affect(final Backstab backstab) {
        backstab.setDmg(backstab.getDmg() * backstab.getVsKnightModif());
    }
    @Override
    public void affect(final Paralysis paralysis) {
        paralysis.setDmg(paralysis.getDmg() * paralysis.getVsKnightModif());
        paralysis.setAoTDmg(
                paralysis.getAoTDmg() * paralysis.getVsKnightModif());
    }
    @Override
    public void affect(final Drain drain) {
        drain.setDmg(drain.getDmg() * drain.getVsKnightModif());
    }
    @Override
    public void affect(final Deflect deflect) {
        deflect.setDmg(deflect.getDmg() * deflect.getVsKnightModif());
    }

    @Override
    public void getAffectedBy(final AbstractAngel angel) {
        angel.setAffectedHero(this);
        angel.affect(this);
        // In case he dies from an Angel.
        getUtl().checkStatus(this);
    }

    @Override
    public String getName() {
        return "Knight";
    }
}
