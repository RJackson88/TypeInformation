/**
 * Created by rickjackson on 2/15/17.
 */
package jackson.rick;

public class MyClass implements MyInterface {
    public boolean myField;
    
    public MyClass() {
        this.myField = true;
    }
    
    public MyClass(boolean b) {
        this.myField = b;
    }
    
    public boolean myMethod(boolean b) {
        return myField == b;
    }
}
