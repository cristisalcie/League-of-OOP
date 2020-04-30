package main;

import java.util.ArrayList;
import java.util.List;
import common.Constants;
import terrain.AbstractTerrain;
import terrain.TerrainFactory;
import fileio.FileSystem;

/**
 * This class is a singleton class because there is no reason to be able to
 * create multiple instances of it.
 */
public final class GameInputLoader {

    private final String inputPath;
    private final String outputPath;
    private static GameInputLoader gameInputLoader = null;
    private List<String> angels;

    private GameInputLoader(final String pInputPath, final String pOutputPath) {
        inputPath = pInputPath;
        outputPath = pOutputPath;
        angels = new ArrayList<>();
    }

    public static GameInputLoader getInstance(final String inputPath,
                                              final String outputPath) {
        if (gameInputLoader == null) {
            gameInputLoader = new GameInputLoader(inputPath, outputPath);
        }
        return gameInputLoader;
    }

    public GameInput load() {

        int n = 0;
        int m = 0;
        List<List<AbstractTerrain>> map = new ArrayList<>();
        int noPlayers = 1;
        List<String> players = new ArrayList<>();
        int rounds = 0;
        List<List<Character>> movements = new ArrayList<>();
        List<Integer> numOfAngels = new ArrayList<>();

        try {
            FileSystem fs = new FileSystem(getInputPath(), getOutputPath());

            n = fs.nextInt(); // map lines
            m = fs.nextInt(); // map columns

            TerrainFactory terrainFactory = TerrainFactory.getInstance();

            for (int i = 0; i < n; i++) {
                String tmpStr = fs.nextWord();
                List<AbstractTerrain> tmpTerrain = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    tmpTerrain.add(terrainFactory.getTerrain(
                            tmpStr.toCharArray()[j]));
                }
                map.add(tmpTerrain);
            }

            noPlayers = fs.nextInt();
            for (int i = 0; i < noPlayers; i++) {
                for (int j = 0; j <= Constants.MAPDIMENSION; j++) {
                    players.add(fs.nextWord());
                }
            }

            rounds = fs.nextInt();

            for (int i = 0; i < rounds; i++) {
                String tmpStr = fs.nextWord();
                List<Character> tmpList = new ArrayList<>();
                for (int j = 0; j < noPlayers; j++) {
                    char tmpChar = tmpStr.toCharArray()[j];
                    tmpList.add(tmpChar);
                }
                movements.add(tmpList);
            }

            for (int i = 0; i < rounds; i++) {
                numOfAngels.add(fs.nextInt());
                for (int j = 0; j < numOfAngels.get(i); j++) {
                    String tmpAngelData = fs.nextWord();
                    getAngelData(tmpAngelData);
                }
            }
            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return GameInput.getInstance(map, players, movements, getOutputPath(),
                numOfAngels, angels);
    }

    /**
     * Recursive function to fill angels data in a string list in the following
     * way: (angelType posX posY)
     * I choose to do it this way because if we would get more input for an
     * angel separated by ',' i won't have to rewrite this portion of code.
     * @param tmpAngelData - has angel data from file in a single String the
     *                     following way: (angelType,posX,posY)
     */
    public void getAngelData(final String tmpAngelData) {
        StringBuilder newTmpAngelData = new StringBuilder(tmpAngelData);
        StringBuilder angelData = new StringBuilder();
        for (int i = 0; i < tmpAngelData.length(); i++) {
            newTmpAngelData.deleteCharAt(0);
            if (tmpAngelData.toCharArray()[i] == ',') {
                angels.add(angelData.toString());
                getAngelData(newTmpAngelData.toString());
                break;
            }
            angelData.append(tmpAngelData.toCharArray()[i]);
            if (i == tmpAngelData.length() - 1) {
                /* If we got to the last angel data, we know it's not followed
                * by ','. Hence we created this if block. */
                angels.add(angelData.toString());
            }
        }
    }

    public String getInputPath() {
        return inputPath;
    }
    public String getOutputPath() {
        return outputPath;
    }
}
