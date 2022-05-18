package main;

import java.util.ArrayList;
import java.util.Random;

import entrenador.Entrenador;
import enumerado.Estado;
import enumerado.Mejora;
import enumerado.Tipo;
import enumerado.TipoMovimiento;
import pokemon.Movimiento;
import pokemon.MovimientoAtaque;
import pokemon.MovimientoEstado;
import pokemon.MovimientoEstadoParalizado;
import pokemon.MovimientoMejora;
import pokemon.Pokemon;

public class Main{

    public static void main(String[] args) {
        Random rm = new Random();
        
        //Tipos
        Tipo[] tipos1 = new Tipo[2];
        tipos1[0] = Tipo.AGUA;

        Tipo[] tipos2 = new Tipo[2];
        tipos2[0] = Tipo.ELECTRICO;

        Tipo[] tipos3 = new Tipo[2];
        tipos3[0] = Tipo.BICHO;
        tipos3[1] = Tipo.NORMAL;

        //Movimientos
        MovimientoAtaque mA = new MovimientoAtaque("Placaje", Tipo.NORMAL, TipoMovimiento.FISICO, 20, 55);
        MovimientoMejora mM = new MovimientoMejora("Bravura", Tipo.NORMAL, 55, Mejora.ATAQUE, 3);
        MovimientoEstado mE = new MovimientoEstadoParalizado("Paralisis", Tipo.ELECTRICO, Estado.PARALIZADO, 15, 3);
        Movimiento[] movimientos1= new Movimiento[4];
        Movimiento[] movimientos2= new Movimiento[4];
        Movimiento[] movimientos3= new Movimiento[4];
        Movimiento[] movimientos4= new Movimiento[4];
        movimientos1[0] = mA;
        movimientos2[0] = mM;
        movimientos3[0] = mE;
        movimientos4[0] = mA;


        //Pokémon
        Pokemon n1 = new Pokemon("Pikachu", "Prrueba", 65, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 
        10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 30, 1, tipos1, movimientos1);
        Pokemon n2 = new Pokemon("Charmander", "Prrueba2", 90, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1,
        10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 50, 1, tipos2, movimientos2);
        Pokemon n3 = new Pokemon("Snorlax", "Prrueba3", 80, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 
        10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 20, 1, tipos1, movimientos3);
        Pokemon n4 = new Pokemon("Squirtle", "Prrueba4", 75, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 
        10 + rm.nextInt(5)+1, 10, 65, 1, tipos3, movimientos4);

        //Equipo
        ArrayList<Pokemon> equipo1 = new ArrayList<Pokemon>();
        ArrayList<Pokemon> equipo2 = new ArrayList<Pokemon>();
        equipo1.add(n1);
        equipo1.add(n2);
        equipo2.add(n4);


        //Entrenador
        Entrenador entrenador = new Entrenador("Peter", equipo1, equipo2);

        //Prueba de captura
        entrenador.captura(n3);
        System.out.println("Equipo Secundario Pokemon: ");
        for (int i = 0; i <= equipo2.size() - 1; i++) {
            System.out.println(entrenador.getEquipo2().get(i).getNombre());
        }

        //Mover Pokemon a equipo2
        System.out.println("Equipo Primario Pokemon: ");
        for (int i = 0; i <= equipo1.size() - 1; i++) {
            System.out.println(entrenador.getEquipo1().get(i).getNombre());
        }

        entrenador.moverPokemonE2(entrenador.getEquipo1().get(1));
        System.out.println("Equipo Secundario Pokemon: ");
        for (int i = 0; i <= equipo2.size() - 1; i++) {
            System.out.println(entrenador.getEquipo2().get(i).getNombre());
        }

        //Mover Pokemon a equipo1
        entrenador.moverPokemonE1(entrenador.getEquipo2().get(0));
        System.out.println("Equipo Primario Pokemon: ");
        for (int i = 0; i <= equipo1.size() - 1; i++) {
            System.out.println(entrenador.getEquipo1().get(i).getNombre());
        }

        

    }
    
}