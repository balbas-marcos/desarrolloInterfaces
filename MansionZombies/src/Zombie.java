public class Zombie {
    int vida_actual;
    int puntos_ataque;

    public Zombie(int vida_actual, int puntos_ataque) {
        //this.vida_actual = (int) (Math.random() * 2) + 2 - Habitacion. 1;
        //this.puntos_ataque = (int) (Math.random() * 2) + 2 - 1;
        this.vida_actual = vida_actual;
        this.puntos_ataque = puntos_ataque;
    }

    public void resetear(Zombie zombie, Habitacion habitacion) {
        zombie.setVida_actual((int) ((Math.random() * 2) + 1) + 2 - habitacion.getNum_hab() - 1);
        zombie.setPuntos_ataque((int) (Math.random() * 2) + 2 - habitacion.getNum_hab() - 1);
    }

    public int getVida_actual() {
        return vida_actual;
    }

    public void setVida_actual(int vida_actual) {
        if (vida_actual < 0) {
            this.vida_actual = 0;
        } else {
            this.vida_actual = vida_actual;
        }
    }

    public int getPuntos_ataque() {
        return puntos_ataque;
    }

    public void setPuntos_ataque(int puntos_ataque) {
        if (puntos_ataque < 0) {
            this.puntos_ataque = 0;
        } else {
            this.puntos_ataque = puntos_ataque;
        }
    }

    @Override
    public String toString() {
        return "=======Zombie==========" +
                "\nvida_actual=" + vida_actual +
                "\npuntos_ataque=" + puntos_ataque +
                "\n=======================";
    }


}
