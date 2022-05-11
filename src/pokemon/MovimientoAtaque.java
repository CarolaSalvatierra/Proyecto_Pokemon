package pokemon;

import Enum.Tipo;
import Enum.TipoMovimiento;

public class MovimientoAtaque extends Movimiento{
    private int potencia;
    private TipoMovimiento tMovimiento;
    
    MovimientoAtaque(String nombreMov, Tipo tipo, TipoMovimiento tMovimiento, int potencia, int estamina){
        super(nombreMov, tipo, estamina);
        this.potencia = potencia;
        this.tMovimiento = tMovimiento;
    }

    public int getPotencia() {
        return potencia;
    }

    public TipoMovimiento getTMovimiento() {
        return tMovimiento;
    }
}