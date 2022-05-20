package pokemon;

import enumerado.Tipo;

public abstract class Movimiento {
    protected String nombreMov;
    protected Tipo tipo;
    protected int estamina;

    public Movimiento(String nombreMov, Tipo tipo, int estamina){
        this.nombreMov = nombreMov;
        this.tipo = tipo;
        this.estamina = estamina;

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
