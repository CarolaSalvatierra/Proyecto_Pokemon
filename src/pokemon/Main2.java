package pokemon;

public class Main2 {
    public static void main(String[] args) {
        Tipo[] tipo = {Tipo.AGUA, Tipo.BICHO};
        Pokemon p = new Pokemon("Poato", "C0ck", 50, 20, 10, 15, 30, 20, 30, 2, tipo);

        System.out.println(p.getExperiencia());
        p.subirNivel(35);
    }
    
}
