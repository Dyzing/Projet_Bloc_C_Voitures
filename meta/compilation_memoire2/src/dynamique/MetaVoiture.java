package dynamique;

public class MetaVoiture extends Voiture implements Surveillable{


    public MetaVoiture(int vitesse) {
        super(vitesse);
    }

    @Override
    public int surveiller(int limitevitesse) {
        if (this.getVitesse() > limitevitesse){
            return this.getVitesse()-limitevitesse;
        }
        else{
            return 0;
        }
    }
}
