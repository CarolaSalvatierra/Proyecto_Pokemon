package controladores;

public class InicioJuegoController {
    //Aquí copio el codigo completo del anterior proyecto y lo mantengo comentado 
    //porque al importar la clase  FXML deja de ejecutar cualquiera de las otras clases
    /*
    public class InicioJuegoController implements Initializable {
     // poner en
     @FXML
     private Button btnCombate;

     @FXML
     private Button btnEquipo;

     @FXML
     private Button btnCaptura;

     @FXML
     private void combatir(ActionEvent event) {
          // Parent inicioJuego =  FXMLLoader.load(getClass().getResource("../vistas/inicioJuego.fxml"));
          Tipo[] tipos = { Tipo.AGUA };
          MovimientoAtaque mA = new MovimientoAtaque("Placaje", Tipo.NORMAL, TipoMovimiento.FISICO, 20, 55);

          MovimientoAtaque mA2 = new MovimientoAtaque("Burbuja", Tipo.AGUA, TipoMovimiento.ESPECIAL, 25, 10);
          Movimiento[] movimientos = new Movimiento[4];
          movimientos[0] = mA;
          movimientos[1] = mA2;

          Pokemon n1 = new Pokemon("Prueba", "Prrueba", 80, 20, 30, 25, 15, 15, 50,
                    1, tipos, movimientos);
          Pokemon n2 = new Pokemon("Prueba2", "Prrueba2", 10, 30, 30, 25, 15, 15, 50,
                    1, tipos, movimientos);
          // Entrenador
          Entrenador jugador = new Entrenador("XXX", new ArrayList<Pokemon>(), new ArrayList<Pokemon>());
          Entrenador rival = new Entrenador("YYY", new ArrayList<Pokemon>(), new ArrayList<Pokemon>());
          jugador.getEquipo1().add(n1);
          jugador.getEquipo1().add(n2);

        //  jugador.combatir();

          System.out.println(" Comienza la batalla");

     }

     @FXML
     private void verEquipo(ActionEvent event) {
          // Parent inicioJuego = FXMLLoader.load(getClass().getResource("../vistas/inicioJuego.fxml"));
          
          public Object elegir(int i){

          if(i < cont){ //Cont es el lugar donde a partir de ahi esta vacio el array
           this.getEquipo1().get(1);
			return equipo1.size();
		}
		else{
			return null;
		}
    }

          System.out.println(" Selecionamos equipo");
     }

     @FXML
     private void capturar(ActionEvent event) {
          // Parent capturaVie = FXMLLoader.load(getClass().getResource("./vistas/inicioJuego.fxml"));
          // FXMLLoader.load(getClass().getResource("./vistas/inicioJuego.fxml"));
          public void captura(Pokemon pokemon) {
        int pokeball = 10;
        Random rm = new Random();
        int posibilidadCap;

        for (int i = 0; i < pokeball; i++){
            posibilidadCap = rm.nextInt(3)+1;
            if (posibilidadCap == 2){
                this.equipo2.add(pokemon);
                break;
            } else {
                System.out.println("¡" + pokemon.getNombre() + " se ha liberado!");
            }
        }
        
	}
          System.out.println(" Capturamos Pokemon");
     }

     @Override
     public void initialize(URL arg0, ResourceBundle resources) {

     }

    */ 
    
}
