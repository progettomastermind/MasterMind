public class Game{
    public static void main(String[] Args){
        ConfigHandler handler = new ConfigHandler();    // Inizializziamo il ConfigHandler qui perchè ci serve in caso di opzione `-s`
        Boolean debug_mode = false;
        for(int i = 0; i < Args.length; i++){   // Leggiamo dalla linea di comando cosa c'e' bisogno di fare
            if(Args[i].equals("--settings") || Args[i].equals("-s")){
                GameConfig data = InputInterface.readUserConfigs(); // Chiediamo all'utente le configurazioni
                handler.writeConfigs(data); // Una volta ottenute, le scriviamo su file
                return; // Non vogliamo iniziare il gioco in caso di configurazione
            }
            else if(Args[i].equals("--help") || Args[i].equals("-h")){
                System.out.println("Leggi il ReadMe del progetto su https://github.com/progettomastermind/MasterMind");
                return; // Idem
            }
            else if(Args[i].equals("--debug") || Args[i].equals("-d")){
                debug_mode = true;
            }
        }
        GameConfig data = handler.readConfigs();    // Leggiamo le configurazioni dal file (Se non esiste non e' un problema: leggi documentazione funzione)
        SecretSequence secret_colors = new SecretSequence(data.length, data.colors, data.is_repeated);  // Creiamo la sequenza segreta
        if (debug_mode){    // Scriviamola nel caso le impostazioni di debug sono attive
            System.out.println("Debug: sequenza segreta: " + secret_colors);
        }
        System.out.println("Il gioco inizia! Hai " + data.attempts + " tentativi.");
        System.out.println("Scrivi " + data.length + " colori separati da spazio, ovvero numeri che vanno da 0 a " + (data.colors - 1));
        System.out.println("I colori " + (!data.is_repeated ? "non " : "") + "possono essere ripetuti");    // ? : viene detto operatore ternario (Spiegazione a parte)
        boolean is_completed = false;   // Serve un booleano da inizializzare per capire se a fine ciclo il gioco sia vinto o perso
        for(int attempts = 0; attempts < data.attempts; attempts++){
            int[] colors = InputInterface.readColors(data.length);  // Leggiamo i colori dall'utente
            int[] black_white = secret_colors.generateCheck(colors);   
            System.out.print("Tentativo " + String.format("%02d", attempts + 1) + "/" + String.format("%02d", data.attempts) + " | ");
            System.out.println("Neri: " + black_white[0] + ", Bianchi: " + black_white[1]);
            if(black_white[0] == data.length){  // Se ci sono tanti pallini neri quanti slot si sono indovinati tutti i colori nel posto giusto
                is_completed = true;
                break;
            }
        }
        if(is_completed){
            System.out.println("Congratulazioni, hai vinto!");
        }
        else{
            System.out.println("Oh no, hai perso! La sequenza giusta era:\n" + secret_colors);
        }
    }
}