package abilities;

public final class SkillFactory {

    private static SkillFactory skillFactory = null;

    private SkillFactory() {
        // It's singleton.
    }

    public static SkillFactory getInstance() {
        if (skillFactory == null) {
            skillFactory = new SkillFactory();
        }
        return skillFactory;
    }

    public AbstractSkill getSkill(final SkillType type) {
        if (type == null) {
            return null;
        }
        if (type.equals(SkillType.Execute)) {
            return new Execute();
        }
        if (type.equals(SkillType.Slam)) {
            return new Slam();
        }
        if (type.equals(SkillType.Fireblast)) {
            return new Fireblast();
        }
        if (type.equals(SkillType.Ignite)) {
            return new Ignite();
        }
        if (type.equals(SkillType.Backstab)) {
            return new Backstab();
        }
        if (type.equals(SkillType.Paralysis)) {
            return new Paralysis();
        }
        if (type.equals(SkillType.Drain)) {
            return new Drain();
        }
        if (type.equals(SkillType.Deflect)) {
            return new Deflect();
        }
        return null;
    }
}
