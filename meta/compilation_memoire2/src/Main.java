import dynamique.*;

import javax.tools.*;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import dynamique.Voiture;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        List<Voiture> mesVoitures = new ArrayList<Voiture>();
        ajoutVoituresInstanciation(mesVoitures);
        ajoutVoituresReflexion(mesVoitures);

        try {
            int x = 0;
            while (x++ < 20)
                for (Voiture v : mesVoitures){
                    v.deplacement();
                    System.out.println(v);
                    surveillerVoiture(v);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private static void ajoutVoituresInstanciation(List<Voiture> mesVoitures) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        mesVoitures.add(VoitureFactory.buildVoiture(VoitureFactory.ModeConstruction.
                INSTANCIATION, true, 0));

        mesVoitures.add(VoitureFactory.buildVoiture(VoitureFactory.ModeConstruction.
                INSTANCIATION,false, 50));

        mesVoitures.add(VoitureFactory.buildVoiture(VoitureFactory.ModeConstruction.
                INSTANCIATION,false, 10));
    }

    private static void ajoutVoituresReflexion(List<Voiture> mesVoitures) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        mesVoitures.add(VoitureFactory.buildVoiture(VoitureFactory.ModeConstruction.
                REFLEXION, true, 0));

        mesVoitures.add(VoitureFactory.buildVoiture(VoitureFactory.ModeConstruction.
                REFLEXION,false, 50));

        mesVoitures.add(VoitureFactory.buildVoiture(VoitureFactory.ModeConstruction.
                REFLEXION,false, 10));
    }

    private static void surveillerVoiture(Voiture v) throws Exception {

        if (v.getPosition() > 1000){
            if (v.getClass().getName().contains("Meta")){
                int depassement = ((Surveillable)v).surveiller(40);
                if (depassement > 10)
                    throw new Exception("ID : " + v.getId() + " --> depassement de " + depassement + " (" + v.getClass() + ")");
            }
        }
    }







        /*
        // ******** ETAPE #1 : Préparation pour la compilation
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        List<ByteArrayClass> classes = new ArrayList<>();           // pour mettre les .class   (IMPORTANT)
        DiagnosticCollector<JavaFileObject> collector = new DiagnosticCollector<JavaFileObject>();
        JavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

        // La classe qui se charge de fournir les "conteneurs" au compilateur à la volée, sans accès au disque
        fileManager = new ForwardingJavaFileManager<JavaFileManager>(fileManager){
            public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind,
                                                       FileObject sibling) throws IOException{
                if (kind == JavaFileObject.Kind.CLASS){
                    ByteArrayClass outFile = new ByteArrayClass(className);
                    classes.add(outFile);           // ICI IMPORTANT
                    return outFile;
                }
                else
                    return super.getJavaFileForOutput(location, className, kind, sibling);
            }
        };

        // ******** ETAPE #2 : Génération du code source
        List<JavaFileObject> sources = List.of(
                TestFactory.buildSource("Test6"),
                TestFactory.buildSource("Test7"),
                TestFactory.buildSource("Test8"),
                TestFactory.buildSource("Test9")
        );

        // ******** ETAPE #3 : Compilation
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, collector, null,
                null, sources);
        Boolean result = task.call();

        for (Diagnostic<? extends JavaFileObject> d : collector.getDiagnostics())
            System.out.println(d);

        try {
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!result) {
            System.out.println("ECHEC DE LA COMPILATION");
            System.exit(1);
        }


        // ******** ETAPE #4 : Instanciation
        ByteArrayClasseLoader loader = new ByteArrayClasseLoader(classes);
        List<Test> mesTests = new ArrayList<Test>();
        try {
            // Recherche la classe dans le contexte "local" sinon il passe par le "loader"
            mesTests.add((Test)(Class.forName("dynamique.Test", true, loader).getDeclaredConstructor().newInstance()));
            mesTests.add((Test)(Class.forName("dynamique.Test6", true, loader).getDeclaredConstructor().newInstance()));
            mesTests.add((Test)(Class.forName("dynamique.Test7", true, loader).getDeclaredConstructor().newInstance()));
            mesTests.add((Test)(Class.forName("dynamique.Test8", true, loader).getDeclaredConstructor().newInstance()));
            mesTests.add((Test)(Class.forName("dynamique.Test9", true, loader).getDeclaredConstructor().newInstance()));
            // Creation d'une classe inexistante, erreur d'exécution plus loin en fin de programme
            mesTests.add((Test)(Class.forName("dynamique.TestX", true, loader).getDeclaredConstructor().newInstance()));
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // ******** ETAPE #5 : Exécution
        for (Test t : mesTests){
            System.out.println("CLASSE : " + t.getClass());
            System.out.println("X : " + t.getX());
        }

        */



}
