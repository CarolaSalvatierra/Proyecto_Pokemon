package pokemon;

import enumerado.Mejora;
import enumerado.Tipo;

public class MovimientoMejoraDefensa extends MovimientoMejora{

    public MovimientoMejoraDefensa(String nombreMov, Tipo tipo, int estamina, Mejora mejora, int numeroTurnos){
        super(nombreMov, tipo, estamina, mejora, numeroTurnos);

    }

    @Override
    public void efectoMejora(Pokemon pokemon) {
        pokemon.setMejora(Mejora.DEFENSA);
        
    }
    
}
