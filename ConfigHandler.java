import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;

/**
 * Classe per salvare e caricare le configurazioni di gioco tramite file
 */
class ConfigHandler{
    /**
     * Handle utilizzato per leggere e scrivere su file
     */
    private File config;
    
    /**
     * Salva e legge sul file config.txt di default
     */
    ConfigHandler(){
        config = new File("config.txt");
    }

    /**
     * Legge la configurazione del gioco presente nel file selezionato durante la costruzione
     * @return Configurazione del gioco letta, il riferimento è nullo se ci sono stati errori
     */
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
    
    /**
     * Scrive la configurazione del gioco sul file selezionato durante la costruzione
     * @param data Configurazione da scrivere
     * @return `true` se il file è stato sovrascritto con successo con la configurazione da salvare, altrimenti `false`
     */
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