import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;

/**
 * Classe per salvare e caricare le configurazioni di gioco tramite file
 */
class ConfigHandler {
    /**
     * Handle utilizzato per leggere e scrivere su file
     */
    private File config;

    /**
     * Salva e legge sul file config.txt di default
     */
    ConfigHandler() {
        config = new File("config.txt");
    }

    /**
     * Legge la configurazione del gioco presente nel file selezionato durante la
     * costruzione
     * 
     * @return Configurazione del gioco letta, il riferimento e' nullo se ci sono
     *         stati errori
     */
    public GameConfig readConfigs() {
        if (!config.isFile()){   // Se il file di config non esiste
            this.writeConfigs(new GameConfig());    // Creane uno di default
            return new GameConfig();    // Non serve leggere di nuovo dal file
        }
        try {
            Scanner reader = new Scanner(config);   // Apri uno scanner sul file
            int length = reader.nextInt();  // Leggi 3 interi ed un booleano
            int attempts = reader.nextInt();
            int colors = reader.nextInt();
            boolean is_repeated = reader.nextBoolean();
            reader.close(); // Chiudiamo lo scanner
            return new GameConfig(length, attempts, colors, is_repeated);
        } catch (Exception ex) {    // In caso di errori nella lettura
            ex.printStackTrace();   // Scriviamo cosa è successo
            return null;    // Restituendo null garantiamo il crash dell'applicazione
        }
    }


    /**
     * Scrive la configurazione del gioco sul file selezionato durante la
     * costruzione
     * 
     * @param data Configurazione da scrivere
     * @return `true` se il file e' stato sovrascritto con successo con la
     *         configurazione da salvare, altrimenti `false`
     */
    public boolean writeConfigs(GameConfig data) {
        try {   // Se tutto va bene
            Writer w = new OutputStreamWriter(new FileOutputStream(config));    // Apre un writer per scrivere su file
            w.write(data.toString());   // Scriviamo sul file la formattazione data dalle configurazioni di gioco
            w.close();  // Chiudiamo il file
        } catch (Exception ex) {    // Nel caso c'è stato un errore nel gestire i file
            ex.printStackTrace();   // Scriviamo cosa è successo
            return false;  
        }
        return true;
    }
}