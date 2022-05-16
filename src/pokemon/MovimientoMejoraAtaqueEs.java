package pokemon;

import enumerado.Mejora;
import enumerado.Tipo;

public class MovimientoMejoraAtaqueEs extends MovimientoMejora{

    public MovimientoMejoraAtaqueEs(String nombreMov, Tipo tipo, int estamina, Mejora mejora, int numeroTurnos){
        super(nombreMov, tipo, estamina, mejora, numeroTurnos);

    }

    @Override
    public void efectoMejora(Pokemon pokemon) {
        pokemon.setMejora(Mejora.ATAQUEES);
        
    }
    
}
