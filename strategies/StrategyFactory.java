package strategies;

public final class StrategyFactory {

    private static StrategyFactory strategyFactory = null;

    private StrategyFactory() {
        // It's singleton.
    }

    public static StrategyFactory getInstance() {
        if (strategyFactory == null) {
            strategyFactory = new StrategyFactory();
        }
        return strategyFactory;
    }

    public Strategy getStrategy(final StrategyType type) {
        if (type == null) {
            return null;
        }
        if (type.equals(StrategyType.KnightDefensive)) {
            return new KnightDefensive();
        }
        if (type.equals(StrategyType.KnightOffensive)) {
            return new KnightOffensive();
        }
        if (type.equals(StrategyType.PyromancerDefensive)) {
            return new PyromancerDefensive();
        }
        if (type.equals(StrategyType.PyromancerOffensive)) {
            return new PyromancerOffensive();
        }
        if (type.equals(StrategyType.RogueDefensive)) {
            return new RogueDefensive();
        }
        if (type.equals(StrategyType.RogueOffensive)) {
            return new RogueOffensive();
        }
        if (type.equals(StrategyType.WizardDefensive)) {
            return new WizardDefensive();
        }
        if (type.equals(StrategyType.WizardOffensive)) {
            return new WizardOffensive();
        }
        return null;
    }
}
