package dynamique;

public class Voiture {

    private int vitesse = 10;
    private int position = 0;
    private int id;
    public static int _id= 0;

    public Voiture(int vitesse) {
        this.vitesse = vitesse;
        ++_id;
        this.id = _id;
    }

    public void deplacement(){
        position += vitesse;

    }

    public int getId() {
        return id;
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
