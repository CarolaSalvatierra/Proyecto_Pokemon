package pokemon;

import enumerado.Mejora;
import enumerado.Tipo;

public class MovimientoMejora extends Movimiento{

    private Mejora mejora;
    private int numeroTurnos;

    public MovimientoMejora(String nombreMov, Tipo tipo, int estamina, Mejora mejora, int numeroTurnos){
        super(nombreMov, tipo, estamina);
        this.mejora = mejora;
        this.numeroTurnos = numeroTurnos;

    }


    public Mejora getMejora() {
        return mejora;
    }

    public int getNumeroTurnos() {
        return numeroTurnos;
    }
    
}
