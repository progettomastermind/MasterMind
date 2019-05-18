import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;

class ConfigHandler{
    private File config;
    ConfigHandler(){
        config = new File("config.txt");
    }

    public GameConfig readConfigs(){
        try{
            Scanner reader = new Scanner(config);
            int length = reader.nextInt();
            int attempts = reader.nextInt();
            int colors = reader.nextInt();
            reader.close();
            return new GameConfig(length, attempts, colors);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public boolean writeConfigs(GameConfig data){
        if (!config.canWrite()) return false;
        try{
            Writer w = new OutputStreamWriter(new FileOutputStream(config));
            w.write(data.toString());
            w.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}