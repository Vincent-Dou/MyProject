import java.util.HashMap;
import java.util.Iterator;
import	java.util.Iterator;
import java.util.Map;

/**
 * Date: 2019/7/25
 * Time: 15:38
 * Author: vincent-Dou
 * Description：
 */
public class test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "aa");
        map.put("2", "bb");
        map.put("3", "cc");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> temp = (Map.Entry<String, String>) iterator.next();
            System.out.println(temp.getKey()+"=="+temp.getValue());
        }

        System.out.println();
    }
}
