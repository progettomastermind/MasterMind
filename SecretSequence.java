class SecretSequence{
    private int[] secret_colors;

    /**
    * 0 vuoto (sbagliato)
    * 1 giusto al posto giusto (pallino nero)
    * 2 giusto al posto sbagliato (pallino bianco)
     */


    SecretSequence(int length, int color_amount, boolean is_repeated){
        if (is_repeated)
            secret_colors=Randomness.getRandomSequence(length, color_amount);
        else
            secret_colors=Randomness.getShuffledSequence(color_amount);
    }

    public int[] generateCheckSequence(int[] sequence){
        int counter_white = 0;
        int counter_black = 0;
        int[] secret_copy = new int[this.secret_colors.length];
        for(int i = 0; i < secret_copy.length; i++) 
            secret_copy[i] = this.secret_colors[i];

        for(int i = 0; i < sequence.length; i++)
            if(secret_copy[i] == sequence[i]) {
                counter_black++;
                secret_copy[i] = -1;    // Valore speciale, colore segnato
                sequence[i] = -1;
            }    // Se sono uguali metti il pallino nero

        for(int i=0; i < secret_copy.length; i++) {
            if (secret_copy[i] == -1) continue;
            for(int j = 0; j < sequence.length; j++){
                if(secret_copy[i] == sequence[j]){
                    counter_white++;
                    secret_copy[i] = -1;    // Valore speciale, colore segnato
                    sequence[j] = -1;
                    break;  // Continuo con il prossimo colore segreto
                }
            }
        }
        int[] black_white_amount = new int[2];
        black_white_amount[0] = counter_black;
        black_white_amount[1] = counter_white;    
        return black_white_amount;
    }
}