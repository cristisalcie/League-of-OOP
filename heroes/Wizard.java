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

public final class Wizard extends AbstractHero {

    public Wizard(final int posX, final int posY, final int id) {
        super();
        setPosX(posX);
        setPosY(posY);
        setId(id);
        setHp(Constants.WIZARDHP); // This is the startup hp at lvl 0.
        setFullHp(getHp());
        addSkills();
    }

    @Override
    public void addSkills() {
        getSkills().add(getSkillFactory().getSkill(SkillType.Drain));
        getSkills().add(getSkillFactory().getSkill(SkillType.Deflect));
    }

    @Override
    public void healHpAtLvlUp() {
        setHp(Constants.WIZARDHP + Constants.EXTRAWIZARDHPLVL * getLevel());
        setFullHp(getHp());
    }

    @Override
    public void updateDmgAtLvlUp(final AbstractSkill skill) {
            skill.updateDmg(getLevel());
    }

    @Override
    public void chooseStrategy() {
        if (Constants.WIZARDOFFENSIVEMINNUMMODIF * getFullHp()
                / Constants.WIZARDOFFENSIVEMINDENOMMODIF < getHp()
                && getHp() < Constants.WIZARDOFFENSIVEMAXNUMMODIF
                * getFullHp() / Constants.WIZARDOFFENSIVEMAXDENOMMODIF) {
            useStrategy(getStrategyFactory().getStrategy(
                    StrategyType.WizardOffensive));
        } else if (getHp() < Constants.WIZARDDEFENSIVENUMMODIF
                * getFullHp() / Constants.WIZARDDEFENSIVEDENOMMODIF) {
            useStrategy(getStrategyFactory().getStrategy(
                    StrategyType.WizardDefensive));
        }

        // Else, will play normally
    }

    @Override
    public void affect(final Execute execute) {
        execute.setDmg(execute.getDmg() * execute.getVsWizardModif());
    }
    @Override
    public void affect(final Slam slam) {
        slam.setDmg(slam.getDmg() * slam.getVsWizardModif());
    }
    @Override
    public void affect(final Fireblast fireblast) {
        fireblast.setDmg(fireblast.getDmg() * fireblast.getVsWizardModif());
    }
    @Override
    public void affect(final Ignite ignite) {
        ignite.setDmg(ignite.getDmg() * ignite.getVsWizardModif());
        ignite.setAoTDmg(ignite.getAoTDmg() * ignite.getVsWizardModif());
    }
    @Override
    public void affect(final Backstab backstab) {
        backstab.setDmg(backstab.getDmg() * backstab.getVsWizardModif());
    }
    @Override
    public void affect(final Paralysis paralysis) {
        paralysis.setDmg(paralysis.getDmg() * paralysis.getVsWizardModif());
        paralysis.setAoTDmg(paralysis.getAoTDmg()
                * paralysis.getVsWizardModif());
    }
    @Override
    public void affect(final Drain drain) {
        drain.setDmg(drain.getDmg() * drain.getVsWizardModif());
    }
    @Override
    public void affect(final Deflect deflect) {
        // Deflect vs Wizard will never change modifier.
        deflect.setDmg(deflect.getDmg() * Constants.DEFLECTVSWIZARDMODIF);
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
        return "Wizard";
    }
}
