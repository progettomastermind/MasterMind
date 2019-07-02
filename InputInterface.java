import java.util.Scanner;

class InputInterface {
    // This needs to be static because closing a scanner will also close the input
    // stream
    // This means you cannot close it twice or you'll run into a
    // NoSuchElementException
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
        boolean is_repeated = keyboard.nextBoolean();

        if(!is_repeated && length > colors){
            System.out.println("Queste configurazioni non sono possibili!");
            System.out.println("Hai a disposizione troppi pochi colori per non fare ripetizioni.");
            System.out.println("Verranno scelte le configurazioni di default.");
            return new GameConfig();
        }
        return new GameConfig(length, attempts, colors, is_repeated);
    }
}