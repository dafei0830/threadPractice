package functionDevelop;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Predicate;

public class PredicateMethodDemo {

    private static void predicateTest(){
        Predicate<String> p = o -> o.equals("test");
        Predicate<String> g = o -> o.startsWith("t");

//        System.out.println(p.negate().test("test"));
        Assert.assertFalse(p.negate().test("test"));

        Assert.assertTrue(p.and(g).test("test"));

        Assert.assertTrue(p.or(g).test("ta"));
    }

    @Test
    public void doTest(){
        predicateTest();
    }
}
