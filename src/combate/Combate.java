package combate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import entrenador.Entrenador1;


public class Combate {

    //Atributos
    private Entrenador1 eJugador;
    private Entrenador1 eRival;
    private Entrenador1 eGanador;
    private int pokemonKoJugador;
    private int pokemonKoRival;
    private List<Turno> turnos;
    public static final String PATH="./log/combate.log";

    //Constructor
    //Creamos un combate pasandole un turno
    public Combate(Entrenador1 ejugador, Entrenador1 eRival){
        this.eJugador = ejugador;
        this.eRival = eRival;
        this.eGanador = eGanador;
        this.pokemonKoJugador = pokemonKoJugador;
        this.pokemonKoRival = pokemonKoRival;
        turnos = new LinkedList<>();

    }

    public Entrenador1 geteJugador() {
        return eJugador;
    }
    public Entrenador1 geteRival() {
        return eRival;
    }
    public Entrenador1 geteGanador() {
        return eGanador;
    }
    public int getPokemonKoJugador() {
        return pokemonKoJugador;
    }
    public int getPokemonKoRival() {
        return pokemonKoRival;
    }
    public List<Turno> getTurnos() {
        return turnos;
    }
    public void seteJugador(Entrenador1 eJugador) {
        this.eJugador = eJugador;
    }
    public void setPokemonKoRival(int pokemonKoRival) {
        this.pokemonKoRival = pokemonKoRival;
    }
    public void seteGanador(Entrenador1 eGanador) {
        this.eGanador = eGanador;
    }
    public void setPokemonKoJugador(int pokemonKoJugador) {
        this.pokemonKoJugador = pokemonKoJugador;
    }
    public void seteRival(Entrenador1 eRival) {
        this.eRival = eRival;
    }
    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
    //Metodo para añadir un turno
    public void addTurno(Turno t){
        this.turnos.add(t);
    }
    //Metodo para escribir en un fichero
    public void escribirCombate(){

        File fichero = new File(PATH);
        try {
            FileWriter fw = new FileWriter(fichero);//File writer es el encargado de escribir en el fichero
            BufferedWriter bw = new BufferedWriter(fw);//Espacio de memoria que nos permite escribir texto para luego volcarlo
            //Recorremos c/u de los turnos para volcar despues el contenido cuando termine el combate
            //esto se tiene que hacer en el momento que se termine el combate
            for (Turno turno : turnos) {
                bw.write("Turno "+ turno.getNumeroTurno()+ ": \n");
                bw.write("Entrenador: "+turno.getAccionEntrenador()+"\n");
                bw.write("Rival: "+ turno.getAccionRival()+"\n");
            }
            bw.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }      
    }


}
