package entrenador;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import pokemon.Pokemon;

public class Entrenador {
    
    //Atributos
    private String nombreE;
    private int cont =0;
    private int pokedolars;
    private List<Pokemon>equipo1;//Equipo principal
    private List<Pokemon> equipo2;//Equipo secundario
    // cont =0 primera posicion le metemos un new pokemon q se gerera en el Constructor de p9okemon
	// constructor con el nivel q tenga
   
    public Entrenador(String nombreE, ArrayList<Pokemon>equipo1, ArrayList<Pokemon>equipo2){
        this.nombreE = nombreE;
        this.equipo1 = new ArrayList<Pokemon>();
        this.equipo2 = new ArrayList<Pokemon>();
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
    public String moverPokemonE2(Pokemon pokemon){
      
       String mensaje = "";
        if(this.equipo1.size() < 2 ){
            mensaje = "No puedes mover un pokemon";           
        }
        else if(this.equipo1.size() > 2){
            this.equipo2.add(pokemon);
            this.equipo1.remove(pokemon);
            mensaje = "Has movido un poquemon";     
           }
        return mensaje;
    }
    //Metodo para movel al pokemon del equipo secundario al principal
    public String moverPokemonE1(Pokemon pokemon){
        String mensaje = "";
        if(this.equipo1.size() == 4){
            mensaje = "El equipo esta completo, no puedes mover a un pokemon";
            return mensaje;
        }
        else if(this.equipo1.size() < 4){
            this.equipo2.remove(pokemon);
            mensaje = "Has movido un pokemon";
            return mensaje;
        }
        return mensaje;
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
	// devuelve un boolean confirmando si lo ha capturado o no y solo lo capturara si existe
	// hueco en el equipo ?? Equipo 1 o 2, en cual metemos a los capturados??
    //No se como hacer lo de la ventana con un boton para capturar de manera aleatoria
	public boolean captura(Pokemon enemigo) {
        Random aleatorio = new Random();
        int numero;
        boolean capturado = false;
        for(int contador = 0; contador < 4;contador ++){
            numero = aleatorio.nextInt(3);
		if (enemigo.getVitalidad() <= 20) {// Esto es inventado, si la vida del enemigo es menor o igual q 20 lo capturamos
               equipo2.add(enemigo); // Metemos al enemigo
                capturado = true;

				System.out.println("Has capturado un nuevo Pokemon!");
		} else {
			System.out.println("Imposible de capturar.");
		}
    }
		return capturado;//nos devuelve true si lo hemos capturado, false si No 
	}
/*    //Metodo que muestra los pokemon que tenemos en el equipo junto con sus caracteristicas
	public void mostrarEquipos(){
		System.out.println("Tienes: "+cont+" Pokémon en el Equipo 1 ");
        for(int i = 0; i < cont; i++){
        System.out.println("Nº: "+i+" Nivel: "+equipo1.addAll(e).getNivel()+" Vida: "+equipo1[i].getVitalidad());
        }
		
        System.out.println("Tienes: "+cont+" Pokémon en el Equipo 2 ");
		for(int i = 0; i < cont; i++){
			System.out.println("Nº: "+i+" Nivel: "+equipo2[i].getNivel()+" Vida: "+equipo2[i].getVitalidad());
		}
	}*/

   

    
}
