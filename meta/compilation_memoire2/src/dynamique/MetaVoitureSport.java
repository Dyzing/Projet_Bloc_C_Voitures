package dynamique;

public class MetaVoitureSport extends Voiture implements Surveillable{


    public MetaVoitureSport() {
        super(200);
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
