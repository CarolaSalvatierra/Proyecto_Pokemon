package pokemon;

import Enum.Tipo;

public class MovimientoAtaque extends Movimiento{
    private int potencia;
    
    MovimientoAtaque(String nombreMov, Tipo tipo, int potencia){
        super(nombreMov, tipo);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }
    
}