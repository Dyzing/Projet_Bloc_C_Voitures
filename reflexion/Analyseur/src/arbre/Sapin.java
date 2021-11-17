package arbre;

public class Sapin extends Arbre{

    private boolean pourNoel;

    public Sapin(int hauteur, String couleur, boolean pourNoel){
        super(hauteur, "vert");
        this.pourNoel = pourNoel;
    }

    public Sapin(int hauteur){
        this(hauteur, "vert", false);
    }
}
