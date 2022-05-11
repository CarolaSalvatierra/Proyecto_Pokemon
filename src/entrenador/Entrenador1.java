package entrenador;

import pokemon.Pokemon;

public class Entrenador1 {

    //Atributos
    private String nombreE;
    private int cont =0;
    private int pokedolars;
    private Pokemon[]equipo1;//Equipo principal
    private Pokemon[] equipo2;//Equipo secundario
    // cont =0 primera posicion le metemos un new pokemon q se gerera en el Constructor de p9okemon
	// constructor con el nivel q tenga
    //cont=0 le ponemos el 1er pokemon 
    public Entrenador1(String nombreE){
        this.nombreE = nombreE;
        this.equipo1 = new Pokemon[4];
        this.equipo2 = new Pokemon[30];
    //  this.pokedolars = pokedolars;//Esto es necesario?
        cont++; //para que vaya poniendo los pokemon en las posiciones de los equipos
        
    }
    public Entrenador1(String nombreE2, Object equipo12) {
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
  
    public Pokemon[] getEquipo1() {
        return equipo1;
    }
    public Pokemon[] getEquipo2() {
        return equipo2;
    }
    //Metodos de acción
    // Se elige a un pokemon del equipo1 en funcion del indice recibido (i) y se
	// devuelve, si el indice no se encuentra en el vector se devuelve null
    public Pokemon elegir(int i){
        if(i < cont){ //Cont es el lugar donde a partir de ahi esta vacio el array
			return equipo1[i];
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
                equipo2[cont] = enemigo; // Metemos al enemigo
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
