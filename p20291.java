import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class p20291 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String name = br.readLine().split("\\.")[1];
            if(map.containsKey(name))
                map.put(name, map.get(name)+1);
            else
                map.put(name, 1);
        }
        
        StringBuilder sb = new StringBuilder();
        Set<String> key = map.keySet();
        for(String k : key)
            sb.append(k + " " + map.get(k)).append("\n");
    
        System.out.println(sb.toString());
    }
}
