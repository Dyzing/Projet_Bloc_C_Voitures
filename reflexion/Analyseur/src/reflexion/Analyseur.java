package reflexion;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

// Fonctionne pour le moment, mais pour le futur....
public class Analyseur {

    public String toString(Object o) throws ReflectiveOperationException {

        if (o == null)
            return "null";

        Class classe = o.getClass();


        if (classe == String.class)
            return (String)o;

        if (classe.isArray()) {
            String a = classe.getComponentType() + "[ARRAY]{";
            for (int i = 0; i < Array.getLength(o); i++) {
                if (i > 0)
                    a += ",";
                Object val = Array.get(o,i);
                if (classe.getComponentType().isPrimitive())
                    a += val;
                else
                    a += toString(val);
            }
            return a;
        }

        String s = classe.getName();
        do{
            s += "[";
            Field[] attributs = classe.getDeclaredFields();

            // https://docs.oracle.com/javase/7/docs/api/java/lang/reflect/AccessibleObject.html
            AccessibleObject.setAccessible(attributs, true);

            for (Field a : attributs){
                if (!Modifier.isStatic(a.getModifiers())){
                    if (!s.endsWith("["))
                        s += ",";
                    Class t = a.getType();
                    s += (t.getName() + " " + a.getName() + "=");
                    Object val = a.get(o);
                    if (t.isPrimitive())
                        s += val;
                    else
                        s += toString(val);
                }
            }
            s += "]";
            classe = classe.getSuperclass();
        }
        while(classe != null);

        return s;
    }
}
