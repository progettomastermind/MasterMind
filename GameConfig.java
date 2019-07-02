/**
 * Classe che contiene i parametri del gioco
 */
class GameConfig {
    /**
     * Lunghezza sequenza
     */
    public int length;

    /**
     * Tentativi disponibili
     */
    public int attempts;

    /**
     * Quantita' di colori utilizzabili
     */
    public int colors;

    /**
     * Controlla se i colori sono con ripetizioni o meno
     */
    public boolean is_repeated;
    /**
     * Crea la configurazione di default
     */
    GameConfig(){
        this.length = 4;
        this.attempts = 10;
        this.colors = 8;
        this.is_repeated = false;
    }

    /**
     * Crea una configurazione con i parametri forniti
     * 
     * @param length
     * @param attempts
     * @param colors
     * @param is_repeated
     */
    GameConfig(int length, int attempts, int colors, boolean is_repeated) {
        this.length = length;
        this.attempts = attempts;
        this.colors = colors;
        this.is_repeated = is_repeated;
    }

    /**
     * Fornisce l'interpretazione della configurazione da salvare e leggere su file
     */
    @Override
    public String toString() {
        String n = new String();
        return n + length + "\n" + attempts + "\n" + colors + "\n" + is_repeated + '\n';
    }
}