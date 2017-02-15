/**
 * Created by rickjackson on 2/15/17.
 */
package jackson.rick;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartI {
    
    PartI() {
        
    }
    
    public boolean classImplementsInterface(Object c, Object i) {
        return c.getClass().isInstance(i);
    }
    
    public String listAllMembers(Object o) {
        Class a = o.getClass();
        StringBuilder sb = new StringBuilder();
        boolean end = false;
        
        while (!end) {
            Field[] fields = a.getDeclaredFields();
            Constructor<?>[] constructors = a.getDeclaredConstructors();
            Method[] methods = a.getDeclaredMethods();
    
            for (Field f : fields) {
                try {
                    sb.append(f.toString());
                    sb.append("\n");
                } catch (SecurityException se) {
                    se.printStackTrace();
                    System.out.println(se);
                }
            }
    
            for (Constructor c : constructors) {
                try {
                    sb.append(c.toString());
                    sb.append("\n");
                } catch (SecurityException se) {
                    se.printStackTrace();
                    System.out.println(se);
                }
            }
    
            for (Method m : methods) {
                try {
                    sb.append(m.toString());
                    sb.append("\n");
                } catch (SecurityException se) {
                    se.printStackTrace();
                    System.out.println(se);
                }
            }
            
            if (a.getSimpleName().equals("Object")) {
                end = true;
            } else {
                a = a.getSuperclass();
            }
        }
        return sb.toString();
    }
    
    public String getClassHierarchy(Object o) {
        Class c = o.getClass();
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        StringBuilder indent = new StringBuilder("  ");
        int count = 0;
        int idx = count;
        
        while (!c.getSimpleName().equals("Object")) {
            c = c.getSuperclass();
            count++;
        }
        c = o.getClass();
        
        for (int i = 0; i <= count; i++) {
            if (i != count) {
                front.replace(0, front.length(), "\n");
            }
            for (int j = 0; j <= idx; j++) {
                front.append(indent);
            }
            idx--;
            front.append(c.getName());
            front.append(back);
            back.replace(0, back.length(), front.toString());
            front.replace(0, front.length(), "");
            c = c.getSuperclass();
        }
        return back.toString();
    }
    
    public List<Object> instantiateClassHierarchy(Object o) {
        Class c = o.getClass();
        List<Object> l = new ArrayList<>();
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        boolean go = true;
        
        while (go) {
            try {
                l.add(c.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            if (c.getSimpleName().equals("Object")) {
                go = false;
            } else {
                c = c.getSuperclass();
            }
        }
        return l;
    }
}
