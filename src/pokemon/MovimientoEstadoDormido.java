package pokemon;

import enumerado.Estado;
import enumerado.Tipo;

public class MovimientoEstadoDormido extends MovimientoEstado{

    MovimientoEstadoDormido(String nombreMov, Tipo tipo, Estado estado, int estamina, int numeroTurnos){
        super(nombreMov, tipo, estado, estamina, numeroTurnos);

    }

    @Override
    public void efectoEstado(Pokemon pokemon) {
        pokemon.setEstado(Estado.DORMIDO);
    }

    
}
