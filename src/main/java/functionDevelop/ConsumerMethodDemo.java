package functionDevelop;


import org.junit.Test;

import java.util.function.Consumer;

public class ConsumerMethodDemo {

//    Consumer c = new Consumer(){
//        @Override
//        public void accept(Object o){
//            System.out.println(o);
//        }
//    };


    public static void consumetTest(){
        Consumer c = System.out::println;

        Consumer c2 = n->System.out.println(n + "-F2");

//        c.andThen(c2).accept("test");

        c.andThen(c).andThen(c).andThen(c).accept("test1");
    }

    @Test
    public void doTest(){
        consumetTest();
    }


}
