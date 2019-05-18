/**
 * Classe che contiene i parametri del gioco
*/
class GameConfig{
    /**
     * Lunghezza sequenza
     */
    public int length;

    /**
     * Tentativi disponibili
     */
    public int attempts;

    /**
     * Quantità di colori utilizzabili
     */
    public int colors;

    /**
     * Crea una configurazione con i parametri forniti
     * @param length 
     * @param attempts
     * @param colors
     */
    GameConfig(int length, int attempts, int colors){
        this.length = length;
        this.attempts = attempts;
        this.colors = colors;
    }

    /**
     *  Fornisce l'interpretazione della configurazione da salvare e leggere su file
     */
    @Override
    public String toString(){
        String n = new String();
        return n + length + "\n" + attempts + "\n" + colors;
    }
}