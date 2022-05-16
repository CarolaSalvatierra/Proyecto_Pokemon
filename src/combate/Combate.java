package combate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import entrenador.Entrenador;

public class Combate {

    //Atributo
    private Entrenador eJugador;
    private Entrenador eRival;
    private List<Turno> turnos;
    private int koJugador; //aqui tengo q poner private Pokemon koJugador?
    private int koRival;
    //falta  ganador 
    public static final String PATH = "./Log/combate.log";

    //Constructor
    //Creamos un combate pasandole un turno
    public Combate(Entrenador eJugador, Entrenador eRival){
        this.eJugador = eJugador;
        this.eRival = eRival;
        turnos = new LinkedList<>();

    }
    public Entrenador geteJugador() {
        return eJugador;
    }
    public Entrenador geteRival() {
        return eRival;
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
    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
    public int getKoJugador() {
        return koJugador;
    }
    public int getKoRival() {
        return koRival;
    }
    //Metodo para añadir un turno
    public void addTurno(Turno t){
        this.turnos.add(t);
    }
    //Metodo para escribir en un fichero
    public void escribirCombate(){
        File fichero = new File(PATH);
        try {
            //File objeto q nos permite escribir en un fichero
            FileWriter fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);//Nos permite generar rrellenar el buffer para luego volcarlo en el fichero
            //Recorremos cada turno dentro de la lista de turnos del combate
            for (Turno turno : turnos) {
                bw.write("Turno "+turno.getNumeroTurno()+ ": \n");
                bw.write("Entrenador: "+ turno.getAccionEntrenador()+ " \n");
                bw.write("Rival: "+turno.getAccionRival()+ "\n");               
            }
            bw.close();
        } catch (IOException e) {           
            e.printStackTrace();
        }
    }

  

  
 


}

