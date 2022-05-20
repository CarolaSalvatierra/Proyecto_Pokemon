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
        MovimientoAtaque mA = new MovimientoAtaque("Placaje", Tipo.NORMAL, TipoMovimiento.FISICO, 15, 5);
        MovimientoMejora mM = new MovimientoMejora("Bravura", Tipo.NORMAL, 20, Mejora.ATAQUE, 3);
        MovimientoEstado mE = new MovimientoEstadoParalizado("Paralisis", Tipo.ELECTRICO, Estado.PARALIZADO, 15, 3);
        MovimientoAtaque mA2 = new MovimientoAtaque("Rayo", Tipo.ELECTRICO, TipoMovimiento.ESPECIAL, 20, 10);
        MovimientoAtaque mA3 = new MovimientoAtaque("Burbuja", Tipo.AGUA, TipoMovimiento.ESPECIAL, 20, 10);
        MovimientoAtaque mA4 = new MovimientoAtaque("Ascua", Tipo.FUEGO, TipoMovimiento.ESPECIAL, 20, 10);
        MovimientoEstado mE2 = new MovimientoEstadoParalizado("Dormir", Tipo.NORMAL, Estado.DORMIDO, 15, 3);
        MovimientoMejora mM2 = new MovimientoMejora("Prisa", Tipo.NORMAL, 20, Mejora.VELOCIDAD, 3);
        Movimiento[] movimientos1= new Movimiento[4];
        Movimiento[] movimientos2= new Movimiento[4];
        Movimiento[] movimientos3= new Movimiento[4];
        Movimiento[] movimientos4= new Movimiento[4];
        movimientos1[0] = mA;
        movimientos2[0] = mA4;
        movimientos2[0] = mM;
        movimientos3[0] = mE;

        movimientos4[0] = mA;
        movimientos4[1] = mA3;
        movimientos4[2] = mE2;
        movimientos4[3] = mM2;


        //Pokémon
        Pokemon n1 = new Pokemon("Pikachu", "Prrueba", 65, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 
        10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 30, 1, tipos1, movimientos1);
        Pokemon n2 = new Pokemon("Charmander", "Prrueba2", 90, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1,
        10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 50, 1, tipos2, movimientos2);
        Pokemon n3 = new Pokemon("Snorlax", "Prrueba3", 80, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 
        10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 20, 1, tipos1, movimientos3);
        Pokemon n4 = new Pokemon("Squirtle", "Prrueba4", 75, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 10 + rm.nextInt(5)+1, 
        10 + rm.nextInt(5)+1, 10, 65, 1, tipos3, movimientos4);

        ArrayList<Pokemon> pokemonSalvaje = new ArrayList<>();
        pokemonSalvaje.add(n1);
        pokemonSalvaje.add(n2);
        pokemonSalvaje.add(n3);
        pokemonSalvaje.add(n4);

        //Equipo
        ArrayList<Pokemon> equipo1 = new ArrayList<Pokemon>();
        ArrayList<Pokemon> equipo2 = new ArrayList<Pokemon>();
        equipo1.add(n1);
        equipo1.add(n2);
        equipo2.add(n4);


        //Entrenador
        Entrenador entrenador = new Entrenador("Peter", equipo1, equipo2);

        //Prueba de captura
        int capturaSalvaje = rm.nextInt(4)+1;
        switch (capturaSalvaje){
            case 1:
                entrenador.captura(n1);
                break;
            case 2:
                entrenador.captura(n2);
                break;
            case 3:
                entrenador.captura(n3);
                break;
            case 4: 
                entrenador.captura(n4);
                break;
        } 
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

        System.out.println("Equipo Secundario Pokemon: ");
        for (int i = 0; i <= equipo2.size() - 1; i++) {
            System.out.println(entrenador.getEquipo2().get(i).getNombre());
        }

        
        //Subir de nivel y aprender movimientos
        n4.subirNivel(50, mA2);

    }
    
}