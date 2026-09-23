import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Superviviente superviviente = new Superviviente();
        Habitacion habitacion = new Habitacion();
        Juego juego = new Juego(dificultad());
        Zombie z1 = new Zombie((int) ((Math.random() * 2) + 1) + 2 - habitacion.getNum_hab() - 1, (int) (Math.random() * 2) + 2 - habitacion.getNum_hab() - 1);
        while (true) {
            int turno = menu_turno(superviviente, z1, habitacion, juego.getHab_max());
            switch (turno) {
                case 1:
                    juego.combate(superviviente, z1, habitacion);
                    break;
                case 2:
                    if (habitacion.getNum_zombies_activos() == 0 && habitacion.getIntentos_busqueda() > 0) {
                        habitacion.setIntentos_busqueda(habitacion.getIntentos_busqueda() - 1);
                        juego.busqueda(habitacion, superviviente);
                    } else {
                        System.out.println("quedan todavia " + habitacion.getNum_zombies_activos() + " zombies en la habitacion debes derrotarlos");

                    }
                    break;
                case 3:
                    if(habitacion.getNum_hab() != juego.getHab_max()){
                        habitacion.avanzarHabitacion(habitacion);
                    }else{
                        System.out.println("Lograste salir de la mansión");
                    }
                    break;
                case 4:
                    superviviente.curarse();
            }
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

    public static int menu_turno(Superviviente superviviente, Zombie zombie, Habitacion habitacion, int hab_max) {
        Scanner sc = new Scanner(System.in);
        boolean valido = false;
        byte opcion = -1;
        do {
            try {
                System.out.println("========================");
                System.out.println("MANSION ZOMBIE");


                if (superviviente.isBotiquin()){
                    System.out.println(" 4. Curarse");
                }

                if (habitacion.getNum_zombies_activos() > 0) {
                    System.out.println(" 1. Combatir contra un zombie");
                } else {
                    if (habitacion.getIntentos_busqueda() > 0) {
                        System.out.println(" 2. Buscar por la habitación (" + habitacion.getIntentos_busqueda() + " intentos)");
                    }

                    if (habitacion.getNum_hab() == hab_max) {
                        System.out.println(" 3. Salir de la mansión");
                    } else {
                        System.out.println(" 3. Avanzar a otra habitación");
                    }
                }

                System.out.print("elije una opción: ");
                opcion = sc.nextByte();

                if (habitacion.getNum_zombies_activos() > 0) {
                    if (opcion == 1) {
                        valido = true;
                    } else {
                        System.out.println("debes de combatir primero");
                    }
                } else {
                    if (opcion == 2 && habitacion.getIntentos_busqueda() > 0) {
                        valido = true;
                    } else if (opcion == 3) {
                        valido = true;
                    } else if (opcion == 4 && superviviente.isBotiquin()) {
                        valido = true;
                    } else {
                        System.out.println("no esta disponible esa opción");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("ERROR: Debes introducir un número");
                sc.nextLine();
            }
        } while (!valido);

        return opcion;
    }


}