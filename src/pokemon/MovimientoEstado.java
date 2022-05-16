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

    public abstract void efectoEstado(Pokemon pokemon);

    
}
