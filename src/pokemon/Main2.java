package pokemon;

import enumerado.Tipo;
import enumerado.TipoMovimiento;


public class Main2 {
    public static void main(String[] args) {
        Tipo[] tipos = {Tipo.AGUA};
        MovimientoAtaque mA = new MovimientoAtaque("Placaje", Tipo.NORMAL, TipoMovimiento.FISICO, 20, 55);
       /* 
        MovimientoAtaque mA2 = new MovimientoAtaque("Burbuja", Tipo.AGUA, Tipo_Movimiento.ESPECIAL, 25, 10);
        Movimiento[] movimientos= new Movimiento[4];
        movimientos[0] = mA;
        movimientos[1] = mA2;
        */
        Movimiento[] movimientos= new Movimiento[]{mA};
        Pokemon n1 = new Pokemon("Prueba", "Prrueba", 80, 20, 30, 25, 15, 15, 50,
        1, tipos, movimientos);

        System.out.println(n1.getExperiencia());

        n1.subirNivel(5);


    }

}
    

