import java.lang.Math; 
import java.util.Random;
import java.util.Arrays;

public class Adoc2{
    public int[][] square;
    private int size;
    
    public Adoc2(int size){
	   if(this.checkPow(size)){
	       this.square = new int[size][size];
	       this.size = size;
	   }else{
	       System.exit(0);
	   }
    }

    private boolean checkPow(int c){
	if(c <= 0){
	    return false;
	}

	while(c > 1){
	    if(c % 2 != 0){
		return false;
	    }else{
		c = c/2;
	    }
	}
	return true;
    }

    public void LMark(){
	int len = this.size;
    }
    
    public void markSpecialSquare(){
	Random ran = new Random();
	int c1 = ran.nextInt(this.square.length);
	int c2 = ran.nextInt(this.square.length);
	this.square[c1][c2] = 1;
    }

    
    public static void main(String[] args){
	Adoc2 f = new Adoc2(Integer.parseInt(args[0]));
	f.markSpecialSquare();
	f.LMark();
	for(int[] i : f.square){
	    for(int a : i){
		System.out.print(a);
		System.out.print(",");
	    }
	    System.out.print("\n");
	}
    }
}
