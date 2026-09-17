public class Superviviente {
    int dificultad;
    int vida_max;
    int vida_actual;
    int puntos_ataque;
    boolean botiquin;
    int num_armas;
    int num_protecciones;


    public Superviviente(int dificultad) {
        this.dificultad = dificultad;
        this.vida_max = 20;
        this.vida_actual = 20;
        this.puntos_ataque = 4;
        this.botiquin = false;
        this.num_armas = 0;
        this.num_protecciones = 0;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public int getVida_max() {
        return vida_max;
    }

    public void setVida_max(int vida_max) {
        this.vida_max = vida_max;
    }

    public int getVida_actual() {
        return vida_actual;
    }

    public void setVida_actual(int vida_actual) {
        this.vida_actual = vida_actual;
    }

    public int getPuntos_ataque() {
        return puntos_ataque;
    }

    public void setPuntos_ataque(int puntos_ataque) {
        this.puntos_ataque = puntos_ataque;
    }

    public boolean isBotiquin() {
        return botiquin;
    }

    public void setBotiquin(boolean botiquin) {
        this.botiquin = botiquin;
    }

    public int getNum_armas() {
        return num_armas;
    }

    public void setNum_armas(int num_armas) {
        this.num_armas = num_armas;
    }

    public int getNum_protecciones() {
        return num_protecciones;
    }

    public void setNum_protecciones(int num_protecciones) {
        this.num_protecciones = num_protecciones;
    }

    @Override
    public String toString() {
        return "Superviviente{" +
                "dificultad=" + dificultad +
                ", vida_max=" + vida_max +
                ", vida_actual=" + vida_actual +
                ", puntos_ataque=" + puntos_ataque +
                ", botiquin=" + botiquin +
                ", num_armas=" + num_armas +
                ", num_protecciones=" + num_protecciones +
                '}';
    }

    public static void main(String[] args) {
        Superviviente superviviente1 = new Superviviente(1);
        System.out.println(superviviente1);
        Superviviente superviviente2 = new Superviviente(1);
        superviviente2.setNum_armas(4);
        System.out.println(superviviente2);
    }
}
