package pokemon;

public class Movimientos {
    protected static String nombreMov;
    protected static Tipo tipo;

    public Movimientos(String nombreMov, Tipo tipo){
        Movimientos.nombreMov = nombreMov;
        Movimientos.tipo = tipo;

    }

    public String getNombreMov() {
        return nombreMov;
    }

    public Tipo getTipo() {
        return tipo;
    }
    
}
