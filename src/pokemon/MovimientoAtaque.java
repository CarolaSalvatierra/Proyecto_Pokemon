package pokemon;

import Enum.Tipo;
import Enum.Tipo_Movimiento;

public class MovimientoAtaque extends Movimiento{
    private int potencia;
    private Tipo_Movimiento tMovimiento;
    
    MovimientoAtaque(String nombreMov, Tipo tipo, Tipo_Movimiento tMovimiento, int potencia){
        super(nombreMov, tipo);
        this.potencia = potencia;
        this.tMovimiento = tMovimiento;
    }

    public int getPotencia() {
        return potencia;
    }

    public Tipo_Movimiento getTMovimiento() {
        return tMovimiento;
    }
}