public class Dado {

    public Dado() {
    }

    public int lanzar(int caras){
        return (int) (Math.random()*caras)+1;
    }
}
