import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p13414 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(stz.nextToken());
        int l = Integer.parseInt(stz.nextToken());
        for(int i = 0; i < l; i++)
            map.put(Integer.parseInt(br.readLine()), i);
        
        LinkedList<Integer> list = new LinkedList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i : list) {
            sb.append(String.format("%08d\n", i));
            k--;
            if(k == 0)
                break;
        }
        System.out.println(sb.toString());
    }
}
