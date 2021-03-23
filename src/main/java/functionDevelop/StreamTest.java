package functionDevelop;

import org.junit.Test;

import java.util.stream.Stream;


public class StreamTest {

    @Test
    public void flateMap(){
        Stream<String> s = Stream.of("test", "t1", "teeee", "aaaa");
        s.flatMap(n->Stream.of(n.split(""))).forEach(System.out::println);
    }

    @Test
    public void takeWhile(){
        Stream<String> s1 = Stream.of("test", "t1", "t2", "teeeee", "aaaa", "taaa");

    }
}
