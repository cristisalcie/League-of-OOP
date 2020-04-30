package main;

import terrain.AbstractTerrain;

import java.util.List;

/**
 * This class is a singleton class because there is no reason to be able to
 * create multiple instances of it.
 */
public final class GameInput {

    private final List<List<AbstractTerrain>> map;
    private final List<String> players;
    private final List<List<Character>> movements;
    private final String outputPath;
    private static GameInput gameInput = null;
    private final List<Integer> numOfAngels;
    private final List<String> angels;

    private GameInput(final List<List<AbstractTerrain>> pMap,
                      final List<String> pPlayers,
                      final List<List<Character>> pMovements,
                      final String pOutputPath,
                      final List<Integer> pNumOfAngels,
                      final List<String> pAngels) {
        map = pMap;
        players = pPlayers;
        movements = pMovements;
        outputPath = pOutputPath;
        numOfAngels = pNumOfAngels;
        angels = pAngels;
    }

    public static GameInput getInstance(final List<List<AbstractTerrain>> map,
                                        final List<String> players,
                                        final List<List<Character>> movements,
                                        final String outputPath,
                                        final List<Integer> numOfAngels,
                                        final List<String> angels) {
        if (gameInput == null) {
            gameInput = new GameInput(
                    map, players, movements, outputPath, numOfAngels, angels);
        }
        return gameInput;
    }

    public List<List<AbstractTerrain>> getMap() {
        return map;
    }
    public List<String> getPlayersData() {
        return players;
    }
    public List<List<Character>> getMovements() {
        return movements;
    }
    public String getOutputPath() {
        return outputPath;
    }
    public List<Integer> getNumOfAngels() {
        return numOfAngels;
    }
    public List<String> getAngelsData() {
        return angels;
    }

    public boolean isValidInput() {
        boolean membersInstantiated = map != null && players != null
                && movements != null && numOfAngels != null && angels != null;
        boolean membersNotEmpty = false;
        if (membersInstantiated) {
            membersNotEmpty = map.size() > 0 && players.size() > 0
                    && movements.size() > 0 && numOfAngels.size() > 0
                    && angels.size() > 0;
        }
        return membersInstantiated && membersNotEmpty;
    }
}
