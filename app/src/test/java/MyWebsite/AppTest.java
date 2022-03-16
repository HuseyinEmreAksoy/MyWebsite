/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package MyWebsite;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

class AppTest {
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
    @Test
    public void testFoundSameElement(){
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,20,3,4,6));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1,20,3,4,6));
        assertTrue(App.isEqualArrayListAndMeanIsBiggerElement(a, b, 0.0));
    }
    @Test
    public void testNotFoundSameElement(){
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3,2,1,5));
        assertFalse(App.isEqualArrayListAndMeanIsBiggerElement(a, b, 2.4));
    }
    @Test
    public void testEmpty(){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3,2,1,4));
        assertFalse(App.isEqualArrayListAndMeanIsBiggerElement(a, b, 2.3));
    }
    @Test
    public void testNull(){
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3,2,1,4));
        assertFalse(App.isEqualArrayListAndMeanIsBiggerElement(a, null, 2.0));
        assertFalse(App.isEqualArrayListAndMeanIsBiggerElement(null, b, 2.0));
    }
    public void testMeanBigger(){
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3,2,1,4));
        assertTrue(App.isEqualArrayListAndMeanIsBiggerElement(a, b, 2.4));
    }
    public void testMeanSmaller(){
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3,2,1,4));
        assertFalse(App.isEqualArrayListAndMeanIsBiggerElement(a, b, 3.4));
    }
    public void testMeanEqual(){
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3,2,1,4));
        assertFalse(App.isEqualArrayListAndMeanIsBiggerElement(a, b, 2.5));
    }
}
