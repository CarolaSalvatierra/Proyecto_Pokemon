package pokemon;

import java.util.ArrayList;

import entrenador.Entrenador;
import enumerado.Estado;
import enumerado.Mejora;
import enumerado.Tipo;
import enumerado.TipoMovimiento;


public class Main2 {
    public static void main(String[] args) {
        Tipo[] tipos = new Tipo[2];
        tipos[0] = Tipo.AGUA;
        MovimientoAtaque mA = new MovimientoAtaque("Placaje", Tipo.NORMAL, TipoMovimiento.FISICO, 20, 55);
       
        MovimientoMejora mM = new MovimientoMejora("Bravura", Tipo.NORMAL, 55, Mejora.ATAQUE, 3);
        MovimientoEstado mE = new MovimientoEstadoParalizado("Paralisis", Tipo.ELECTRICO, Estado.PARALIZADO, 15, 3);
        Movimiento[] movimientos= new Movimiento[4];
        movimientos[0] = mA;
        movimientos[1] = mM;
        movimientos[2] = mE;


        Pokemon n1 = new Pokemon("Prueba", "Prrueba", 80, 20, 30, 25, 15, 15, 50,
        1, tipos, movimientos);
        Pokemon n2 = new Pokemon("Prueba2", "Prrueba2", 90, 30, 30, 25, 15, 15, 50,
        1, tipos, movimientos);
        Pokemon n3 = new Pokemon("Prueba3", "Prrueba3", 80, 20, 30, 25, 15, 15, 50,
        1, tipos, movimientos);
        Pokemon n4 = new Pokemon("Prueba4", "Prrueba4", 90, 30, 30, 25, 15, 15, 50,
        1, tipos, movimientos);

        System.out.println(n1.getMovimientos()[0].getNombreMov());
        System.out.println(n1.getExperiencia());

        n1.subirNivel(5);

        //probando Entrenador
        Entrenador jugador = new Entrenador("XXX", new ArrayList<Pokemon>(), new ArrayList<Pokemon>());

        jugador.getEquipo1().add(n1);
        jugador.getEquipo1().add(n2);
        jugador.getEquipo1().add(n3);
        jugador.getEquipo1().add(n4);

        jugador.moverPokemonE2(n3);

        jugador.captura(n2);   
  
        System.out.println(n1);


        n1.mejorarPokemon((MovimientoMejora)movimientos[1]);


        /* 

        System.out.println(n1.getMejora());


        System.out.println(n1.getExperiencia());

        n1.subirNivel(5);
        */


    }

}
    

