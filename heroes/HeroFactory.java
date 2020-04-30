package heroes;

public final class HeroFactory {

    private static HeroFactory heroFactory = null;

    private HeroFactory() {
        // It's singleton.
    }

    public AbstractHero getHero(final String type,
                                final int posX, final int posY,
                                final int id) {
        if (type == null) {
            return null;
        }
        if (type.equals("K")) {
            return new Knight(posX, posY, id);
        }
        if (type.equals("P")) {
            return new Pyromancer(posX, posY, id);
        }
        if (type.equals("R")) {
            return new Rogue(posX, posY, id);
        }
        if (type.equals("W")) {
            return new Wizard(posX, posY, id);
        }
        return null;
    }

    public static HeroFactory getInstance() {
        if (heroFactory == null) {
            heroFactory = new HeroFactory();
        }
        return heroFactory;
    }
}
