import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p4195 {
    
    static int parent[], count[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < tc; t++) {
            int f = Integer.parseInt(br.readLine());
            parent = new int[2*f];
            count = new int[2*f];
            Arrays.fill(count, 1);
            for(int i = 0; i < 2*f; i++)
                parent[i] = i;
            int number = 0;
            Map<String, Integer> name = new HashMap<>();
            for(int i = 0; i < f; i++) {
                stz = new StringTokenizer(br.readLine());
                String s1 = stz.nextToken();
                String s2 = stz.nextToken();
                if(!name.containsKey(s1))
                    name.put(s1, number++);
                if(!name.containsKey(s2))
                    name.put(s2, number++);
                int n1 = name.get(s1);
                int n2 = name.get(s2);
                union(n1, n2);
                sb.append(count[find(n1)] + "\n");
            }
        }
        
        System.out.print(sb.toString());
    }
    
    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        
        if(p1 > p2) {
            parent[p1] = p2;
            count[p2] += count[p1];
            count[p1] = 0;
        }
        else if(p1 < p2) {
            parent[p2] = p1;
            count[p1] += count[p2];
            count[p2] = 0;
        }
    }
    
    public static int find(int n) {
        if(parent[n] == n)
            return n;
        
        return parent[n] = find(parent[n]);
    }
}
