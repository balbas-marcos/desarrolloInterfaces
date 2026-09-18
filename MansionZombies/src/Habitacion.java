public class Habitacion {
    int num_hab = 1;
    int intentos_busqueda = 3;
    int num_zombies_activos = 1;


    public Habitacion() {
    }


    public int getNum_hab() {
        return num_hab;
    }

    public void setNum_hab(int num_hab) {
        this.num_hab = num_hab;
    }

    public int getIntentos_busqueda() {
        return intentos_busqueda;
    }

    public void setIntentos_busqueda(int intentos_busqueda) {
        this.intentos_busqueda = intentos_busqueda;
    }

    public int getNum_zombies_activos() {
        return num_zombies_activos;
    }

    public void setNum_zombies_activos(int num_zombies_activos) {
        this.num_zombies_activos = num_zombies_activos;
    }


    @Override
    public String toString() {
        return "=======Habitacion==========" +
                "\nnum_hab=" + num_hab +
                "\nintentos_busqueda=" + intentos_busqueda +
                "\nnum_zombies_activos=" + num_zombies_activos +
                "\n==============================";
    }
}
