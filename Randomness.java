import java.util.Random;

public class Randomness{

    public static int[] GetRandomSequence(int length, int color_amount){
        Random random = new Random();
        int[] seq = new int[length];
        for(int i=0; i<length; i++){
            seq[i]= random.nextInt(color_amount);
        }
        return seq;
    }

    public static int[] GetShuffledSequence(int length, int color_amount){
        Random random = new Random();
        int[] rainbow = new int[color_amount];
        int c;
        int tmp;

        for(int i=0; i<color_amount; i++)
            rainbow[i]=i;

        int[] seq = new int[length];

        for(int i=0; i<length; i++){
            c=i+random.nextInt(color_amount-i);
            tmp=rainbow[i];
            rainbow[i]=rainbow[c];
            rainbow[c]=tmp;
            seq[i]=rainbow[i];
        }
        return seq;
    }   
}