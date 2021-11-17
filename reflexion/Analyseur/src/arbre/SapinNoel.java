package arbre;

public class SapinNoel extends Sapin{

    private Boule[] boules;

    public SapinNoel(){

        super(2, "vert", true);
        boules = new Boule[4];

        for (int x = 0; x < boules.length; x++)
            if (x % 2 == 0)
                boules[x] = new Boule("VERT");
            else
                boules[x] = new Boule("ROUGE");
    }
}
