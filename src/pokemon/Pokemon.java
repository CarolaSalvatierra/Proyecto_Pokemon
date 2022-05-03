package pokemon;

import java.util.Random;

public class Pokemon {

    //Atributos de la clase Pokemon

    private String nombre;
    private String mote;
    private int vitalidadMax; //Vitalidad límite que puede tener el pokémon
    private int vitalidad; //Vitalidad actual del pokémon.
    private int ataque;
    private int defensa;
    private int ataqueS; //Ataque Especial
    private int defensaS; //Defensa Especial
    private int velocidad;
    private int estaminaMax; //Estamina límite que puede tener el pokémon
    private int estamina; //Estamina actual del pokémon.
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

    public Pokemon(String nombre, String mote, int vitalidadMax, int ataque, int defensa, int ataqueS, int defensaS, int velocidad, int estaminaMax, int nivel, Tipo[] tipo){
        this.nombre = nombre;
        this.mote= mote;
        this.nivel = nivel;
        this.vitalidadMax= vitalidadMax;
        this.vitalidad = this.vitalidadMax; //La vitalidad actual será igual a la máxima
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueS = ataqueS;
        this.defensaS= defensaS;
        this.velocidad= velocidad;
        this.estaminaMax= estaminaMax;
        this.estamina= this.estaminaMax; //La estamina actual será igual a la máxima
        experiencia = 10 * nivel; //Experiencia necesaria para que un pokemon suba de nivel
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


    public int getVitalidadMax() {
        return vitalidadMax;
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

    public int getEstaminaMax() {
        return estaminaMax;
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

    //Recupera toda su vitalidad y estamina, además de eliminar el estado que tuviese en ese momento.
    public void descansar(Pokemon pokemon){
        pokemon.setEstado(Estado.SIN_ESTADO);
        this.vitalidad = this.vitalidadMax;
        this.estamina= this.estaminaMax;
    }

    //Creo que esto podría hacerse de una forma más eficiente pero ahora mismo no tengo ni idea.
    public void subirNivel(int exp){
        boolean subirNivel = false; 
        do{
            this.experiencia -= exp;
            if(this.experiencia <=0){
                Random rm= new Random();
                subirNivel = true; //Permite que el bucle se repita, por si hay experiencia que aún no ha asimilado el pokémon
                exp = -this.experiencia; //Si la experiencia está por debajo de 0, significa que ha sobrado, así que la igualo aquí y la cambio a positivo
                this.nivel += 1;
                this.vitalidadMax += rm.nextInt(5) + 1;
                this.estaminaMax += rm.nextInt(5) + 1;
                this.ataque += rm.nextInt(5) + 1;
                this.defensa += rm.nextInt(5) + 1;
                this.ataqueS += rm.nextInt(5) + 1;
                this.defensaS += rm.nextInt(5) + 1;
                this.velocidad += rm.nextInt(5) + 1;
                this.experiencia = 10 * nivel;
                

            } else {

                //Si la exp obtenida no hace que la experiencia necesaria del pokemon para subir de nivel llege a 0 o menos,
                //el pokémon no sube de nivel, por consecuente el bucle se cierra.
                subirNivel = false; 
                                    
            }
        }while (subirNivel == true);
    }

    //public void aprenderAtaque(Pokemon pokemon, Movimiento movimiento);

    
    /*Este método no sé si ponerlo en la clase Pokemon o en la clase combate:

        public void comprobarVentaja(Pokemon pokemon1, Pokemon pokemon2);

    */
}