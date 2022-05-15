package pokemon;

import Enum.Tipo;
import Enum.Estado;

public class MovimientoEstadoParalizado extends MovimientoEstado{

    MovimientoEstadoParalizado(String nombreMov, Tipo tipo, Estado estado, int estamina, int numeroTurnos){
        super(nombreMov, tipo, estado, estamina, numeroTurnos);

    }

    @Override
    public void efectoEstado(Pokemon pokemon) {
        pokemon.setEstado(Estado.PARALIZADO); 
    }
    
}
