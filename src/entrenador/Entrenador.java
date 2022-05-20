package entrenador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pokemon.Pokemon;

public class Entrenador {

    // Atributos
    private String nombreE;
    private int cont = 0;
    private int pokedolars;
    private List<Pokemon> equipo1;// Equipo principal
    private List<Pokemon> equipo2;// Equipo secundario
    // cont =0 primera posicion le metemos un new pokemon q se gerera en el
    // Constructor de pokémon constructor con el nivel q tenga
    /**
     * Constructor del entrenador que recibe un nombre y dos arrayList de pokémon
     * @param nombreE
     * @param equipo1
     * @param equipo2
     */
    public Entrenador(String nombreE, ArrayList<Pokemon> equipo1, ArrayList<Pokemon> equipo2) {
        this.nombreE = nombreE;
        this.equipo1 = new ArrayList<Pokemon>();
        this.equipo2 = new ArrayList<Pokemon>();
        cont++; // para que vaya poniendo los pokemon en las posiciones de los equipos
        // this.pokedolars = pokedolars;//Esto es necesario?
    }

    public String getNombreE() {
        return nombreE;
    }

    public int getCont() {
        return cont;
    }

    public int getPokedolars() {
        return pokedolars;
    }

    public List<Pokemon> getEquipo1() {
        return equipo1;
    }

    public List<Pokemon> getEquipo2() {
        return equipo2;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public void setEquipo1(List<Pokemon> equipo1) {
        this.equipo1 = equipo1;
    }

    public void setEquipo2(List<Pokemon> equipo2) {
        this.equipo2 = equipo2;
    }

    // Metodos de acción
    public void agregarPokemo(Pokemon pokemon) {
        equipo1.add(pokemon);
    }

    /* Metodo para mover pokemon al equipo secundario */
    /**
     * En este método movemos un pokémon al equipo secundario, primero tenemos que
     * comprobar que en el
     * equipo principal por lo menos hayan 2 pokémon, si es posible hacer el
     * movimiento quitamos un pokémon
     * del equipo principal para pasarlo al secundario
     * 
     * @param pokemon
     * @return
     */
    public String moverPokemonE2(Pokemon pokemon) {

        String mensaje = "";
        if (this.equipo1.size() < 2) {
            mensaje = "No puedes mover un pokemon";
        } else if (this.equipo1.size() > 2) {
            this.equipo2.add(pokemon);
            this.equipo1.remove(pokemon);
            mensaje = "Has movido un poquemon";
        }
        return mensaje;
    }

    /**
     * Metodo para mover al pokémon del equipo secundario al principal, teniendo
     * encuenta que en el equipo
     * principla exista un espacio para hacer este movimiento. si se consique hacer
     * este movimiento se quita
     * un pokémon del equipo 2.
     * 
     * @param pokemon
     * @return
     */
    public String moverPokemonE1(Pokemon pokemon) {
        String mensaje = "";
        if (this.equipo1.size() == 4) {
            mensaje = "El equipo esta completo, no puedes mover a un pokemon";
            return mensaje;
        } else if (this.equipo1.size() < 4) {
            this.equipo2.remove(pokemon);
            mensaje = "Has movido un pokemon";
            return mensaje;
        }
        return mensaje;
    }

    // Se elige a un pokemon del equipo1 en funcion del indice recibido (i) y se
    // devuelve, si el indice no se encuentra en el arrayList se devuelve null
    public Object elegir(int i) {

        if (i < cont) { // Cont es el lugar donde a partir de ahi esta vacio el array
            this.getEquipo1().get(1);
            return equipo1.size();
        } else {
            return null;
        }
    }

    /**
     * Método para capturar un pokémon, teniendo 2/3 de probabilidades de captura.
     * Si en 10 intentos no se captura,
     * se rompe el bucle y la captura finaliza.
     * 
     * @param pokemon variable de tipo Pokemon que será el pokémon de nivel 1 con
     *                estadísticas aleatorias.
     */
    public void captura(Pokemon pokemon) {
        int pokeball = 10;
        Random rm = new Random();
        int posibilidadCap;

        for (int i = 0; i < pokeball; i++) {
            posibilidadCap = rm.nextInt(3) + 1;
            if (posibilidadCap == 2) {
                this.equipo2.add(pokemon);
                break;
            } else {
                System.out.println("¡" + pokemon.getNombre() + " se ha liberado!");
            }
        }

    }

}
