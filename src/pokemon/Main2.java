package pokemon;

import java.util.Arrays;

import Enum.Estado;
import Enum.Tipo;
import Enum.Tipo_Movimiento;
import Enum.Ventaja;

public class Main2 {
    public static void main(String[] args) {
        Tipo[] tipos = {Tipo.AGUA};
        MovimientoAtaque mA = new MovimientoAtaque("Placaje", Tipo.NORMAL, Tipo_Movimiento.FISICO, 20, 55);
        Movimiento[] movimientos = {mA};
        MovimientoAtaque mA2 = new MovimientoAtaque("Burbuja", Tipo.AGUA, Tipo_Movimiento.ESPECIAL, 25, 10);
        Pokemon n1 = new Pokemon("Prueba", "Prrueba", 80, 20, 30, 25, 15, 15, 50,
        1, tipos, movimientos);

        System.out.println(n1.getExperiencia());

        System.out.println(Arrays.toString(n1.getMovimientos()));

        n1.subirNivel(5);


    }

}
    

