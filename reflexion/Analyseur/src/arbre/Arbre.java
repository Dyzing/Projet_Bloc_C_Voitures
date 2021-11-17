package arbre;

public abstract class Arbre {

    private int hauteur;
    public String couleur;

    public Arbre(int hauteur, String couleur){

        this.hauteur = hauteur;
        this.couleur = couleur;
    }
}