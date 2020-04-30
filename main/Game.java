package main;

import angels.AbstractAngel;
import angels.AngelsFactory;
import common.Constants;
import common.Utilities;
import heroes.AbstractHero;
import heroes.HeroFactory;
import terrain.AbstractTerrain;
import java.util.ArrayList;
import java.util.List;

public final class Game {

    private GameInput gameInput;
    private GameFileWriter gameFileWriter;
    private Utilities utl;
    private List<AbstractHero> heroes;
    private HeroFactory heroFactory;
    private List<List<AbstractTerrain>> map;
    private List<List<Character>> movements;
    private List<AbstractAngel> angels;
    private AngelsFactory angelsFactory;

    public Game(final GameInput pGameInput) {
        gameInput = pGameInput;
        gameFileWriter = GameFileWriter.getInstance(
                getGameInput().getOutputPath());
        utl = Utilities.getInstance();
        setHeroes(new ArrayList<>());
        setHeroFactory(HeroFactory.getInstance());
        setMap(getGameInput().getMap());
        setMovements(getGameInput().getMovements());
        setAngels(new ArrayList<>());
        setAngelsFactory(AngelsFactory.getInstance());
    }

    public void play() {
        //  We create the heroes and add them to heroes list.
        List<String> playersData = getGameInput().getPlayersData();
        for (int id = 0; id < playersData.size() / Constants.DATAENTITY; id++) {
            getHeroes().add(getHeroFactory().getHero(
                    playersData.get(id * Constants.DATAENTITY),
                    Integer.parseInt(
                            playersData.get(
                                    id * Constants.DATAENTITY
                                            + Constants.INDEXPOSX)),
                    Integer.parseInt(
                            playersData.get(
                                    id * Constants.DATAENTITY
                                            + Constants.INDEXPOSY)),
                    id));
        }
        //  We create the angels and add them to angels list.
        List<Integer> numOfAngels = getGameInput().getNumOfAngels();
        List<String> angelsData = getGameInput().getAngelsData();
        for (int i = 0; i < angelsData.size() / Constants.DATAENTITY; i++) {
            getAngels().add(getAngelsFactory().getAngel(
                    angelsData.get(i * Constants.DATAENTITY),
                    Integer.parseInt(
                            angelsData.get(
                                    i * Constants.DATAENTITY
                                            + Constants.INDEXPOSX)),
                    Integer.parseInt(
                            angelsData.get(
                                    i * Constants.DATAENTITY
                                            + Constants.INDEXPOSY))));
        }

        getUtl().prepareAdmins();

        int angelCounter = 0; // To iterate through all angels only once.
        //  We start the actual game.
        for (int i = 0; i < getMovements().size(); i++) { // For every round.

            getUtl().printRound(i + 1); // We start printing from round 1...

            for (int j = 0; j < getHeroes().size(); j++) {
                /* Apply overtime ability if the case and then hero chooses
                * strategy and moves if he is not rooted. Lastly we decrease
                * the amount of rounds that a hero must be affected by. */
                if (!getHeroes().get(j).isDead()) {
                    if (getHeroes().get(j).isAffectedByAoT()) {
                        getUtl().applyAoT(getHeroes().get(j));
                    }
                    if (!getHeroes().get(j).isRooted()) {
                        getHeroes().get(j).chooseStrategy();
                        getHeroes().get(j).move(getMovements().get(i).get(j));
                    }
                    if (getHeroes().get(j).isAffectedByAoT()) {
                        getHeroes().get(j).setAffectedByAoTRounds(
                                getHeroes().get(j).getAffectedByAoTRounds()
                                        - 1);
                    }
                }
            }

            // Check if there are any players on the same terrain.
            for (int j = 0; j < getHeroes().size(); j++) {
                for (int k = 0; k < getHeroes().size(); k++) {
                    if (k == j) {
                        continue; // So a hero doesn't fight himself.
                    }
                    if ((getHeroes().get(j).getPosX()
                            == getHeroes().get(k).getPosX())
                            && (getHeroes().get(j).getPosY()
                            == getHeroes().get(k).getPosY())) {
                        // If they are both alive, fight.
                        if (!getHeroes().get(j).isDead()
                                && !getHeroes().get(k).isDead()) {
                            getUtl().fight(getHeroes().get(k),
                                    getHeroes().get(j), getMap());
                        }
                    }
                }
            }

            // Selecting the angels that appear on round i
            for (int j = 0; j < numOfAngels.get(i); j++) {
                getUtl().spawnAngel(getAngels().get(angelCounter));
                for (int k = 0; k < getHeroes().size(); k++) {
                    /* Checking if the selected angel and player k are on the
                     * same terrain. */
                    if (getAngels().get(angelCounter).getPosX()
                            == getHeroes().get(k).getPosX()
                            && (getAngels().get(angelCounter).getPosY()
                            == getHeroes().get(k).getPosY())) {
                        getUtl().affectHeroByAngel(
                                getAngels().get(angelCounter),
                                getHeroes().get(k));
                    }
                }
                angelCounter++;
            }

            // When round is complete, everyone can fight again
            for (AbstractHero hero : getHeroes()) {
                hero.setFought(false);
            }
            getUtl().getOutput().add("\n");
        }
        printResults();
    }

    /**
     * Method to print results to both console, and the output file.
     */
    public void printResults() {
        getUtl().getOutput().add("~~ Results ~~\n");
        for (int i = 0; i < getHeroes().size(); i++) {
            if (getHeroes().get(i).isDead()) {
                getUtl().getOutput().add(getHeroes().get(i).getName().
                        toCharArray()[0] + " dead\n");
            } else {
                getUtl().getOutput().add(getHeroes().get(i).getName().
                        toCharArray()[0] + " "
                        + getHeroes().get(i).getLevel() + " "
                        + getHeroes().get(i).getXp() + " "
                        + getHeroes().get(i).getHp() + " "
                        + getHeroes().get(i).getPosX() + " "
                        + getHeroes().get(i).getPosY() + "\n");
            }
        }
        // Write output to given outputPath.
        getGameFileWriter().write(getUtl().getOutput());
        for (int i = 0; i < getUtl().getOutput().size(); i++) {
            // Write output to console as well.
            System.out.print(getUtl().getOutput().get(i));
        }
    }


    public GameInput getGameInput() {
        return gameInput;
    }

    public GameFileWriter getGameFileWriter() {
        return gameFileWriter;
    }

    public Utilities getUtl() {
        return utl;
    }

    public List<AbstractHero> getHeroes() {
        return heroes;
    }

    public void setHeroes(final List<AbstractHero> pHeroes) {
        heroes = pHeroes;
    }

    public HeroFactory getHeroFactory() {
        return heroFactory;
    }
    public void setHeroFactory(final HeroFactory pHeroFactory) {
        heroFactory = pHeroFactory;
    }

    public List<List<AbstractTerrain>> getMap() {
        return map;
    }
    public void setMap(final List<List<AbstractTerrain>> pMap) {
        map = pMap;
    }

    public List<List<Character>> getMovements() {
        return movements;
    }
    public void setMovements(final List<List<Character>> pMovements) {
        movements = pMovements;
    }

    public List<AbstractAngel> getAngels() {
        return angels;
    }
    public void setAngels(final List<AbstractAngel> pAngels) {
        angels = pAngels;
    }

    public AngelsFactory getAngelsFactory() {
        return angelsFactory;
    }
    public void setAngelsFactory(final AngelsFactory pAngelsFactory) {
        angelsFactory = pAngelsFactory;
    }
}
