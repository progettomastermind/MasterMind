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
    public boolean can_repeat_colors;
    /**
     * Crea la configurazione di default
     */
    GameConfig(){
        this.length = 4;
        this.attempts = 10;
        this.colors = 8;
        this.can_repeat_colors = false;
    }

    /**
     * Crea una configurazione con i parametri forniti
     * 
     * @param length
     * @param attempts
     * @param colors
     * @param can_repeat_colors
     */
    GameConfig(int length, int attempts, int colors, boolean can_repeat_colors) {
        this.length = length;
        this.attempts = attempts;
        this.colors = colors;
        this.can_repeat_colors = can_repeat_colors;
    }

    /**
     * Fornisce l'interpretazione della configurazione da salvare e leggere su file
     */
    @Override
    public String toString() {
        String n = new String();
        return n + length + "\n" + attempts + "\n" + colors + "\n" + can_repeat_colors + '\n';
    }
}