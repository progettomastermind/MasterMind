class SecretSequence {
    private int[] secret_colors;


    SecretSequence(int length, int color_amount, boolean is_repeated) {
        // int[] secret_colors = new int[length];
        this.secret_colors = new int[length];
        if (is_repeated) {
            this.secret_colors = Randomness.getRandomSequence(length, color_amount);
        } else {
            if (length > color_amount){
                color_amount = length;   // Altrimenti non si potrebbe creare tale array
            }
            int[] shuffled = Randomness.getShuffledSequence(color_amount);
            for (int i = 0; i < length; i++) {
                this.secret_colors[i] = shuffled[i];
            }
        }

    }
    /**
     * Compara la sequenza segreta con una sequenza esterna di colori, generando il numero di
     * pallini neri e bianchi
     * @param sequence  Sequenza di colori da comparare
     * @return  Restituisce un'array che contiene sempre due numeri di pallini, il primo dei neri, il secondo dei bianchi
     */
    public int[] generateCheck(int[] sequence) {
        int counter_white = 0;
        int counter_black = 0;
        int[] secret_copy = new int[this.secret_colors.length];
        for (int i = 0; i < secret_copy.length; i++)
            secret_copy[i] = this.secret_colors[i];

        for (int i = 0; i < sequence.length; i++)
            if (secret_copy[i] == sequence[i]) {
                counter_black++;
                secret_copy[i] = -1; // Valore speciale, colore segnato
                sequence[i] = -1;
            } // Se sono uguali metti il pallino nero

        for (int i = 0; i < secret_copy.length; i++) {
            if (secret_copy[i] == -1)
                continue;
            for (int j = 0; j < sequence.length; j++) {
                if (secret_copy[i] == sequence[j]) {
                    counter_white++;
                    secret_copy[i] = -1; // Valore speciale, colore segnato
                    sequence[j] = -1;
                    break; // Continuo con il prossimo colore segreto
                }
            }
        }
        int[] black_white_amount = new int[2];
        black_white_amount[0] = counter_black;
        black_white_amount[1] = counter_white;
        return black_white_amount;
    }

    public String toString() {
        String r = new String();
        for (int i = 0; i < this.secret_colors.length; i++) {
            r += this.secret_colors[i];
            r += ' ';
        }
        r += '\n';
        return r;
    }
}