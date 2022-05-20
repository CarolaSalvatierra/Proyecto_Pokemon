package pokemon;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import enumerado.Estado;
import enumerado.Mejora;
import enumerado.Tipo;
import enumerado.TipoMovimiento;
import enumerado.Ventaja;

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
    private int numeroTurnosEstado;
    private Tipo[] tipo; //Máximo 2 tipos por pokemon
    private Movimiento[] movimientos; 
    private Ventaja ventaja;
    private Mejora mejora;
    private int numeroTurnosMejora;
    
    
    //TODO: poner todos los atributos y modificar el constructor

    public Pokemon(String nombre, String mote, int vitalidadMax, int ataque, int defensa, int ataqueS, int defensaS, int velocidad, int estaminaMax, int nivel, Tipo[] tipo,
    Movimiento[] movimientos){
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
        this.experiencia = 10 * nivel; //Experiencia necesaria para que un pokemon suba de nivel
        this.fertilidad = 5;
        this.estado = Estado.SIN_ESTADO;
        this.tipo = tipo;
        this.movimientos = movimientos;
        this.mejora = Mejora.SIN_MEJORA; 
        this.ventaja = Ventaja.SIN_VENTAJA;

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

    public Movimiento[] getMovimientos() {
        return movimientos;

    }

    public Mejora getMejora() {
        return mejora;
    }

    public int getNumeroTurnosEstado() {
        return numeroTurnosEstado;
    }

    public int getNumeroTurnosMejora() {
        return numeroTurnosMejora;
    }


    public void setMote(String mote) {
        this.mote = mote;
    }

    public void setVitalidad(float vitalidad) {
        this.vitalidad = (int) vitalidad;

        if (this.vitalidad <= 0){
            this.estado = Estado.KO;
        }
    }

    public void setEstamina(int estamina) {
        this.estamina = estamina;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setMejora(Mejora mejora){
        this.mejora = mejora;
    }

    //Métodos de acción


    /**
     * Método que, dependiendo de la mejora del movimiento usado, cambiará el parámetro Mejora de del mismo pokémon que lo use.
     * @param mv movimiento utilizado
     */
    public void mejorarPokemon(MovimientoMejora mv){
        if (mv.getEstamina() < this.estamina){
            System.out.println("No hay suficiente estamina para realizar el movimiento");
            return;

        } else {

            this.estamina -= mv.getEstamina();
            
            switch (mv.getMejora()){
                case ATAQUE:
                    this.mejora = Mejora.ATAQUE;
                    break;
                case ATAQUEES:
                    this.mejora = Mejora.ATAQUEES;
                    break;
                case DEFENSA:
                    this.mejora = Mejora.DEFENSA;
                    break;
                case DEFENSAES:
                    this.mejora = Mejora.DEFENSAES;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Método que, dependiendo del estado del movimiento usado, cambiará el parámetro Estado del pokémon rival.
     * @param mv movimiento utilizado
     * @param pokemon pokémon al que se le aplicará el estado.
     */
    public void aplicarEstado(MovimientoEstado mv, Pokemon pokemon){
        //Dependiendo del Estado del movimiento, llamará a una u otra clase.
        if (mv.getEstamina() < this.estamina){
            System.out.println("No hay suficiente estamina para realizar el movimiento");
            return;

        } else {

            this.estamina -= mv.getEstamina();

            switch (mv.getEstado()){
                case PARALIZADO:
                    ((MovimientoEstadoParalizado)mv).efectoEstado(pokemon);
                    break;
                case DORMIDO:
                    ((MovimientoEstadoDormido)mv).efectoEstado(pokemon);
                    break;
                case QUEMADO:
                    ((MovimientoEstadoDormido)mv).efectoEstado(pokemon);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Método que realizará una acción de disminución del parámetro vitalidad del pokémon rival. Si la habilidad a usar requiere una
     * cantidad superior a la actual, el ataque no podrá realizarse.
     * @param mv
     * @param pokemon
     */
    public void atacarPokemon(MovimientoAtaque mv, Pokemon pokemon){
        float efc = 1;
        float danio = 0;
        float estado = 0;
        int mejoraUsAt = 1;
        int mejoraUsAtS = 1;
        int mejoraPokDef = 1;
        int mejoraPokDS = 1;

        //Si la estamina del pokemon menos la estamina requerida por el movimiento es menor que 0, el pokemon no será
        //capaz de realizarlo.
        if (mv.getEstamina() > this.estamina){
            System.out.println("No hay suficiente estamina para realizar el movimiento");
            return;

        } else {

            this.estamina -= mv.getEstamina();

            comprobarVentaja(mv, pokemon);

            //Valor del operador efc de la fórmula final del daño.
             switch (this.ventaja){
                case EFECTIVO:
                    efc = 2f;
                    break;
                case NO_EFECTIVO:
                    efc = 0.5f;
                    break;
                default:
                    break;
             }

            //Valor del operador mejora para la potencia del usuario de la fórmula final del daño.
            switch (this.mejora){
                case ATAQUE:
                    mejoraUsAt = 2;
                    break;
                case ATAQUEES:
                    mejoraUsAtS = 2;
                    break;
                default:
                     break;
            }

            //Valor del operador mejora para la defensa del rival de la fórmula final del daño.
            switch (pokemon.getMejora()){
                case DEFENSA:
                    mejoraPokDef = 2;
                    break;
                case DEFENSAES:
                    mejoraPokDS = 2;
                    break;
                default:
                    break;
            }

            //Valor del daño que recibirá si tiene el estado Quemadura. Se sumará al llamar al método actualizarVitDamage.
            if (this.estado == Estado.QUEMADO){
                estado = (pokemon.getVitalidadMax() * 15) / 100;
            }

            //Si el movimiento es físico, la operación del daño usará la defensa del pokémon rival. Si es especial, la fórmula será 
            //con la defensa especial del pokémon rival.
            if (mv.getTMovimiento() == TipoMovimiento.FISICO){
                danio = ((mv.getPotencia() * mejoraUsAt ) * efc + this.ataque - (pokemon.getDefensa()  *  mejoraPokDef ));
            } else {
                danio = ((mv.getPotencia() * mejoraUsAtS ) * efc + this.ataqueS - (pokemon.getDefensaS()  *  mejoraPokDS));

            }


            actualizarVITDamage(danio + estado, pokemon);
        }
    }

    public void actualizarVITDamage(float danio, Pokemon pokemon){
        float actVIT = (int) pokemon.getVitalidad() - danio;

        setVitalidad(actVIT);

    }


    /**
     * Recupera toda su vitalidad y estamina, además de eliminar el estado que tuviese en ese momento.
     * @param pokemon pokemon que será recuperado por completo.
     */
    public void descansar(Pokemon pokemon){
        pokemon.setEstado(Estado.SIN_ESTADO);
        this.vitalidad = this.vitalidadMax;
        this.estamina = this.estaminaMax;
    }

    /**
     * Método que se utiliza para cambiar el parámetro this.experiencia. Recibe un int "experiencia", y esta se le restará a la 
     * experiencia actual del pokémon, mostrando la experiencia restante necesaria para subir de nivel. En el caso de que suba y la variable
     * sea negativa, significa que ha sobrado experiencia, por lo que se cambia a positivo y se repetirá el bucle para asimilar esta.
     * @param exp parámetro de experiencia obtenida en combate.
     * @param movimiento movimiento que aprenderá el pokémon solo si el nivel que acaba de subir es par.
     */
    public void subirNivel(int exp, Movimiento movimiento){
        boolean subirNivel = false; 
        do{
            System.out.println("Experiencia obtenida: " + exp);
            this.experiencia -= exp;
            if(this.experiencia <=0){
                System.out.println("¡Has subido un nivel!");
                Random rm= new Random();
                subirNivel = true; //Permite que el bucle se repita, por si hay experiencia que aún no ha asimilado el pokémon
                exp = -this.experiencia; //La experiencia está por debajo de 0, significa que ha sobrado, así que la igualo aquí y la cambio a positivo
                this.nivel ++;
                this.vitalidadMax += rm.nextInt(5) + 1;
                this.estaminaMax += rm.nextInt(5) + 1;
                this.ataque += rm.nextInt(5) + 1;
                this.defensa += rm.nextInt(5) + 1;
                this.ataqueS += rm.nextInt(5) + 1;
                this.defensaS += rm.nextInt(5) + 1;
                this.velocidad += rm.nextInt(5) + 1;
                this.experiencia = 10 * nivel;

                if (this.nivel % 2 == 0) {
                    aprenderAtaque(movimiento);
                }
                

            } else {

                //Si la exp obtenida no hace que la experiencia necesaria del pokemon para subir de nivel llege a 0 o menos,
                //el pokémon no sube de nivel, por consecuente el bucle se cierra.
                System.out.println("Experiencia necesaria: " + this.experiencia);
                subirNivel = false; 
                                    
            }
        }while (subirNivel == true);
    }

    /**
     * El pokémon aprende un movimiento. Si tiene los 4 huecos ocupados, sobreescribirá uno de ellos por el nuevo.
     * @param pokemon
     * @param movimiento
     */
    public void aprenderAtaque(Movimiento movimiento){
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i <= this.movimientos.length - 1; i++){
            if (this.movimientos[i] == null){
                this.movimientos[i] = movimiento;
                break;
            }
            
            //Si el contador llega a ser igual que el tamaño del array y no ha encontrado ninguna celda nula en el array, no se habrá forzado al bucle a 
            //romperse, por lo que se sustituirá un movimiento ya aprendido por el nuevo a aprender, según desee el usuario.
            if (i == this.movimientos.length - 1){
                System.out.println("Elige un movimiento que olvidar: \n1 " + this.movimientos[0].getNombreMov() + "\n2 " + this.movimientos[1].getNombreMov()
                + "\n3 " + this.movimientos[2].getNombreMov() + "\n4 " + this.movimientos[3].getNombreMov());
                int m = sc.nextInt();
                this.movimientos[m] = movimiento;
            }


        }
        sc.close();

        System.out.println("Nuevos movimientos: \n1 " + this.movimientos[0].getNombreMov() + "\n2 " + this.movimientos[1].getNombreMov()
                + "\n3 " + this.movimientos[2].getNombreMov() + "\n4 " + this.movimientos[3].getNombreMov());

    }

    public void comprobarVentaja(MovimientoAtaque mv, Pokemon pokemon){
        Map<Tipo, Map<Tipo, Ventaja>> comprobarV = new HashMap<Tipo, Map<Tipo, Ventaja>>();

        //Tipo Agua
        comprobarV.put(Tipo.AGUA, new HashMap<Tipo, Ventaja>(){{put(Tipo.AGUA, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.AGUA, new HashMap<Tipo, Ventaja>(){{put(Tipo.FUEGO, Ventaja.EFECTIVO);}});
        comprobarV.put(Tipo.AGUA, new HashMap<Tipo, Ventaja>(){{put(Tipo.PLANTA, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.AGUA, new HashMap<Tipo, Ventaja>(){{put(Tipo.BICHO, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.AGUA, new HashMap<Tipo, Ventaja>(){{put(Tipo.VOLADOR, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.AGUA, new HashMap<Tipo, Ventaja>(){{put(Tipo.ELECTRICO, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.AGUA, new HashMap<Tipo, Ventaja>(){{put(Tipo.TIERRA, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.AGUA, new HashMap<Tipo, Ventaja>(){{put(Tipo.NORMAL, Ventaja.SIN_VENTAJA);}});

        //Tipo Fuego
        comprobarV.put(Tipo.FUEGO, new HashMap<Tipo, Ventaja>(){{put(Tipo.AGUA, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.FUEGO, new HashMap<Tipo, Ventaja>(){{put(Tipo.FUEGO, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.FUEGO, new HashMap<Tipo, Ventaja>(){{put(Tipo.PLANTA, Ventaja.EFECTIVO);}});
        comprobarV.put(Tipo.FUEGO, new HashMap<Tipo, Ventaja>(){{put(Tipo.BICHO, Ventaja.EFECTIVO);}});
        comprobarV.put(Tipo.FUEGO, new HashMap<Tipo, Ventaja>(){{put(Tipo.VOLADOR, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.FUEGO, new HashMap<Tipo, Ventaja>(){{put(Tipo.ELECTRICO, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.FUEGO, new HashMap<Tipo, Ventaja>(){{put(Tipo.TIERRA, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.FUEGO, new HashMap<Tipo, Ventaja>(){{put(Tipo.NORMAL, Ventaja.SIN_VENTAJA);}});

        //Tipo Planta
        comprobarV.put(Tipo.PLANTA, new HashMap<Tipo, Ventaja>(){{put(Tipo.AGUA, Ventaja.EFECTIVO);}});
        comprobarV.put(Tipo.PLANTA, new HashMap<Tipo, Ventaja>(){{put(Tipo.FUEGO, Ventaja.EFECTIVO);}});
        comprobarV.put(Tipo.PLANTA, new HashMap<Tipo, Ventaja>(){{put(Tipo.PLANTA, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.PLANTA, new HashMap<Tipo, Ventaja>(){{put(Tipo.BICHO, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.PLANTA, new HashMap<Tipo, Ventaja>(){{put(Tipo.VOLADOR, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.PLANTA, new HashMap<Tipo, Ventaja>(){{put(Tipo.ELECTRICO, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.PLANTA, new HashMap<Tipo, Ventaja>(){{put(Tipo.TIERRA, Ventaja.EFECTIVO);}});
        comprobarV.put(Tipo.PLANTA, new HashMap<Tipo, Ventaja>(){{put(Tipo.NORMAL, Ventaja.NO_EFECTIVO);}});

        //Tipo Bicho
        comprobarV.put(Tipo.BICHO, new HashMap<Tipo, Ventaja>(){{put(Tipo.AGUA, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.BICHO, new HashMap<Tipo, Ventaja>(){{put(Tipo.FUEGO, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.BICHO, new HashMap<Tipo, Ventaja>(){{put(Tipo.PLANTA, Ventaja.EFECTIVO);}});
        comprobarV.put(Tipo.BICHO, new HashMap<Tipo, Ventaja>(){{put(Tipo.BICHO, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.BICHO, new HashMap<Tipo, Ventaja>(){{put(Tipo.VOLADOR, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.BICHO, new HashMap<Tipo, Ventaja>(){{put(Tipo.ELECTRICO, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.BICHO, new HashMap<Tipo, Ventaja>(){{put(Tipo.TIERRA, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.BICHO, new HashMap<Tipo, Ventaja>(){{put(Tipo.NORMAL, Ventaja.SIN_VENTAJA);}});

        //Tipo Volador
        comprobarV.put(Tipo.VOLADOR, new HashMap<Tipo, Ventaja>(){{put(Tipo.AGUA, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.VOLADOR, new HashMap<Tipo, Ventaja>(){{put(Tipo.FUEGO, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.VOLADOR, new HashMap<Tipo, Ventaja>(){{put(Tipo.PLANTA, Ventaja.EFECTIVO);}});
        comprobarV.put(Tipo.VOLADOR, new HashMap<Tipo, Ventaja>(){{put(Tipo.BICHO, Ventaja.EFECTIVO);}});
        comprobarV.put(Tipo.VOLADOR, new HashMap<Tipo, Ventaja>(){{put(Tipo.VOLADOR, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.VOLADOR, new HashMap<Tipo, Ventaja>(){{put(Tipo.ELECTRICO, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.VOLADOR, new HashMap<Tipo, Ventaja>(){{put(Tipo.TIERRA, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.VOLADOR, new HashMap<Tipo, Ventaja>(){{put(Tipo.NORMAL, Ventaja.SIN_VENTAJA);}});
        
        //Tipo Electrico
        comprobarV.put(Tipo.ELECTRICO, new HashMap<Tipo, Ventaja>(){{put(Tipo.AGUA, Ventaja.EFECTIVO);}});
        comprobarV.put(Tipo.ELECTRICO, new HashMap<Tipo, Ventaja>(){{put(Tipo.FUEGO, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.ELECTRICO, new HashMap<Tipo, Ventaja>(){{put(Tipo.PLANTA, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.ELECTRICO, new HashMap<Tipo, Ventaja>(){{put(Tipo.BICHO, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.ELECTRICO, new HashMap<Tipo, Ventaja>(){{put(Tipo.VOLADOR, Ventaja.EFECTIVO);}});
        comprobarV.put(Tipo.ELECTRICO, new HashMap<Tipo, Ventaja>(){{put(Tipo.ELECTRICO, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.ELECTRICO, new HashMap<Tipo, Ventaja>(){{put(Tipo.TIERRA, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.ELECTRICO, new HashMap<Tipo, Ventaja>(){{put(Tipo.NORMAL, Ventaja.SIN_VENTAJA);}});

        //Tipo Tierra
        comprobarV.put(Tipo.TIERRA, new HashMap<Tipo, Ventaja>(){{put(Tipo.AGUA, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.TIERRA, new HashMap<Tipo, Ventaja>(){{put(Tipo.FUEGO, Ventaja.EFECTIVO);}});
        comprobarV.put(Tipo.TIERRA, new HashMap<Tipo, Ventaja>(){{put(Tipo.PLANTA, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.TIERRA, new HashMap<Tipo, Ventaja>(){{put(Tipo.BICHO, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.TIERRA, new HashMap<Tipo, Ventaja>(){{put(Tipo.VOLADOR, Ventaja.NO_EFECTIVO);}});
        comprobarV.put(Tipo.TIERRA, new HashMap<Tipo, Ventaja>(){{put(Tipo.ELECTRICO, Ventaja.EFECTIVO);}});
        comprobarV.put(Tipo.TIERRA, new HashMap<Tipo, Ventaja>(){{put(Tipo.TIERRA, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.TIERRA, new HashMap<Tipo, Ventaja>(){{put(Tipo.NORMAL, Ventaja.SIN_VENTAJA);}});

        //Tipo Normal
        comprobarV.put(Tipo.NORMAL, new HashMap<Tipo, Ventaja>(){{put(Tipo.AGUA, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.NORMAL, new HashMap<Tipo, Ventaja>(){{put(Tipo.FUEGO, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.NORMAL, new HashMap<Tipo, Ventaja>(){{put(Tipo.PLANTA, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.NORMAL, new HashMap<Tipo, Ventaja>(){{put(Tipo.BICHO, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.NORMAL, new HashMap<Tipo, Ventaja>(){{put(Tipo.VOLADOR, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.NORMAL, new HashMap<Tipo, Ventaja>(){{put(Tipo.ELECTRICO, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.NORMAL, new HashMap<Tipo, Ventaja>(){{put(Tipo.TIERRA, Ventaja.SIN_VENTAJA);}});
        comprobarV.put(Tipo.NORMAL, new HashMap<Tipo, Ventaja>(){{put(Tipo.NORMAL, Ventaja.SIN_VENTAJA);}});

        System.out.println(comprobarV.get(mv.getTipo()).get(pokemon.getTipo()[0])); 



        
    }

}
