package src;
import src.Adoc;
import java.util.Random;
import java.awt.Color;
import processing.core.PApplet;
import java.util.Scanner;

public class Principal extends PApplet{

    public static int tmatriz;
    Adoc ejemplar;
    private int[][] sq;

    @Override
    public void settings(){
        size(tmatriz * 20, tmatriz * 20);
    }
    
    @Override
    public void setup(){
        background (255, 255, 255);
        ejemplar = new Adoc(tmatriz);
        ejemplar.colorRand(200);
        sq = ejemplar.markSpecialSquare();
        colorea();
    }
    
    @Override
    public void draw(){

    }
    
    public void colorea(){
        float tamCasilla = 20;
        Random rn = new Random();
        for(int i=0;i<sq.length;i++){

            for(int j=0;j<sq.length;j++){
                int indC = sq[i][j];
                if(indC == 1){
                    fill(1); 
                }else{
                    Color tempC = ejemplar.colores.get(indC);
                    fill(tempC.getRed(),tempC.getGreen(),tempC.getBlue());
                }

                rect(i*tamCasilla,j*tamCasilla,tamCasilla,tamCasilla); 
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el tamaño de la matriz.");
        tmatriz = sc.nextInt();
        PApplet.main("src.Principal");
    }
    
}

