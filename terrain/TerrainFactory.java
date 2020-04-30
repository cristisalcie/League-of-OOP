package terrain;

public final class TerrainFactory {

    private static TerrainFactory terrainFactory = null;

    private TerrainFactory() {
        // It's singleton.
    }

    public AbstractTerrain getTerrain(final char type) {
        if (type == 'L') {
            return new Land();
        }
        if (type == 'V') {
            return new Volcanic();
        }
        if (type == 'D') {
            return new Desert();
        }
        if (type == 'W') {
            return new Woods();
        }
        return null;
    }

    public static TerrainFactory getInstance() {
        if (terrainFactory == null) {
            terrainFactory = new TerrainFactory();
        }
        return terrainFactory;
    }
}
