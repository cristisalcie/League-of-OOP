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

public final class Rogue extends AbstractHero {

    public Rogue(final int posX, final int posY, final int id) {
        super();
        setPosX(posX);
        setPosY(posY);
        setId(id);
        setHp(Constants.ROGUEHP); // This is the startup hp at lvl 0.
        setFullHp(getHp());
        addSkills();
    }

    @Override
    public void addSkills() {
        getSkills().add(getSkillFactory().getSkill(SkillType.Backstab));
        getSkills().add(getSkillFactory().getSkill(SkillType.Paralysis));
    }

    @Override
    public void healHpAtLvlUp() {
        setHp(Constants.ROGUEHP + Constants.EXTRAROGUEHPLVL * getLevel());
        setFullHp(getHp());
    }

    @Override
    public void updateDmgAtLvlUp(final AbstractSkill skill) {
            skill.updateDmg(getLevel());
    }

    @Override
    public void chooseStrategy() {
        if (Constants.ROGUEOFFENSIVEMINNUMMODIF * getFullHp()
                / Constants.ROGUEOFFENSIVEMINDENOMMODIF < getHp()
                && getHp() < Constants.ROGUEOFFENSIVEMAXNUMMODIF
                * getFullHp() / Constants.ROGUEOFFENSIVEMAXDENOMMODIF) {
            useStrategy(getStrategyFactory().getStrategy(
                    StrategyType.RogueOffensive));
        } else if (getHp() < Constants.ROGUEDEFENSIVENUMMODIF
                * getFullHp() / Constants.ROGUEDEFENSIVEDENOMMODIF) {
            useStrategy(getStrategyFactory().getStrategy(
                    StrategyType.RogueDefensive));
        }

        // Else, will play normally
    }

    @Override
    public void affect(final Execute execute) {
        execute.setDmg(execute.getDmg() * execute.getVsRogueModif());
    }
    @Override
    public void affect(final Slam slam) {
        slam.setDmg(slam.getDmg() * slam.getVsRogueModif());
    }
    @Override
    public void affect(final Fireblast fireblast) {
        fireblast.setDmg(fireblast.getDmg() * fireblast.getVsRogueModif());
    }
    @Override
    public void affect(final Ignite ignite) {
        ignite.setDmg(ignite.getDmg() * ignite.getVsRogueModif());
        ignite.setAoTDmg(ignite.getAoTDmg() * ignite.getVsRogueModif());
    }
    @Override
    public void affect(final Backstab backstab) {
        backstab.setDmg(backstab.getDmg() * backstab.getVsRogueModif());
    }
    @Override
    public void affect(final Paralysis paralysis) {
        paralysis.setDmg(paralysis.getDmg() * paralysis.getVsRogueModif());
        paralysis.setAoTDmg(paralysis.getAoTDmg()
                * paralysis.getVsRogueModif());
    }
    @Override
    public void affect(final Drain drain) {
        drain.setDmg(drain.getDmg() * drain.getVsRogueModif());
    }
    @Override
    public void affect(final Deflect deflect) {
        deflect.setDmg(deflect.getDmg() * deflect.getVsRogueModif());
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
        return "Rogue";
    }
}
