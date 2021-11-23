package dynamique;

public class VoitureFactory {

    public enum ModeConstruction {INSTANCIATION, REFLEXION, META}

    public static Voiture buildVoiture(ModeConstruction mode, boolean sport,int vitesse) {

        if (mode == ModeConstruction.INSTANCIATION) {

            //INSTACIATION
            if (sport){

                MetaVoitureSport voituresport = new MetaVoitureSport();
                return voituresport;

            }
            else{

                MetaVoiture voiture = new MetaVoiture(vitesse);
                return voiture;

            }


        }
        else{
            Voiture voiture2 = new Voiture(vitesse);
            return voiture2;
        }

        /*else if (mode == ModeConstruction.REFLEXION) {

            //REFLEXION

        }

        else {

            //META

        }*/


    }



}
