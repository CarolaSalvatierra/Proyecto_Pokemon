package pokemon;

public abstract class Movimientos {
    protected String nombreMov;
    protected Tipo tipo;

    public Movimientos(String nombreMov, Tipo tipo){
        this.nombreMov = nombreMov;
        this.tipo = tipo;

    }

    public String getNombreMov() {
        return nombreMov;
    }

    public Tipo getTipo() {
        return tipo;
    }
    
}
