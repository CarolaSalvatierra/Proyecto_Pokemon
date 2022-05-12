package entrenador;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pokemon.Pokemon;

public class Entrenador1 {

    //Atributos
    private String nombreE;
    private int cont =0;
    private int pokedolars;
    private List<Pokemon>equipo1;//Equipo principal
    private List<Pokemon> equipo2;//Equipo secundario
    // cont =0 primera posicion le metemos un new pokemon q se gerera en el Constructor de p9okemon
	// constructor con el nivel q tenga
    //cont=0 le ponemos el 1er pokemon 
    public Entrenador1(String nombreE, ArrayList<Pokemon>equipo1, ArrayList<Pokemon>equipo2){
        this.nombreE = nombreE;
        this.equipo1 = new LinkedList<Pokemon>();
        this.equipo2 = new LinkedList<Pokemon>();
    //  this.pokedolars = pokedolars;//Esto es necesario?
        cont++; //para que vaya poniendo los pokemon en las posiciones de los equipos
        
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
    //Metodos de acción
    public void agregarPokemo(Pokemon pokemon){
        equipo1.add(pokemon);
    }
    /*Metodo para mover pokemon al equipo secundario */
    public boolean moverPokemonE2(Pokemon pokemon){
        boolean movido = false;
        if(this.equipo1.size() < 2 ){
            System.out.println("No puedes mover un pokemon");
            return false;
        }
        else if(this.equipo1.size() > 2){
            this.equipo1.remove(1);
            System.out.println("Has movido un poquemon");
            return true;
        }
        return true;
    }
    //Metodo para movel al pokemon del equipo secundario al principal
    public boolean moverPokemonE1(Pokemon pokemon){
        boolean movido = false;
        if(this.equipo1.size() == 4){
            System.out.println("El equipo esta completo, no puedes mover a un pokemon");
            return false;
        }
        else if(this.equipo1.size()< 4){
            this.equipo2.remove(1);
            System.out.println("Has movido un pokemon");
            return true;
        }
        return true;
    }
    // Se elige a un pokemon del equipo1 en funcion del indice recibido (i) y se
	// devuelve, si el indice no se encuentra en el vector se devuelve null
    public Object elegir(int i){
        if(i < cont){ //Cont es el lugar donde a partir de ahi esta vacio el array
			return equipo1.size();
		}
		else{
			return null;
		}
    }
    // Metodo que se llama cuando un entrenador trata de capturar a un pokemon,
	// devuelve un booleano confirmando si lo ha capturado o no y solo lo capturara si existe
	// hueco en el equipo ?? Equipo 1 o 2, en cual metemos a los capturados??
    //No se como hacer lo de la ventana con un boton para capturar de manera aleatoria
	public boolean captura(Pokemon enemigo) {
        
        boolean capturado = false;

		if (enemigo.getVitalidad() <= 20) {// Esto es inventado, si la vida del enemigo es menor o igual q 20 lo capturamos
                equipo2.size(); = enemigo; // Metemos al enemigo
				capturado = true;
				cont++;

				System.out.println("Has capturado un nuevo Pokemon!");
		} else {
			System.out.println("Imposible de capturar.");
		}
		return capturado;//nos devuelve true si lo hemos capturado, false si No 
	}
    //Metodo que muestra los pokemon que tenemos en el equipo junto con sus caracteristicas
	public void mostrarEquipos(){
		System.out.println("Tienes: "+cont+" Pokémon en el Equipo 1 ");
        for(int i = 0; i < cont; i++){
        System.out.println("Nº: "+i+" Nivel: "+equipo1[i].getNivel()+" Vida: "+equipo1[i].getVitalidad());
        }
		
        System.out.println("Tienes: "+cont+" Pokémon en el Equipo 2 ");
		for(int i = 0; i < cont; i++){
			System.out.println("Nº: "+i+" Nivel: "+equipo2[i].getNivel()+" Vida: "+equipo2[i].getVitalidad());
		}
	}

   

    
    
}
