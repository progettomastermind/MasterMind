public class Game{
    public static void main(String[] Args){
        ConfigHandler handler = new ConfigHandler();
        Boolean debug_mode = false;
        for(int i = 0; i < Args.length; i++){   // Leggiamo dalla linea di comando cosa c'e' bisogno di fare
            if(Args[i].equals("--settings") || Args[i].equals("-s")){
                GameConfig data = InputInterface.readUserConfigs();
                handler.writeConfigs(data);
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
        GameConfig data = handler.readConfigs();
        SecretSequence secret_colors = new SecretSequence(data.length, data.colors, data.is_repeated);
        if (debug_mode){
            System.out.println("Debug: sequenza segreta: " + secret_colors);
        }
        System.out.println("Il gioco inizia! Hai " + data.attempts + " tentativi.");
        System.out.println("Scrivi " + data.length + " colori separati da spazio, ovvero numeri che vanno da 0 a " + (data.colors - 1));
        System.out.println("I colori " + (!data.is_repeated ? "non " : "") + "possono essere ripetuti");
        boolean is_completed = false;
        for(; data.attempts > 0; data.attempts--){
            int[] colors = InputInterface.readColors(data.length);
            int[] black_white = secret_colors.generateCheck(colors);
            System.out.println("Pallini");
            System.out.println("Neri: " + black_white[0] + ", Bianchi: " + black_white[1]);
            if(black_white[0] == data.length){
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