package pokemon;

import enumerado.Tipo;

public abstract class Movimiento {
    protected static String nombreMov;
    protected static Tipo tipo;
    protected static int estamina;

    public Movimiento(String nombreMov, Tipo tipo, int estamina){
        Movimiento.nombreMov = nombreMov;
        Movimiento.tipo = tipo;
        Movimiento.estamina = estamina;

    }

    public int getEstamina() {
        return estamina;
    }

    public String getNombreMov() {
        return nombreMov;
    }

    public Tipo getTipo() {
        return tipo;
    }
    
}
