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

public final class Pyromancer extends AbstractHero {

    public Pyromancer(final int posX, final int posY, final int id) {
        super();
        setPosX(posX);
        setPosY(posY);
        setId(id);
        setHp(Constants.PYROMANCERHP); // This is the startup hp at lvl 0.
        setFullHp(getHp());
        addSkills();
    }

    @Override
    public void addSkills() {
        getSkills().add(getSkillFactory().getSkill(SkillType.Fireblast));
        getSkills().add(getSkillFactory().getSkill(SkillType.Ignite));
    }

    @Override
    public void healHpAtLvlUp() {
        setHp(Constants.PYROMANCERHP
                + Constants.EXTRAPYROMANCERHPLVL * getLevel());
        setFullHp(getHp());
    }

    @Override
    public void updateDmgAtLvlUp(final AbstractSkill skill) {
            skill.updateDmg(getLevel());
    }

    @Override
    public void chooseStrategy() {
        if (Constants.PYROOFFENSIVEMINNUMMODIF * getFullHp()
                / Constants.PYROOFFENSIVEMINDENOMMODIF < getHp()
                && getHp() < Constants.PYROOFFENSIVEMAXNUMMODIF
                * getFullHp() / Constants.PYROOFFENSIVEMAXDENOMMODIF) {
            useStrategy(getStrategyFactory().getStrategy(
                    StrategyType.PyromancerOffensive));
        } else if (getHp() < Constants.PYRODEFENSIVENUMMODIF
                * getFullHp() / Constants.PYRODEFENSIVEDENOMMODIF) {
            useStrategy(getStrategyFactory().getStrategy(
                    StrategyType.PyromancerDefensive));
        }

        // Else, will play normally
    }

    @Override
    public void affect(final Execute execute) {
        execute.setDmg(execute.getDmg() * execute.getVsPyromancerModif());
    }
    @Override
    public void affect(final Slam slam) {
        slam.setDmg(slam.getDmg() * slam.getVsPyromancerModif());
    }
    @Override
    public void affect(final Fireblast fireblast) {
        fireblast.setDmg(fireblast.getDmg() * fireblast.getVsPyromancerModif());
    }
    @Override
    public void affect(final Ignite ignite) {
        ignite.setDmg(ignite.getDmg() * ignite.getVsPyromancerModif());
        ignite.setAoTDmg(ignite.getAoTDmg() * ignite.getVsPyromancerModif());
    }
    @Override
    public void affect(final Backstab backstab) {
        backstab.setDmg(backstab.getDmg() * backstab.getVsPyromancerModif());
    }
    @Override
    public void affect(final Paralysis paralysis) {
        paralysis.setDmg(paralysis.getDmg()
                * paralysis.getVsPyromancerModif());
        paralysis.setAoTDmg(paralysis.getAoTDmg()
                * paralysis.getVsPyromancerModif());
    }
    @Override
    public void affect(final Drain drain) {
        drain.setDmg(drain.getDmg() * drain.getVsPyromancerModif());
    }
    @Override
    public void affect(final Deflect deflect) {
        deflect.setDmg(deflect.getDmg() * deflect.getVsPyromancerModif());
    }

    @Override
    public void getAffectedBy(final AbstractAngel angel) {
        angel.setAffectedHero(this);
        angel.affect(this);
        // In case he dies from an angel.
        getUtl().checkStatus(this);
    }

    @Override
    public String getName() {
        return "Pyromancer";
    }
}
