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
    private Estado estado;
    private Tipo tipo;
    /*Hasta que no se creen las clases, no se pueden añadir estas
    variables a la clase Pokemon. Añadirlas una vez creadas.

    private Mejora mejora; 
    private Objeto objeto;

    */
    
    //TODO: poner todos los atributos y modificar el constructor

    public Pokemon(String nombre, String mote, int vitalidad, int ataque, int defensa, int ataqueS, int defensaS, int velocidad, int estamina, int nivel){
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
    }
}