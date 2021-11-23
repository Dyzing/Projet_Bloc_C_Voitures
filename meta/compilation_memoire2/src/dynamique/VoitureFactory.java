package dynamique;
import java.lang.reflect.*;
import java.util.Scanner;

public class VoitureFactory {

    public enum ModeConstruction {INSTANCIATION, REFLEXION, META}

    public static Voiture buildVoiture(ModeConstruction mode, boolean sport,int vitesse) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        if (mode == ModeConstruction.INSTANCIATION) {
            System.out.println("INSTANCIATION");
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

        else if (mode == ModeConstruction.REFLEXION) {
            System.out.println("REFLEXION");
            Scanner sc = new Scanner(System.in);
            System.out.print("Nom de la Classe > ");
            String nomClasse = sc.next();

            //REFLEXION
            if (sport){

                Class maClasse = Class.forName(nomClasse);
                Object o1 = maClasse.getDeclaredConstructor().newInstance();
                return (MetaVoitureSport)o1;

            }
            else{

                Class maClasse = Class.forName(nomClasse);
                Object o2 = maClasse.getDeclaredConstructor(int.class).newInstance(vitesse);
                return (MetaVoiture)o2;
            }

        }

        /*else if (mode == ModeConstruction.META){

            //META

        }
*/
        else{
            Voiture voiture2 = new Voiture(vitesse);
            return voiture2;
        }


    }



}
