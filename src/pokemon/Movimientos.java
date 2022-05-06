package pokemon;

import Enum.Tipo;

public class Movimientos {
    protected static String nombreMov;
    protected static Tipo tipo;

    public Movimientos(String nombreMov, Tipo tipo){
        Movimiento.nombreMov = nombreMov;
        Movimiento.tipo = tipo;

    }

    public String getNombreMov() {
        return nombreMov;
    }

    public Tipo getTipo() {
        return tipo;
    }
    
}
