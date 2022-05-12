package pokemon;

import java.io.IOException;

import Enum.Tipo;
import Enum.Tipo_Movimiento;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;


public class Main2 extends Application {
    public static void main(String[] args) {
        Tipo[] tipos = {Tipo.AGUA};
        MovimientoAtaque mA = new MovimientoAtaque("Placaje", Tipo.NORMAL, Tipo_Movimiento.FISICO, 20, 55);
       /* 
        MovimientoAtaque mA2 = new MovimientoAtaque("Burbuja", Tipo.AGUA, Tipo_Movimiento.ESPECIAL, 25, 10);
        Movimiento[] movimientos= new Movimiento[4];
        movimientos[0] = mA;
        movimientos[1] = mA2;
        */
        Movimiento[] movimientos= new Movimiento[]{mA};
        Pokemon n1 = new Pokemon("Prueba", "Prrueba", 80, 20, 30, 25, 15, 15, 50,
        1, tipos, movimientos);

        System.out.println(n1.getExperiencia());

        n1.subirNivel(5);

        //llama al metodo launch, metodo de java FX q sirve para lanzar las aplicaciones de java FX
        launch(args);


    }
    //Star
    @Override
    public void start(Stage arg0) {
        //Esto sirve para cargar la vista
        try {
            Parent root = FXMLLoader.load(getClass().getResource("./vista/boton.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
    

