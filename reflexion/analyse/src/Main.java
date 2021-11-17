import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {

    private int attr1;
    protected String attr2;
    Object attr3;
    public static int attr4 = 1;

    public Main(String p1, int p2){}
    public Main(String p1){}
    public Main(String p1, Double d){}


    public static void main(String[] args) throws ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Nom de la classe > ");
        String nomClasse = sc.next();

        Class classe = Class.forName(nomClasse);

        afficherInformationsClasse(classe);
        afficherAttributs(classe);
        afficherConstructeurs(classe);
        afficherMethodes(classe);
    }

    private static void afficherInformationsClasse(Class classe) {

        Class superClasse = classe.getSuperclass();

        String modificateurs = Modifier.toString(classe.getModifiers());

        if (modificateurs.length() > 0)
            System.out.print(modificateurs + " ");
        System.out.println(classe.getName() + " extends " + superClasse.getName());
    }

    private static void afficherAttributs(Class classe) {

        System.out.println("Les attributs");

        Field[] attributs = classe.getDeclaredFields();

        for (Field a : attributs) {
            Class type = a.getType();
            String nom = a.getName();
            System.out.print("\t");
            String modificateurs = Modifier.toString(a.getModifiers());

            if (modificateurs.length() > 0)
                System.out.print(modificateurs + " ");
            System.out.println(type.getName() + " " + nom + "");
        }
    }

    private static void afficherMethodes(Class classe) {

        System.out.println("Les methodes");

        Method[] methodes = classe.getDeclaredMethods();

        for (Method m : methodes) {
            Class typeRetour = m.getReturnType();
            String nom = m.getName();
            System.out.print("\t");
            String modificateurs = Modifier.toString(m.getModifiers());

            if (modificateurs.length() > 0)
                System.out.print(modificateurs + " ");
            System.out.print(typeRetour.getName() + " " + nom + " (");

            Class[] typesParam = m.getParameterTypes();
            for (int t = 0; t < typesParam.length; t++) {
                if (t > 0)
                    System.out.print(", ");
                System.out.print(typesParam[t].getName());
            }
            System.out.println(")");
        }
    }

    private static void afficherConstructeurs(Class classe) {

        System.out.println("Les constructeurs");

        Constructor[] constructeurs = classe.getDeclaredConstructors();

        for (Constructor c : constructeurs)
        {
            String nom = c.getName();
            String modificateurs = Modifier.toString(c.getModifiers());
            System.out.print("\t");
            if (modificateurs.length() > 0)
                System.out.print(modificateurs + " ");
            System.out.print(nom + " (");

            Class[] typesParam = c.getParameterTypes();
            for (int t = 0; t < typesParam.length; t++){
                if (t > 0)
                    System.out.print(", ");
                System.out.print(typesParam[t].getName());
            }
            System.out.println(")");
        }
    }
}