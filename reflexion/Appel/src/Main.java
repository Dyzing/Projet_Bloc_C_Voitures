import test.MonObjet;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("Le nom de la classe > ");
        String nomClasse = sc.next();
        Object o = getInstanceObjet(nomClasse);
        ((MonObjet)o).maMethodeSimple();
        */

        Object o = getInstanceObjet("test.MonObjet");
        ((MonObjet)o).maMethodeSimple();

        System.out.println("-------------------");
        appelerMethodeDynamique(o, "maMethodeSimple", null, 0, null);
        appelerMethodeDynamique(o,"maMethodeSimple", new Class[]{int.class}, 73, int.class);
    }

    private static void appelerMethodeDynamique(Object o, String nomMethode, Class[] typeParams, int valeur, Class typeRetour) {

        Method m = null;
        try {
            Class maClasse = o.getClass();
            // Méthode sans parametre et sans gestion du return
            if (typeParams == null){
                m = maClasse.getMethod(nomMethode);
                //m = maClasse.getMethod(nomMethode, new Class[0]);
                m.invoke(o);
            }
            // Méthode avec paramètres et avec gestion du return
            else{
                m = maClasse.getMethod(nomMethode, typeParams);
                int retour = (Integer)m.invoke(o, valeur);
                System.out.println("RETOUR  : " + retour);
            }
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static Object getInstanceObjet(String nomClasse) {

        Class maClasse = null;
        try {

            maClasse = Class.forName(nomClasse);

            //Object o1 = maClasse.newInstance();    // Deprecated
            Object o1 = maClasse.getDeclaredConstructor().newInstance();
            Object o2 = maClasse.getDeclaredConstructor(int.class).newInstance(4);

            Class[] params = new Class[2];
            params[0] = String.class;
            params[1] = String.class;
            Object o3 = maClasse.getDeclaredConstructor(params).newInstance("SALUT", "BONJOUR");

            return o3;

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}