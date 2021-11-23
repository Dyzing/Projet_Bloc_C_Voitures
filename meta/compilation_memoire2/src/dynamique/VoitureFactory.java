package dynamique;
import java.lang.reflect.*;
import java.util.Scanner;

public class VoitureFactory {

    public enum ModeConstruction {INSTANCIATION, REFLEXION, META}

    public static Voiture buildVoiture(ModeConstruction mode, boolean sport,int vitesse) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            if (mode == ModeConstruction.INSTANCIATION) {
                //INSTACIATION
                if (sport) {

                    MetaVoitureSport voituresport = new MetaVoitureSport();
                    return voituresport;

                } else {

                    MetaVoiture voiture = new MetaVoiture(vitesse);
                    return voiture;

                }


            } else if (mode == ModeConstruction.REFLEXION) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Nom de la Classe > ");
                String nomClasse = sc.next();

                //REFLEXION
                if (sport) {

                    Class maClasse = Class.forName(nomClasse);
                    Object o1 = maClasse.getDeclaredConstructor().newInstance();

                    Constructor[] constructeurs = maClasse.getDeclaredConstructors();
                    Method[] methodes = maClasse.getDeclaredMethods();
                    Field[] attributs = maClasse.getDeclaredFields();

                    System.out.println(" ");

                    for (Constructor construc: constructeurs
                    ) {
                        System.out.println("Constructeur : " + construc.toString());
                    }

                    System.out.println(" ");

                    for (Method meth: methodes
                    ) {
                        System.out.println("Méthodes : " + meth.toString());
                    }

                    System.out.println(" ");

                    for (Field attr: attributs
                    ) {
                        System.out.println("Attributs : " + attr.toString());
                    }

                    System.out.println("-------------------------------------------------------------");

                    return (MetaVoitureSport) o1;

                } else {

                    Class maClasse = Class.forName(nomClasse);
                    Object o2 = maClasse.getDeclaredConstructor(int.class).newInstance(vitesse);

                    Constructor[] constructeurs = maClasse.getDeclaredConstructors();
                    Method[] methodes = maClasse.getDeclaredMethods();
                    Field[] attributs = maClasse.getDeclaredFields();

                    System.out.println(" ");

                    for (Constructor construc: constructeurs
                    ) {
                        System.out.println("Constructeur : " + construc.toString());
                    }

                    System.out.println(" ");

                    for (Method meth: methodes
                    ) {
                        System.out.println("Méthodes : " + meth.toString());
                    }

                    System.out.println(" ");

                    for (Field attr: attributs
                    ) {
                        System.out.println("Attributs : " + attr.toString());
                    }

                    System.out.println("-------------------------------------------------------------");    

                    return (MetaVoiture) o2;
                }

            }

        /*else if (mode == ModeConstruction.META){

            //META

        }
*/
            else {
                Voiture voiture2 = new Voiture(vitesse);
                return voiture2;
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("*** CLASSE NON TROUVEE ***");
        }
        Voiture voiture2 = new Voiture(vitesse);
        return voiture2;
    }


}
