package pokemon;

import Enum.Tipo;
import Enum.Mejora;

public abstract class MovimientoMejora extends Movimiento{

    private Mejora mejora;

    public MovimientoMejora(String nombreMov, Tipo tipo, int estamina, Mejora mejora, int numeroTurnos){
        super(nombreMov, tipo, estamina);
        this.mejora = mejora;

    }

    public Mejora getMejora() {
        return mejora;
    }

    public abstract void efectoMejora(Pokemon pokemon);
    
}
