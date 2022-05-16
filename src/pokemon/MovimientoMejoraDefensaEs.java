package pokemon;

import enumerado.Mejora;
import enumerado.Tipo;

public class MovimientoMejoraDefensaEs extends MovimientoMejora{

    public MovimientoMejoraDefensaEs(String nombreMov, Tipo tipo, int estamina, Mejora mejora, int numeroTurnos){
        super(nombreMov, tipo, estamina, mejora, numeroTurnos);

    }

    @Override
    public void efectoMejora(Pokemon pokemon) {
        pokemon.setMejora(Mejora.DEFENSAES);
    }
    
}
