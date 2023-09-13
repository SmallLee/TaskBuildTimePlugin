import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        for(String s:list) {
            if (s.equals("4")) {
                list.remove(s);
            }
        }
        System.out.println(list);
    }
}
