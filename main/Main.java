package main;

public final class Main {
    private Main() {
        // Just to trick checkstyle.
    }

    /**
     * @author SALCIE IOAN-CRISTIAN 323CD
     * @param args - Must have 2 parameters
     *             args[0] - Contains inputPath
     *             args[1] - Contains outputPath
     */
    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = GameInputLoader.getInstance(
                args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        Game game = new Game(gameInput);
        game.play();
    }
}
