package combate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import pokemon.Pokemon;

public class Combate {

    //Atributo
    private List<Turno> turnos;
    public static final String PATH="./log/combate.log";

    //Constructor
    //Creamos un combate pasandole un turno
    public Combate(){
        turnos = new LinkedList<>();

    }

    public List<Turno> getTurnos() {
        return turnos;
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
