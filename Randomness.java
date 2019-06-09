import java.util.Random;

public class Randomness {
    /**
     * Crea un array casuale (con possibili ripetizioni) di colori
     * 
     * @param length       Lunghezza array
     * @param color_amount Quantità di colori diversi
     * @return Array di colori casuale
     */
    public static int[] getRandomSequence(int length, int color_amount) {
        Random random = new Random();
        int[] seq = new int[length];
        for (int i = 0; i < length; i++) {
            seq[i] = random.nextInt(color_amount); // Per ogni elemento dell'array viene generato un numero casuale da 0
                                                   // a `color_amount` escluso
        }
        return seq;
    }

    /**
     * Crea un array mescolata (senza ripetizioni) lunga `color_amount`
     * 
     * @param color_amount
     * @return Array di colori mescolati
     */
    public static int[] getShuffledSequence(int color_amount) {
        Random random = new Random();
        int[] rainbow = new int[color_amount];
        int c;
        int tmp;

        for (int i = 0; i < color_amount; i++) // Viene riempita un array di colori in ordine
            rainbow[i] = i;

        for (int i = rainbow.length - 1; i >= 0; i--) {
            c = random.nextInt(color_amount--); // Viene generato un indice casuale con intervallo decrescente verso la
                                                // fine
            tmp = rainbow[i];
            rainbow[i] = rainbow[c]; // Scambiamo l'elemento che stiamo scorrendo con l'elemento casuale trovato
            rainbow[c] = tmp; // L'algoritmo è O(N) con N numero di elementi da mescolare
        }
        return rainbow;
    }
}
