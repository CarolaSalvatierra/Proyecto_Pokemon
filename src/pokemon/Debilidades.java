package pokemon;

import java.util.HashMap;
import java.util.LinkedList;

import enumerado.Tipo;

public class Debilidades{

    public static HashMap<Tipo, LinkedList<Tipo>> debilidades = new HashMap<>(); 
    public static HashMap<Tipo, LinkedList<Tipo>> fortalezas = new HashMap<>(); 

    public void crearDebilidades(){

        //AGUA 
        LinkedList<Tipo> aguaEficaz = new LinkedList<>();
        aguaEficaz.add(Tipo.TIERRA);
        LinkedList<Tipo> aguaNoEficaz = new LinkedList<>();
        aguaNoEficaz.add(Tipo.AGUA);
        aguaNoEficaz.add(Tipo.PLANTA);
        aguaNoEficaz.add(Tipo.ELECTRICO);
        

        debilidades.put(Tipo.AGUA, aguaEficaz);
        fortalezas.put(Tipo.AGUA, aguaNoEficaz);

        //PLANTA
        LinkedList<Tipo> plantaEficaz = new LinkedList<>();
        plantaEficaz.add(Tipo.AGUA);
        aguaEficaz.add(Tipo.TIERRA);
        LinkedList<Tipo> plantaNoEficaz = new LinkedList<>();
        plantaNoEficaz.add(Tipo.PLANTA);
        plantaNoEficaz.add(Tipo.FUEGO);
        plantaNoEficaz.add(Tipo.VOLADOR);
        

        debilidades.put(Tipo.PLANTA, plantaEficaz);
        fortalezas.put(Tipo.PLANTA, plantaNoEficaz);

        //FUEGO 
        LinkedList<Tipo> fuegoEficaz = new LinkedList<>();
        fuegoEficaz.add(Tipo.PLANTA);
        fuegoEficaz.add(Tipo.BICHO);
        LinkedList<Tipo> fuegoNoEficaz = new LinkedList<>();
        fuegoNoEficaz.add(Tipo.AGUA);
        fuegoNoEficaz.add(Tipo.FUEGO);
        
        

        debilidades.put(Tipo.FUEGO, fuegoEficaz);
        fortalezas.put(Tipo.FUEGO, fuegoNoEficaz);

        //BICHO 
        LinkedList<Tipo> bichoEficaz = new LinkedList<>();
        bichoEficaz.add(Tipo.PLANTA);
        LinkedList<Tipo> bichoNoEficaz = new LinkedList<>();
        bichoNoEficaz.add(Tipo.FUEGO);
        bichoNoEficaz.add(Tipo.VOLADOR);
        

        debilidades.put(Tipo.BICHO, bichoEficaz);
        fortalezas.put(Tipo.BICHO, bichoNoEficaz);

        //VOLADOR 
        LinkedList<Tipo> voladorEficaz = new LinkedList<>();
        voladorEficaz.add(Tipo.PLANTA);
        voladorEficaz.add(Tipo.BICHO);
        LinkedList<Tipo> voladorNoEficaz = new LinkedList<>();
        voladorNoEficaz.add(Tipo.ELECTRICO);
        

        debilidades.put(Tipo.VOLADOR, voladorEficaz);
        fortalezas.put(Tipo.VOLADOR, voladorNoEficaz);

        //ELECTRICO 
        LinkedList<Tipo> electricoEficaz = new LinkedList<>();
        electricoEficaz.add(Tipo.AGUA);
        LinkedList<Tipo> electricoNoEficaz = new LinkedList<>();
        electricoNoEficaz.add(Tipo.ELECTRICO);
        electricoNoEficaz.add(Tipo.PLANTA);
        electricoNoEficaz.add(Tipo.TIERRA);
        

        debilidades.put(Tipo.ELECTRICO, electricoEficaz);
        fortalezas.put(Tipo.ELECTRICO, electricoNoEficaz);

        //TIERRA 
        LinkedList<Tipo> tierraEficaz = new LinkedList<>();
        tierraEficaz.add(Tipo.FUEGO);
        tierraEficaz.add(Tipo.ELECTRICO);
        LinkedList<Tipo> tierraNoEficaz = new LinkedList<>();
        tierraNoEficaz.add(Tipo.VOLADOR);
        tierraNoEficaz.add(Tipo.PLANTA);
        tierraNoEficaz.add(Tipo.BICHO);
        

        debilidades.put(Tipo.TIERRA, tierraEficaz);
        fortalezas.put(Tipo.TIERRA, tierraNoEficaz);

        //NORMAL 
        LinkedList<Tipo> normalNoEficaz = new LinkedList<>();
        normalNoEficaz.add(Tipo.NORMAL);

        fortalezas.put(Tipo.NORMAL, normalNoEficaz);

    }




}