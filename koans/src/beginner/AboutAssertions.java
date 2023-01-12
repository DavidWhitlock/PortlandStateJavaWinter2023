package beginner;

import com.sandwich.koan.Koan;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.*;

public class AboutAssertions {

    @Koan
    public void assertBooleanTrue() {
        // there are two possibilities, true or false, what would it be here?
        assertTrue(__);
    }

    @Koan
    public void assertBooleanFalse() {
        assertFalse(__);
    }

    @Koan
    public void assertNullObject() {
        // reference to the object can be null, a magic keyword, null, which means
        // that there is nothing there
        assertNull(__);
    }

    @Koan
    public void assertNullObjectReference() {
        Object someObject = __;
        assertNull(someObject);
    }

    @Koan
    public void assertNotNullObject() {
        // but what when there should not be a null value?
        assertNotNull(null);
    }

    @Koan
    public void assertEqualsUsingExpression() {
        assertTrue("Hello World!".equals(__));
    }

    @Koan
    public void assertEqualsWithAFewExpressions() {
        assertEquals("Hello World!", __);
        assertEquals(1, __);
        assertEquals(2 + 2, __);
        assertEquals(2 * 3, __);
        assertEquals(3 - 8, __);
        assertEquals(10 / 2, __);
    }

    @Koan
    public void assertEqualsWithDescriptiveMessage() {
        // Generally, when using an assertXXX methods, expectation is on the
        // left and it is best practice to use a String for the first arg
        // indication what has failed
        assertEquals("The answer to 'life the universe and everything' should be 42", 42, __);
    }

    @Koan
    public void assertSameInstance() {
        Integer original = new Integer(1);
        Integer same = original;
        Integer different = new Integer(1);
        // These are both equal to the original...
        assertEquals(original, same);
        assertEquals(original, different);
        // ...but only one refers to the same instance as the original.
        assertSame(original, __);
    }

    @Koan
    public void assertNotSameInstance() {
        Integer original = new Integer(1);
        Integer same = original;
        Integer different = new Integer(1);
        // These are both equal to the original...
        assertEquals(original, same);
        assertEquals(original, different);
        // ...but only one of them refers to a different instance.
        assertNotSame(original, same);  // We want equal, but _not_ the same.
    }
}
