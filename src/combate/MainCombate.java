package combate;

public class MainCombate {

    public static void main(String[] args) {
        
         //Creamos un combate
         Combate c1 = new Combate();
         Turno t1 = new Turno(1, "Charmander usa Ascuas","Squirtle usa Burbuja" );
         
         //Añadimos el turno
         c1.addTurno(t1);
         c1.escribirCombate();



    }
    
}
