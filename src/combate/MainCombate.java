package combate;

public class MainCombate {
    
    public static void main(String[] args) {
        //Creamos un combate
        Combate c1 = new Combate(null, null);
        Turno t1 = new Turno(1, "Charmander usa Ascuas","Squirtle usa Burbuja" );
        Turno t2 = new Turno(2, "Charmander usa Arañazo","Squirtle usa Placaje" );
       
        //Añadimos el turno
        c1.addTurno(t1);
        c1.addTurno(t2);

        c1.escribirCombate();

    }
}
