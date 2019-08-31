import java.lang.Math; 
import java.util.Random;
import java.util.Arrays;

public class Adoc{
    private int[][] square;
    
    public Adoc(int size){
	if(this.checkPow(size)){
	    square = new int[size][size];
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

    public void markSpecialSquare(){
	Random ran = new Random();
	int c1 = ran.nextInt(square.length);
	int c2 = ran.nextInt(square.length);
	square[c1][c2] = 1;
    }

    public int[][] LMark(){
	Random ran = new Random();
	int c1;
	int c2;
	
	if(square[0][0] == 0){
	    c1 = 0;
	    c2 = 0;
	}else if(square[0][square.length - 1] == 0){
	    c1 = 0;
	    c2 = square.length - 1;
	}else if(square[square.length - 1][0] == 0){
	    c1 = square.length - 1;
	    c2 = 0;
	}else if(square[square.length - 1][square.length - 1] == 0){
	    c1 = square.length - 1;
	    c2 = c1;
	}else{
	    c1 = ran.nextInt(square.length);
	    c2 = ran.nextInt(square.length);
	}
	
	int color = ran.nextInt(100) + 1;
	if(color == 1){
	    color = 2;
	}

	if(square[c1][c2] == 0){
	    square[c1][c2] = color;
	    if(c1 == 0 && c2 == 0){
		if(square[c1 + 1][c2] == 0){
		    square[c1 + 1][c2] = color;
		    if(square[c1][c2 + 1] == 0){
			square[c1][c2 + 1] = color;
			this.LMark();
		    }else if(square[c1 + 1][c2 + 1] == 0){
			square[c1 + 1][c2 + 1] = color;
			this.LMark();
		    }else{
			square[c1][c2] = 0;
			square[c1 + 1][c2] = 0;
			this.LMark();
		    }
		}else if(square[c1][c2 + 1] == 0){
		    square[c1][c2 + 1] = color;
		    if(square[c1 + 1][c2 + 1] == 0){
			square[c1 + 1][c2 + 1] = color;
			this.LMark();
		    }else{
			square[c1][c2] = 0;
			square[c1][c2 + 1] = 0;
			this.LMark();
		    }
		}else{
		    square[c1][c2] = 0;
		    this.LMark();
		}
	    }else if(c1 == 0 && c2 == square.length - 1){
		if(square[c1][c2 - 1] == 0){
		    square[c1][c2 - 1] = color;
		    if(square[c1 + 1][c2] == 0){
			square[c1 + 1][c2] = color;
			this.LMark();
		    }else if(square[c1 + 1][c2 - 1] == 0){
			square[c1 + 1][c2 - 1] = color;
			this.LMark();
		    }else{
			square[c1][c2] = 0;
			square[c1][c2 - 1] = 0;
			this.LMark();
		    }
		}else if(square[c1 + 1][c2] == 0){
		    square[c1 + 1][c2] = color;
		    if(square[c1 + 1][c2 - 1] == 0){
			square[c1 + 1][c2 - 1] = color;
			this.LMark();
		    }else{
			square[c1][c2] = 0;
			square[c1 + 1][c2] = 0;
			this.LMark();
		    }
		}else{
		    square[c1][c2] = 0;
		    this.LMark();
		}
	    }else if(c1 == square.length - 1 && c2 == 0){
		if(square[c1 - 1][c2] == 0){
		    square[c1 - 1][c2] = color;
		    if(square[c1][c2 + 1] == 0){
			square[c1][c2 + 1] = color;
			this.LMark();
		    }else if(square[c1 - 1][c2 + 1] == 0){
			square[c1 - 1][c2 + 1] = color;
			this.LMark();
		    }else{
			square[c1][c2] = 0;
			square[c1 - 1][c2] = 0;
			this.LMark();
		    }
		}else if(square[c1][c2 + 1] == 0){
		    square[c1][c2 + 1] = color;
		    if(square[c1 - 1][c2 + 1] == 0){
			square[c1 - 1][c2 + 1] = color;
			this.LMark();
		    }else{
			square[c1][c2] = 0;
			square[c1][c2 + 1] = 0;
			this.LMark();
		    }
		}else{
		    square[c1][c2] = 0;
		    this.LMark();
		}
	    }else if(c1 == square.length - 1 && c2 == square.length - 1){
		if(square[c1 - 1][c2] == 0){
		    square[c1 - 1][c2] = color;
		    if(square[c1][c2 - 1] == 0){
			square[c1][c2 - 1] = color;
			this.LMark();
		    }else if(square[c1 - 1][c2 - 1] == 0){
			square[c1 - 1][c2 - 1] = color;
			this.LMark();
		    }else{
			square[c1][c2] = 0;
			square[c1 - 1][c2] = 0;
			this.LMark();
		    }
		}else if(square[c1][c2 - 1] == 0){
		    square[c1][c2 - 1] = color;
		    if(square[c1 - 1][c2 - 1] == 0){
			square[c1 - 1][c2 - 1] = color;
			this.LMark();
		    }else{
			square[c1][c2 - 1] = 0;
			square[c1][c2] = 0;
			this.LMark();
		    }
		}else{
		    square[c1][c2] = 0;
		    this.LMark();
		}
	    }else if(c1 > 0 && c1 < square.length - 1 && c2 == 0){
		if(square[c1][c2 + 1] == 0 && square[c1 - 1][c2] == 0){
		    square[c1][c2 + 1] = color;
		    square[c1 - 1][c2] = color;
		    this.LMark();
		}else if(square[c1 + 1][c2] == 0 && square[c1][c2 + 1] == 0){
		    square[c1 + 1][c2] = color;
		    square[c1][c2 + 1] = color;
		    this.LMark();
		}else if(square[c1 - 1][c2] == 0 && square[c1 - 1][c2 + 1] == 0){
		    square[c1 - 1][c2] = color;
		    square[c1 - 1][c2 + 1] = color;
		    this.LMark();
		}else if(square[c1 + 1][c2] == 0 && square[c1 + 1][c2 + 1] == 0){
		    square[c1 + 1][c2] = color;
		    square[c1 + 1][c2 + 1] = color;
		    this.LMark();
		}else if(square[c1][c2 + 1] == 0 && square[c1 - 1][c2 + 1] == 0){
		    square[c1][c2 + 1] = color;
		    square[c1 - 1][c2 + 1] = color;
		    this.LMark();
		}else if(square[c1][c2 + 1] == 0 && square[c1 + 1][c2 + 1] == 0){
		    square[c1][c2 + 1] = color;
		    square[c1 + 1][c2 + 1] = color;
		    this.LMark();
		}else{
		    square[c1][c2] = 0;
		    this.LMark();
		}
	    }else if(c1 > 0 && c1 < square.length - 1 && c2 == square.length - 1){
		if(square[c1 - 1][c2] == 0 && square[c1][c2 - 1] == 0){
		    square[c1][c2 - 1] = color;
		    square[c1 - 1][c2] = color;
		    this.LMark();
		}else if(square[c1 + 1][c2] == 0 && square[c1 + 1][c2 - 1] == 0){
		    square[c1 + 1][c2] = color;
		    square[c1 + 1][c2 - 1] = color;
		    this.LMark();
		}else if(square[c1 - 1][c2] == 0 && square[c1 - 1][c2 - 1] == 0){
		    square[c1 - 1][c2] = color;
		    square[c1 - 1][c2 - 1] = color;
		    this.LMark();
		}else if(square[c1 + 1][c2] == 0 && square[c1][c2 - 1] == 0){
		    square[c1 + 1][c2] = color;
		    square[c1 + 1][c2 - 1] = color;
		    this.LMark();
		}else if(square[c1][c2 - 1] == 0 && square[c1 - 1][c2 - 1] == 0){
		    square[c1][c2 - 1] = color;
		    square[c1 - 1][c2 - 1] = color;
		    this.LMark();
		}else if(square[c1][c2 - 1] == 0 && square[c1 + 1][c2 - 1] == 0){
		    square[c1][c2 - 1] = color;
		    square[c1 + 1][c2 - 1] = color;
		    this.LMark();
		}else{
		    square[c1][c2] = 0;
		    this.LMark();
		}
	    }else if(c1 == 0 && c2 > 0 && c2 < square.length - 1){
		if(square[c1][c2 + 1] == 0 && square[c1 + 1][c2] == 0){
		    square[c1][c2 + 1] = color;
		    square[c1 + 1][c2] = color;
		    this.LMark();
		}else if(square[c1][c2 - 1] == 0 && square[c1 + 1][c2] == 0){
		    square[c1][c2 - 1] = color;
		    square[c1 + 1][c2] = color;
		    this.LMark();
		}else if(square[c1 + 1][c2] == 0 && square[c1 + 1][c2 + 1] == 0){
		    square[c1 + 1][c2] = color;
		    square[c1 + 1][c2 + 1] = color;
		    this.LMark();
		}else if(square[c1 + 1][c2] == 0 && square[c1 + 1][c2 - 1] == 0){
		    square[c1 + 1][c2] = color;
		    square[c1 + 1][c2 - 1] = color;
		    this.LMark();
		}else if(square[c1][c2 + 1] == 0 && square[c1 + 1][c2 + 1] == 0){
		    square[c1][c2 + 1] = color;
		    square[c1 + 1][c2 + 1] = color;
		    this.LMark();
		}else if(square[c1][c2 - 1] == 0 && square[c1 + 1][c2 - 1] == 0){
		    square[c1][c2 - 1] = color;
		    square[c1 + 1][c2 - 1] = color;
		    this.LMark();
		}else{
		    square[c1][c2] = 0;
		    this.LMark();
		}
	    }else if(c1 == square.length - 1 && c2 > 0 && c2 < square.length - 1){
		if(square[c1 - 1][c2] == 0 && square[c1][c2 + 1] == 0){
		    square[c1 - 1][c2] = color;
		    square[c1][c2 + 1] = color;
		    this.LMark();
		}else if(square[c1 - 1][c2] == 0 && square[c1][c2 - 1] == 0){
		    square[c1 - 1][c2] = color;
		    square[c1][c2 - 1] = color;
		    this.LMark();
		}else if(square[c1 - 1][c2] == 0 && square[c1 - 1][c2 + 1] == 0){
		    square[c1 - 1][c2] = color;
		    square[c1 - 1][c2 + 1] = color;
		    this.LMark();
		}else if(square[c1 - 1][c2] == 0 && square[c1 - 1][c2 - 1] == 0){
		    square[c1 - 1][c2] = color;
		    square[c1 - 1][c2 - 1] = color;
		    this.LMark();
		}else if(square[c1][c2 + 1] == 0 && square[c1 - 1][c2 + 1] == 0){
		    square[c1][c2 + 1] = color;
		    square[c1 - 1][c2 + 1] = color;
		    this.LMark();
		}else if(square[c1][c2 - 1] == 0 && square[c1 - 1][c2 - 1] == 0){
		    square[c1][c2 - 1] = color;
		    square[c1 - 1][c2 - 1] = color;
		    this.LMark();
		}else{
		    square[c1][c2] = 0;
		    this.LMark();
		}
	    }else{
	        
	    }
	}else{
	    int cou = 0;
	    int z = 0;
	    for(int i = 0; i<square.length; i++){
		for(int j = 0; j<square.length; j++){
		    try{
			if(square[i][j] == 0 && square[i + 1][j] == 0 && square[i][j + 1] == 0 || square[i][j] == 0 && square[i][j - 1] == 0 && square[i + 1][j] == 0 || square[i][j] == 0 && square[i][j - 1] == 0 && square[i - 1][j] == 0 || square[i][j] == 0 && square[i - 1][j] == 0 && square[i][j + 1] == 0){
			    cou++;
			}else if(square[i][j] == 0){
			    z++;
			}
		    }catch(ArrayIndexOutOfBoundsException e){
			continue;
		    }
		}
	    }
	    
	    if(cou >= 1){
		this.LMark();
	    }else if(z >= 1){
		
		for(int[] i : square){
		    for(int j = 0; j < i.length ; j++){
			if(i[j] > 1){
			    i[j] = 0;
			}
		    }
		}
		this.LMark();
	    }else{
		return square;
	    }
	}
	return square;
    }

    private boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start)/2;
            int num = matrix[mid/col][mid%col];
            if (target == num) {
                return true;
            } else if (num < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return (matrix[start/col][start%col] == target || matrix[end/col][end%col] == target);
    }

    public static void main(String[] args){
	Adoc f = new Adoc(Integer.parseInt(args[0]));
	f.markSpecialSquare();
	int[][] s = f.LMark();
	for(int[] i : s){
	    for(int a : i){
		System.out.print(a);
		System.out.print(",");
	    }
	    System.out.print("\n");
	}
    }

}
