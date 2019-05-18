import java.util.Scanner;
import java.io.File;

class ConfigHandler{
    private File config;
    ConfigHandler(){
        config = new File("config.txt");
    }

    public GameConfig ReadConfigs(){
        Scanner reader = new Scanner(config);
        int length = reader.nextInt();
        int attempts = reader.nextInt();
        int colors = reader.nextInt();
        reader.close();
        return new GameConfig(length, attempts, colors);
    }
}