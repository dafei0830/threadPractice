package functionDevelop;

import org.junit.Test;

import java.util.function.Function;

public class FunctionMethodDemo {
    public static void functionTest(){
        Function<Integer, Integer> f = s -> ++s;
        Function<Integer, Integer> g = s -> s * 2;

//        System.out.println(f.compose(g).apply(1));

//        System.out.println(f.andThen(g).apply(1));

        System.out.println(Function.identity().apply("a"));
    }

    @Test
    public void doTest(){
        functionTest();
    }
}
