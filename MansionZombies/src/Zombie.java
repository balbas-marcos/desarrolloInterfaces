public class Zombie {
    int vida_actual;
    int puntos_ataque;

    public Zombie(int vida_actual, int puntos_ataque) {
        //this.vida_actual = (int) (Math.random() * 2) + 2 - Habitacion. 1;
        //this.puntos_ataque = (int) (Math.random() * 2) + 2 - 1;
        this.vida_actual = vida_actual;
        this.puntos_ataque = puntos_ataque;
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

    @Override
    public String toString() {
        return "=======Zombie==========" +
                "\nvida_actual=" + vida_actual +
                "\npuntos_ataque=" + puntos_ataque +
                "\n=======================";
    }



}
