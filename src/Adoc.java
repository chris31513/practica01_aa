package src;
import java.lang.Math; 
import java.util.Random;
import java.util.Arrays;
import java.lang.Object;
import java.awt.Color;
import java.util.LinkedList;

public class Adoc{
    private int[][] square;
    private int size;
    public LinkedList<Color> colores;


    public Adoc(int size){
        if(checkPow(size)){
            this.square = new int[size][size];
            this.size = size;
            this.colores = new LinkedList<Color>();
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

    private int[][] center(int[][] sq){
        int r = sq.length / 2;
        int[][] cent = new int[4][2];
        int[] cord = new int[2];
        int[] cord2 = new int[2];
        int[] cord3 = new int[2];
        int[] cord4 = new int[2];
        cord[0] = r - 1;
        cord[1] = r - 1;
        cord2[0] = r - 1;
        cord2[1] = r;
        cord3[0] = r;
        cord3[1] = r - 1;
        cord4[0] = r;
        cord4[1] = r;
        cent[0] = cord;
        cent[1] = cord2;
        cent[2] = cord3;
        cent[3] = cord4;
        return cent;
    }

    private int[][] elimQ(int[][] cord, int quadrant){
        int[][] cent = new int[3][2];
        int j = 1;
        int k = 0;
        for(int[] i : cord){
            if(j != quadrant){
                cent[k] = i;
                k++;
            }
            j++;
        }
        return cent;
    }

    public int[][] LMark(int[][] sq, int quadrants){
        Random rn = new Random();
        int y = sq.length / 2;
        int[][] matrix = sq;
        int r = rn.nextInt(200);
        if(r == 1 || r == 0){
            r = 2;
        }
        int[][] mat = elimQ(center(matrix), quadrants);
        for(int[] i : mat){
            matrix[i[0]][i[1]] = r;
        }
        if(matrix.length == 2){
            return matrix;
        }else{
            int[][] w2 = new int[y][y];
            for(int i = 0; i < y; i++){
                int[] w = new int[y];
                for(int j = 0; j < y; j++){
                    w[j] = matrix[i][j];
                }
                w2[i] = w;
            }
            int[][] w3 = new int[y][y];
            for(int i = 0; i < y; i++){
                int[] w = new int[y];
                for(int j = y; j < matrix.length; j++){
                    w[j - y] = matrix[i][j];
                }
                w3[i] = w;
            }
            int[][] w4 = new int[y][y];
            for(int i = y; i < matrix.length; i++){
                int[] w = new int[y];
                for(int j = 0; j < y; j++){
                    w[j] = matrix[i][j];
                }
                w4[i - y] = w;
            }
            int[][] w5 = new int[y][y];
            for(int i = y; i < matrix.length; i++){
                int[] w = new int[y];
                for(int j = y; j < matrix.length; j++){
                    w[j - y] = matrix[i][j];
                }
                w5[i - y] = w;
            }
            int quad1 = searchQuadrant(w2, y);
            int quad2 = searchQuadrant(w3, y);
            int quad3 = searchQuadrant(w4, y);
            int quad4 = searchQuadrant(w5, y);
            int[][] m1 = LMark(w2, quad1);
            int[][] m2 = LMark(w3, quad2);
            int[][] m3 = LMark(w4, quad3);
            int[][] m4 = LMark(w5, quad4);
            int[][] m12 = new int[m1.length + m2.length][m1.length + m2.length];
            for(int i = 0; i < m12.length / 2; i++){
                m12[i] = concatenate(m1[i], m2[i]);
            }
            for(int i = m12.length / 2; i < m12.length; i++){
                m12[i] = concatenate(m3[i - m12.length / 2], m4[i - m12.length / 2]);
            }
            return m12;
        }
    }

    public void colorRand(int n){
        Random ran = new Random();
        int r,g,b;
        for(int i=0;i<n;i++){
            r = ran.nextInt(256);
            g = ran.nextInt(256);
            b = ran.nextInt(256);
            colores.add(new Color(r,g,b));
        }
    }

    public int[] concatenate(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;

        @SuppressWarnings("unchecked")
        int[] c = new int[a.length + b.length];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }

    private int searchQuadrant(int[][] sq, int size){
        for(int i = 0; i < sq.length; i++){
            for(int j = 0; j < sq.length; j++){
                if(sq[i][j] != 0){
                    return selectQuadrant(i, j, size);
                }
            }
        }
        return 0;
    }

    public int[][] markSpecialSquare(){
        Random ran = new Random();
        int c1 = ran.nextInt(this.size);
        int c2 = ran.nextInt(this.size);
        if(this.square[c1][c2] == 0){
            this.square[c1][c2] = 1;
        }else{
            markSpecialSquare();
        }
        int quadrants = selectQuadrant(c1, c2, this.size);
        return LMark(this.square, quadrants);
    }

    private int selectQuadrant(int c1, int c2, int size){
        int quadrant;
        if(c1 < size / 2 && c2 < size / 2) {
            quadrant = 1;
        }else if(c1 < size / 2 && c2 >= size / 2){
            quadrant = 2;
        }else if(c1 >= size / 2 && c2 < size / 2) {
            quadrant = 3;
        }else{
            quadrant = 4;
        }
        return quadrant;
    }


    public static void main(String[] args){
        Adoc p = new Adoc(Integer.parseInt(args[0]));
        int[][] s = p.markSpecialSquare();
    }
}