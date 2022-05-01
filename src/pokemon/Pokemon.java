package pokemon;


public class Pokemon {

    //Atributos de la clase Pokemon

    private String nombre;
    private String mote;
    private int vitalidad;
    private int ataque;
    private int defensa;
    private int ataqueS; //Ataque Especial
    private int defensaS; //Defensa Especial
    private int velocidad;
    private int estamina;
    private int nivel;
    private int experiencia;
    private int fertilidad;
    private Estado estado;
    private Tipo[] tipo; //Máximo 2 tipos por pokemon
    /*Hasta que no se creen las clases, no se pueden añadir estas
    variables a la clase Pokemon. Añadirlas una vez creadas.

    private Mejora mejora; 
    private Movimiento[] movimientos;

    */
    
    //TODO: poner todos los atributos y modificar el constructor

    public Pokemon(String nombre, String mote, int vitalidad, int ataque, int defensa, int ataqueS, int defensaS, int velocidad, int estamina, int nivel, Tipo[] tipo){
        this.nombre = nombre;
        this.mote= mote;
        this.nivel = nivel;
        this.vitalidad= vitalidad;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueS = ataqueS;
        this.defensaS= defensaS;
        this.velocidad= velocidad;
        this.estamina= estamina;
        experiencia = 10 * nivel; //Experiencia necesaria para que un pokemon suba de nivel.
        this.fertilidad = 5;
        this.estado = Estado.SIN_ESTADO;
        this.tipo = tipo;

    }

    //Métodos get y set

    public String getNombre() {
        return nombre;
    }
    
    public String getMote() {
        return mote;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAtaqueS() {
        return ataqueS;
    }

    public int getDefensaS() {
        return defensaS;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getEstamina() {
        return estamina;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getFertilidad() {
        return fertilidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public Tipo[] getTipo() {
        return tipo;
    }

    /*
    public Mejora getMejora() {
        return mejora;
    }

    public Movimiento[] getMovimientos() {
        return movimientos;
    }
    */

    public void setMote(String mote) {
        this.mote = mote;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /*public void setMejora(Mejora mejora){
        this.mejora = mejora;
    }
    */

    //Métodos de acción

    public void atacarPokemon(Pokemon pokemon){
        
    }
}