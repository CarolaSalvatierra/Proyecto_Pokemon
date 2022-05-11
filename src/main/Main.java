package main;

import pokemon.Pokemon;

public class Main{

    public static void main(String[] args) {
        
        Pokemon p = new Pokemon("Pepe", null, 0, 0, 0, 0, 0, 0, 0, 0);//Pueba del constructor x defecto hay q hacerlo bien
        System.out.println(p.getNombre());
    }
    
}