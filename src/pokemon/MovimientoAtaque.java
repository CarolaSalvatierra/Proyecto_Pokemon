package pokemon;

import enumerado.Tipo;
import enumerado.TipoMovimiento;

public class MovimientoAtaque extends Movimiento{
    private int potencia;
    private TipoMovimiento tMovimiento;
    
    public MovimientoAtaque(String nombreMov, Tipo tipo, TipoMovimiento tMovimiento, int potencia, int estamina){
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