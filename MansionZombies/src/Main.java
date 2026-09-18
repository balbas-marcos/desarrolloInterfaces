import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Superviviente superviviente = new Superviviente();
        Habitacion habitacion = new Habitacion();
        Juego juego = new Juego(dificultad());
        Zombie z1 = new Zombie((int) (Math.random() * 2) + 2 - habitacion.getNum_hab() -1, (int) (Math.random() * 2) + 2 - habitacion.getNum_hab() -1);
        int turno = menu_turno();
        switch (turno){
            case 1:
                combate(superviviente, z1);
        }
    }


    public static int dificultad() {
        Scanner sc = new Scanner(System.in);
        boolean valido = false;
        byte opcion = -1;
        byte nivel = 0;
        do {
            try {
                System.out.println("""
                        ========================
                        MANSION ZOMBIE
                         1. Fácil: la mansión se supera jugando 5 habitaciones.
                         2. Difícil: la mansión se supera jugando 10 habitaciones.
                        elije: """);
                opcion = sc.nextByte();

                switch (opcion) {
                    case 1:
                        nivel = 5;
                        valido = true;
                        break;

                    case 2:
                        nivel = 10;
                        valido = true;
                        break;
                    default:
                        System.out.println("Introduce un numero UNO O DOS melon");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: debes introducir un numero" + e);
                sc.nextLine();

            }
        } while (!valido);
        return nivel;
    }

    public static int menu_turno() {
        Scanner sc = new Scanner(System.in);
        boolean valido = false;
        byte opcion = -1;
        do {
            try {
                System.out.println("""
                        ========================
                        MANSION ZOMBIE
                         1. Combatir
                         2. Buscar por habitacion
                         3. Avanzar
                         4. Curarse
                        elije: """);
                opcion = sc.nextByte();
                if(opcion >4 || opcion <1){
                    System.out.println("tienes que elejir una opcion del 1 al 4");

                }else{
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: debes introducir un numero entre 1 y dos" + e);
                sc.nextLine();

            }
        } while (!valido);
        return opcion;
    }

    public static void combate(Superviviente superviviente, Zombie zombie){
        Dado dado = new Dado();
        int ataque = dado.lanzar(4);
        boolean valido = false;
        while()
        System.out.println("El superviviente lanza un dado y ataca con "+ataque+" puntos de ataque");
        zombie.setVida_actual(zombie.getVida_actual() -  ataque);
        System.out.println(zombie);
        if()
    }
}