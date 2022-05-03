package pokemon;

public class MovimientoAtaque extends Movimientos{
    private int potencia;
    
    MovimientoAtaque(int potencia){
        super(nombreMov, tipo);
        this.potencia = potencia;
    }

    @Override
    public String getNombreMov() {
        // TODO Auto-generated method stub
        return super.getNombreMov();
    }

    @Override
    public Tipo getTipo() {
        // TODO Auto-generated method stub
        return super.getTipo();
    }

    public int getPotencia() {
        return potencia;
    }
    
}