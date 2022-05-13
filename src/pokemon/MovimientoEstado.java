package pokemon;

import Enum.Estado;
import Enum.Tipo;

public class MovimientoEstado extends Movimiento{

    private Estado estado;

    public MovimientoEstado(String nombreMov, Tipo tipo, Estado estado, int estamina){
        super(nombreMov, tipo, estamina);
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    
}
