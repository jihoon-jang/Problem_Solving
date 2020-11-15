import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p2910 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        stz = new StringTokenizer(br.readLine());
        LinkedList<Integer> index = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(stz.nextToken());
            index.add(num);
            if(map.containsKey(num))
                map.put(num, map.get(num)+1);
            else
                map.put(num, 1);
        }
        LinkedList<Integer> list = new LinkedList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.get(o2) == map.get(o1))
                    return index.indexOf(o1) - index.indexOf(o2);
                return map.get(o2) - map.get(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i : list) {
            int loop = map.get(i);
            for(int j = 0; j < loop; j++)
                sb.append(i + " ");
        }
        System.out.println(sb.toString());
    }
}
