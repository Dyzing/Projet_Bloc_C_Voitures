package test;

public class MonObjet {

    public MonObjet(){
        System.out.println("CONSTRUCTEUR MON_OBJET");
    }

    public MonObjet(int param){
        System.out.println("CONSTRUCTEUR MON_OBJET avec param " + param);
    }

    public MonObjet(String param1, String param2){
        System.out.println("CONSTRUCTEUR MON_OBJET avec param1 " + param1 + " et param2 " + param2);
    }

    public void maMethodeSimple(){
        System.out.println("Appel d'une methode simple");
    }

    public int maMethodeSimple(int param){
        System.out.println("Appel d'une methode avec param " + param);
        return ++param;
    }
}
