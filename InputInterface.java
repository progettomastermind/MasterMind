import java.util.Scanner;

/**
 * Classe che gestisce l'input dall'utente.
 */
class InputInterface {
    // Questa variabile deve essere statica perchè chiudere la chiusura dello scanner causa anche la chiusura dello stream al suo interno.
    // Questo significa che non puoi chiuderlo due volte nel caso di stdin altrimenti causerebbe un'eccezione NoSuchElementException
    private static Scanner keyboard = new Scanner(System.in);

    /**
     * Legge colori dall'input
     * @param amount    Quantita' di colori da leggere
     * @return  Un'array di `amount` colori letti 
     */
    public static int[] readColors(int amount) {
        int[] colors = new int[amount];
        for (int i = 0; i < amount; i++)
            colors[i] = keyboard.nextInt();
        return colors;
    }
    /**
     * Legge configurazioni di gioco dall'utente
     * @return  Configurazioni di gioco lette
     */
    public static GameConfig readUserConfigs(){
        System.out.println("Quanti slot vuoi che vengano usati?");
        int length = keyboard.nextInt();
        
        System.out.println("Quanti tentativi disponibili vuoi?");
        int attempts = keyboard.nextInt();
        
        System.out.println("Quanti colori diversi possono esserci?");
        int colors = keyboard.nextInt();
        
        System.out.println("I colori possono essere ripetuti nella sequenza segreta? (true / false)");
        boolean can_repeat_colors = keyboard.nextBoolean();

        if(!can_repeat_colors && length > colors){
            System.out.println("Queste configurazioni non sono possibili!");
            System.out.println("Hai a disposizione troppi pochi colori per non fare ripetizioni.");
            System.out.println("Verranno scelte le configurazioni di default.");
            return new GameConfig();
        }
        return new GameConfig(length, attempts, colors, can_repeat_colors);
    }
}