/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laborator1;

/**
 *
 * @author My Pc
 */
public class Laborator1 {
    public static int cifraControl(int aux)
    {
        int suma=0;
        while(aux>0) 
        {
            suma=suma+aux%10;
            aux=aux/10;
        }
        int suma1=suma;
        while(suma1>9){ 
            suma1=0;
        while(suma>0){
            suma1=suma1+suma%10;
            suma=suma/10;
        }
         suma=suma1;
        }
        return suma;
    }
    public static void main(String[] args) {
        System.out.println ( "Hello World");
        String languages[]={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        System.out.println ( n);
        n=n*3;
        int add;
        add=0b10101;
        System.out.println ( add);
        n=n+add;
        add=0xFF;
         System.out.println ( add);
        n=n+add;
        n=n*6;
       int suma=cifraControl(n);
      System.out.println ( suma);
       System.out.println("Willy-nilly, this semester I will learn "+ languages[suma] + "." );
    }
}

