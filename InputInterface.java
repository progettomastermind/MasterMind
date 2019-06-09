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
    public static int[] ReadColors(int amount) {
        int[] colors = new int[amount];
        for (int i = 0; i < amount; i++)
            colors[i] = keyboard.nextInt();
        return colors;
    }
}