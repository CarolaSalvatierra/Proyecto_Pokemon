package pokemon;

import enumerado.Mejora;
import enumerado.Tipo;

public abstract class MovimientoMejora extends Movimiento{

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

     /**
     * Método abstracto que heredarán los diferentes tipos de MovimientoMejora, que cambiará el
     * estado del pokemon afectado.
     * @param pokemon pokemon que será afectado por el estado.
     */
    public abstract void efectoMejora(Pokemon pokemon);
    
}
