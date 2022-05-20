package combate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import entrenador.Entrenador;
import enumerado.Estado;
import enumerado.Mejora;
import pokemon.Movimiento;
import pokemon.MovimientoAtaque;
import pokemon.Pokemon;

public class Combate {

   // Atributo
   private Entrenador eJugador;
   private Entrenador eRival;
   private Entrenador ganador;
   private List<Turno> turnos;
   private int koJugador; // aqui tengo q poner private Pokemon koJugador?
   private int koRival;
   private Pokemon pokemonJugador;
   private Pokemon pokemonRival;

   // meter 2 pok
   // falta ganador
   public static final String PATH = "./Log/combate.log";

   // Constructor

   /**
    * Creamos un combate pasandole un turno, un Jugador y un rival, cada uno con su
    * respectivo pokemon
    * 
    * @param eJugador
    * @param eRival
    */
   public Combate(Entrenador eJugador, Entrenador eRival) {
       this.eJugador = eJugador;
       this.eRival = eRival;
       turnos = new LinkedList<>();
       this.pokemonJugador = eJugador.getEquipo1().get(0);
       this.pokemonRival = eRival.getEquipo1().get(0);
       this.koJugador = 0;
       this.koRival = 0;

   }

   public Entrenador geteJugador() {
       return eJugador;
   }

   public Entrenador geteRival() {
       return eRival;
   }

   public Entrenador getGanador() {
       return ganador;
   }

   public Pokemon getPokemonJugador() {
       return pokemonJugador;
   }

   public Pokemon getPokemonRival() {
       return pokemonRival;
   }

   public List<Turno> getTurnos() {
       return turnos;
   }

   public void seteJugador(Entrenador eJugador) {
       this.eJugador = eJugador;
   }

   public void seteRival(Entrenador eRival) {
       this.eRival = eRival;
   }

   public void setGanador(Entrenador ganador) {
       this.ganador = ganador;
   }

   public void setTurnos(List<Turno> turnos) {
       this.turnos = turnos;
   }

   public int getKoJugador() {
       return koJugador;
   }

   public int getKoRival() {
       return koRival;
   }

   // metodo combate
   /**
    * en este metodo el EJugador empieza eligiendo un movimientode los 4 que hay en
    * opciones, se introduce la opcion por scanner comienza el combate el jugador
    * que tenga mayor
    * velocidad, se realiza el primer ateque al pokemon del rival luego se
    * comprueba la vitalidad.
    * El pokémon que tiene mayor velocidad para iniciar un combate recive la mejora
    * de velocidad x 2
    * El indice es para incrementar los pokemon q va perdiendo cada jugador hasta
    * llegar a 4
    * 
    * @param eJugador       entrenador jugador
    * @param eRival         entrenador rival
    * @param pokemonJugador pokemon que utiliza el entrenador jugador
    * @param pokemonRival   pokemosn que utiliza el rival
    */
   public void combatir(Entrenador eJugador, Entrenador eRival, Pokemon pokemonJugador, Pokemon pokemonRival) {

       int indiceJugador = 0;
       int indiceRival = 0;
       int velocidadMejJugador = 1;
       int velocidadMejRival = 1;
       
       while(indiceJugador != 4 && indiceRival != 4){

       System.out.println("Introduce una opcion de ataque ");
       System.out.println("1. " + pokemonJugador.getMovimientos()[0].getNombreMov() +
               "\n 2." + pokemonJugador.getMovimientos()[1].getNombreMov() + "\n 3. " +
               pokemonJugador.getMovimientos()[2].getNombreMov() +
               "\n 4." + pokemonJugador.getMovimientos()[3].getNombreMov());

       Scanner sc = new Scanner(System.in);
       Random rnd = new Random();
       int opcion = sc.nextInt();
       int opcionRival = rnd.nextInt(3);

       Movimiento mA = pokemonJugador.getMovimientos()[opcion];
       Movimiento mA2 = pokemonRival.getMovimientos()[opcionRival];

       if (pokemonJugador.getMejora() == Mejora.VELOCIDAD) {
           velocidadMejJugador = 2;
       }

       if (pokemonRival.getMejora() == Mejora.VELOCIDAD) {
           velocidadMejRival = 2;
       }

       if (pokemonJugador.getVelocidad() * velocidadMejJugador >= pokemonRival.getVelocidad()) {
           pokemonJugador.atacarPokemon((MovimientoAtaque) mA, pokemonRival);

           if (pokemonRival.getEstado() != Estado.KO) {
               pokemonRival.atacarPokemon((MovimientoAtaque) mA2, pokemonJugador);//
           } else {
               indiceRival++;
               pokemonRival = eRival.getEquipo1().get(indiceRival);
           }

       }
       if (pokemonRival.getVelocidad() * velocidadMejRival >= pokemonJugador.getVelocidad()) {
           pokemonRival.atacarPokemon((MovimientoAtaque) mA2, pokemonJugador);

           if (pokemonJugador.getEstado() !=  Estado.KO) {
               pokemonJugador.atacarPokemon((MovimientoAtaque) mA, pokemonRival);
           } else {
               indiceJugador++;
               pokemonJugador = eRival.getEquipo1().get(indiceJugador);
           }

       }
   }

   }

   /**
    * Método para añadir turno
    * 
    * @param t
    */
   public void addTurno(Turno t) {
       this.turnos.add(t);
   }

   /**
    * File objeto q nos permite escribir en un fichero
    * Metodo para escribir en un fichero, este método vamos nos permite generar y
    * rrellenar el buffer
    * para luego volcarlo en el fichero
    */
   public void escribirCombate() {
       File fichero = new File(PATH);
       try {

           FileWriter fw = new FileWriter(fichero);
           BufferedWriter bw = new BufferedWriter(fw);//
           // Recorremos cada turno dentro de la lista de turnos del combate
           for (Turno turno : turnos) {
               bw.write("Turno " + turno.getNumeroTurno() + ": \n");
               bw.write("Entrenador: " + turno.getAccionEntrenador() + " \n");
               bw.write("Rival: " + turno.getAccionRival() + "\n");
           }
           bw.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

}

