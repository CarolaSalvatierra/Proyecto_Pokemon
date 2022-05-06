package pokemon;

import Enum.Tipo;

public class Movimiento {
    protected static String nombreMov;
    protected static Tipo tipo;

    public Movimiento(String nombreMov, Tipo tipo){
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
