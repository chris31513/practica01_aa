import java.lang.Math; 
import java.util.Random;
import java.util.Arrays;

public class Adoc2{
    public int[][] square;
    private int size;

    public Adoc2(int size){
        if(checkPow(size)){
            this.square = new int[size][size];
            this.size = size;
        }else{
            System.exit(0);
        }
    }

    private boolean checkPow(int num){
        if(num <= 0){
            return false;
        }else{
            while(num > 1){
                if(num % 2 != 0){
                    return false;
                }else{
                    num = num / 2;
                }
            }
            return true;
        }
    }

    public void markSpecialSquare(){
        Random ran = new Random();
        int c1 = ran.nextInt(this.size);
        int c2 = ran.nextInt(this.size);
        this.square[c1][c2] = 1;
    }

    public static void main(String[] args){
        Adoc2 p = new Adoc2(Integer.parseInt(args[0]));
        p.markSpecialSquare();
    }
}
