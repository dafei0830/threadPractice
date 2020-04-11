package method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2020/4/10 16:08
 **/
class Widget{

        }


public class CollectionIteratorDemo {

    public static void main(String[] args) {

        List<Widget> widgetList = Collections.synchronizedList(new ArrayList<Widget>());

        for (Widget w: widgetList){

        }
    }
}
