package pokemon;

import enumerado.Estado;
import enumerado.Tipo;
import enumerado.TipoMovimiento;


public class Main2 {
    public static void main(String[] args) {
        Tipo[] tipos = new Tipo[2];
        tipos[0] = Tipo.AGUA;
        MovimientoAtaque mA = new MovimientoAtaque("Placaje", Tipo.NORMAL, TipoMovimiento.FISICO, 20, 55);
       
        MovimientoEstado mE = new MovimientoEstadoParalizado("Paralisis", Tipo.ELECTRICO, Estado.PARALIZADO, 10, 3);
        Movimiento[] movimientos= new Movimiento[4];
        movimientos[0] = mA;
        movimientos[1] = mE;


        Pokemon n1 = new Pokemon("Prueba", "Prrueba", 80, 20, 30, 25, 15, 15, 50,
        1, tipos, movimientos);


        ((MovimientoMejora)n1.getMovimientos()[1]).efectoMejora(n1);

        System.out.println(n1.getMejora());


        System.out.println(n1.getExperiencia());

        n1.subirNivel(5);


    }

}
    

