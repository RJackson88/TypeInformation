/**
 * Created by rickjackson on 2/15/17.
 */
package jackson.rick;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartITest {
    private PartI i;
    private MyClass myClass;
    
    @Before
    public void setup() {
        this.i = new PartI();
        this.myClass = new MyClass(true);
    }
    
    @Test
    public void classImplementsInterfaceTest() {
        boolean expected = true;
        boolean actual = i.classImplementsInterface(MyClass.class,
                MyInterface.class);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void listAllMembersTest() {
        String expected = "public boolean jackson.rick.MyClass.myField\n"
                + "public jackson.rick.MyClass()\n"
                + "public jackson.rick.MyClass(boolean)\n"
                + "public boolean jackson.rick.MyClass.myMethod(boolean)\n"
                + "public java.lang.Object()\n"
                + "protected void java.lang.Object.finalize() throws java"
                + ".lang.Throwable\n"
                + "public final void java.lang.Object.wait(long,int) throws "
                + "java.lang.InterruptedException\n"
                + "public final native void java.lang.Object.wait(long) "
                + "throws java.lang.InterruptedException\n"
                + "public final void java.lang.Object.wait() throws java.lang"
                + ".InterruptedException\n"
                + "public boolean java.lang.Object.equals(java.lang.Object)\n"
                + "public java.lang.String java.lang.Object.toString()\n"
                + "public native int java.lang.Object.hashCode()\n"
                + "public final native java.lang.Class java.lang.Object"
                + ".getClass()\n"
                + "protected native java.lang.Object java.lang.Object.clone()"
                + " throws java.lang.CloneNotSupportedException\n"
                + "private static native void java.lang.Object"
                + ".registerNatives()\n"
                + "public final native void java.lang.Object.notify()\n"
                + "public final native void java.lang.Object.notifyAll()\n";
        String actual = i.listAllMembers(myClass);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getClassHierarchyTest() {
        String expected = "java.lang.Object\n"
                + "  jackson.rick.MyClass";
        String actual = i.getClassHierarchy(myClass);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void instantiateClassHierarchyTest() {
        String expected = "[jackson.rick.MyClass@deb6432, "
                + "java.lang.Object@28ba21f3]";
        String actual = i.instantiateClassHierarchy(myClass).toString();
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    
}
