import arbre.*;
import reflexion.Analyseur;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        var carres = new ArrayList();
        for (int i = 0; i < 5; i++)
            carres.add(i * i);

        Sapin s1 = new Sapin(12);
        Sapin s2 = new Sapin(4, "rouge", true);
        Sapin s3 = new SapinNoel();


        try {
            System.out.println(new Analyseur().toString(carres));
            System.out.println(new Analyseur().toString(s1));
            System.out.println(new Analyseur().toString(s2));
            System.out.println(new Analyseur().toString(s3));
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}