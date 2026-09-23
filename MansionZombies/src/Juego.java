public class Juego {
    int hab_actual;
    int hab_max;

    public Juego(int hab_max) {
        this.hab_max = hab_max;
    }


    public static void combate(Superviviente superviviente, Zombie zombie, Habitacion habitacion) {
        Dado dado = new Dado();
        zombie.resetear(habitacion);
        int ronda = 1;
        System.out.println(superviviente);
        System.out.println(zombie);
        while (superviviente.getVida_actual() > 0 && zombie.getVida_actual() > 0) {
            System.out.println("Ronda: " + ronda);
            int dado_superviviente = dado.lanzar(superviviente.getPuntos_ataque());
            int ataque_superviviente = dado_superviviente + superviviente.getNum_armas();
            System.out.println("El superviviente lanza un dado y ataca con " + ataque_superviviente + " puntos de ataque");
            zombie.setVida_actual(zombie.getVida_actual() - ataque_superviviente);
            System.out.println(superviviente);
            System.out.println(zombie);
            if (zombie.getVida_actual() < 1) {
                System.out.println("LO HAS MATADO");
                habitacion.setNum_zombies_activos(habitacion.getNum_zombies_activos() - 1);
            } else {
                int dado_zombie = dado.lanzar(zombie.getPuntos_ataque());
                int ataque_zombie = dado_zombie - superviviente.getNum_protecciones();
                superviviente.setVida_actual(superviviente.getVida_actual() - ataque_zombie);
            }

            if (superviviente.getVida_actual() < 1) {
                System.out.println("HAS PERDIDO");
            }
            ronda++;
        }
    }

    public static void busqueda(Habitacion habitacion, Superviviente superviviente) {
        Dado dado = new Dado();
        int dado_busqueda = dado.lanzar(100);
        if(dado_busqueda >= 96){
            superviviente.setNum_armas(superviviente.getNum_armas()+1);
            System.out.println("Has encontrado un arma!!!");
        } else if (dado_busqueda < 96 && dado_busqueda >= 91) {
            superviviente.setNum_protecciones(superviviente.getNum_protecciones()+1);
            System.out.println("Has encontrado una proteccion");
        } else if (dado_busqueda < 91 && dado_busqueda >=76) {
            System.out.println("Has conseguido un botiquin para curarte");
            superviviente.setBotiquin(true);
        }else{
            System.out.println("que mala suerte has hecho ruido, vuelves a tirar el dado");
            int dado_ruido = dado.lanzar(100);
            if(dado_ruido >80){
                System.out.println("vaya, has hecho aparecer dos zombies mas");
                habitacion.setNum_zombies_activos(habitacion.getNum_zombies_activos()+2);
            } else if (dado_ruido < 81 && dado_ruido >= 41) {
                System.out.println("vaya, has hecho aparecer un zombie mas");
                habitacion.setNum_zombies_activos(habitacion.getNum_zombies_activos()+1);

            }else{
                System.out.println("has tenido suerte no has hecho aparecer a ningun zombie");
            }

        }
    }



    public void setHab_actual(int hab_actual) {
        this.hab_actual = hab_actual;
    }

    public int getHab_max() {
        return hab_max;
    }
}
