package angels;

public final class AngelsFactory {
    private static AngelsFactory angelsFactory = null;

    private AngelsFactory() {
        // It's singleton.
    }

    public static AngelsFactory getInstance() {
        if (angelsFactory == null) {
            angelsFactory = new AngelsFactory();
        }
        return angelsFactory;
    }

    public AbstractAngel getAngel(final String type,
                                  final int posX, final int posY) {
        if (type == null) {
            return null;
        }
        if (type.equals("DamageAngel")) {
            return new DamageAngel(posX, posY);
        }
        if (type.equals("DarkAngel")) {
            return new DarkAngel(posX, posY);
        }
        if (type.equals("Dracula")) {
            return new Dracula(posX, posY);
        }
        if (type.equals("GoodBoy")) {
            return new GoodBoy(posX, posY);
        }
        if (type.equals("LevelUpAngel")) {
            return new LevelUpAngel(posX, posY);
        }
        if (type.equals("LifeGiver")) {
            return new LifeGiver(posX, posY);
        }
        if (type.equals("SmallAngel")) {
            return new SmallAngel(posX, posY);
        }
        if (type.equals("Spawner")) {
            return new Spawner(posX, posY);
        }
        if (type.equals("TheDoomer")) {
            return new TheDoomer(posX, posY);
        }
        if (type.equals("XPAngel")) {
            return new XPAngel(posX, posY);
        }
        return null;
    }
}
