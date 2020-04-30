package main;

import java.util.List;
import fileio.implementations.FileWriter;

/**
 * This class is a singleton class because there is no reason to be able to
 * create multiple instances of it.
 */
public final class GameFileWriter {

    private final String outputPath;
    private static GameFileWriter gameFileWriter = null;

    private GameFileWriter(final String pOutputPath) {
        outputPath = pOutputPath;
    }

    public static GameFileWriter getInstance(final String outputPath) {
        if (gameFileWriter == null) {
            gameFileWriter = new GameFileWriter(outputPath);
        }
        return gameFileWriter;
    }

    public void write(final List<String> output) {
        try {
            FileWriter fileSystem = new FileWriter(getOutputPath());
            for (int i = 0; i < output.size(); i++) {
                fileSystem.writeWord(output.get(i));
            }
            fileSystem.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getOutputPath() {
        return outputPath;
    }
}
