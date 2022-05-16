package pokemon;

import enumerado.Estado;
import enumerado.Tipo;

public abstract class MovimientoEstado extends Movimiento{

    private Estado estado;
    private int numeroTurnos;

    public MovimientoEstado(String nombreMov, Tipo tipo, Estado estado, int estamina, int numeroTurnos){
        super(nombreMov, tipo, estamina);
        this.estado = estado;
        this.numeroTurnos =  numeroTurnos;
    }


    public int getNumeroTurnos() {
        return numeroTurnos;
    }

    public Estado getEstado() {
        return estado;
    }

    /**
     * Método abstracto que heredarán los diferentes tipos de MovimientoEstado, que cambiará el
     * estado del pokemon afectado.
     * @param pokemon pokemon que será afectado por el estado.
     */
    public abstract void efectoEstado(Pokemon pokemon);

    
}
