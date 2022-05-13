package pokemon;

import Enum.Tipo;
import Enum.Mejora;

public class MovimientoMejoraAtaque extends MovimientoMejora{

    public MovimientoMejoraAtaque(String nombreMov, Tipo tipo, int estamina, Mejora mejora, int numeroTurnos){
        super(nombreMov, tipo, estamina, mejora, numeroTurnos);

    }

    @Override
    public void efectoMejora(Pokemon pokemon) {
        pokemon.setMejora(Mejora.ATAQUE);
        
    }

}