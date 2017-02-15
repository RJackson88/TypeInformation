/**
 * Created by rickjackson on 2/15/17.
 */
package jackson.rick;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyClassTest {
    private MyClass me;
    
    @Before
    public void setup() {
        this.me = new MyClass(false);
    }
    
    @Test
    public void myMethodTest() {
        boolean expected = true;
        boolean actual = me.myMethod(false);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
}
