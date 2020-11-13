import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class p5568 {
    
    static int n, k, card[];
    static Set<String> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        card = new int[n];
        set = new HashSet<>();
        for(int i = 0; i < n; i++)
            card[i] = Integer.parseInt(br.readLine());
        
        dfs(0, new boolean[n], "");
        System.out.println(set.size());
    }
    
    public static void dfs(int count, boolean visit[], String s) {
        if(count == k) {
            set.add(s);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(count+1, visit, s + card[i]);
                visit[i] = false;
            }
        }
    }
}
