import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p1302 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String book = br.readLine();
            if(map.containsKey(book))
                map.put(book, map.get(book) + 1);
            else
                map.put(book, 1);
        }
        LinkedList<String> list = new LinkedList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) == map.get(o2)) {
                    return o1.compareTo(o2);
                }
                return map.get(o2) - map.get(o1);
            }
        });
    
        System.out.println(list.getFirst());
    }
}
