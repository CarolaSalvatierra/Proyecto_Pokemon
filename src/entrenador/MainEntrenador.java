package entrenador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import pokemon.Pokemon;

public class MainEntrenador {

    public static void main(String[] args) {


      //  Entrenador1 entr1 = new Entrenador1("Pete", new ArrayList<Pokemon>(), new ArrayList<Pokemon>());
        HashMap<String, LinkedList<Pokemon>>entrenador = new HashMap<String, LinkedList<Pokemon>>();

        Pokemon p1 = new Pokemon("pikachu1", "Pika1", 20, 10, 30, 15, 25, 30  , 50    , 20, null, null);

        Pokemon p2 = new Pokemon("pikachu2", "Pika2", 20, 10, 30, 15, 25, 30  , 50    , 20, null, null);
        
        Pokemon p3 = new Pokemon("pikachu3", "Pika3", 20, 10, 30, 15, 25, 30  , 50    , 20, null, null);

        Pokemon p4 = new Pokemon("pikachu4", "Pika4", 20, 10, 30, 15, 25, 30  , 50    , 20, null, null);
        
        entrenador.put("Tipo ", new LinkedList<Pokemon>());
        entrenador.get("Tipo Planta ").add(p1);
        entrenador.get("Tipo Planta ").add(p2);
        entrenador.get("Tipo Planta ").add(p3);
        entrenador.get("Tipo Planta ").add(p4);
        

       


    }
    
}
