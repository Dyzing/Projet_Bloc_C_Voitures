package dynamique;

public class Voiture {

    private int vitesse = 10;
    private int position = 0;
    public static int id = 0;

    public Voiture(int vitesse) {
        this.vitesse = vitesse;
        ++id;
    }

    public void deplacement(){
        position += vitesse;

    }

    public int getPosition(){
        return position;
    }

    public  int getVitesse(){
        return vitesse;
    }


    @Override
    public String toString() {
        return "Voiture{" +
                "vitesse=" + vitesse +
                ", position=" + position +
                ", id=" + id +
                '}';
    }
}
