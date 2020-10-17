import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class p1525 {
    
    static int n, s[];
    static TreeSet<Integer> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer stz = new StringTokenizer(br.readLine());
        s = new int[n];
        for(int i = 0; i < n; i++)
            s[i] = Integer.parseInt(stz.nextToken());
        set = new TreeSet<>();
        
        for(int i = 1; i <= n; i++)
            dfs(0, i, 0, 0, new boolean[n]);
        
        for(int i = 1; ; i++)
            if(!set.contains(i)) {
                System.out.println(i);
                return;
            }
    }
    
    public static void dfs(int count, int size, int start, int sum, boolean visit[]) {
        if(count == size) {
            set.add(sum);
            return;
        }
        
        for(int i = start; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(count+1, size, i, sum + s[i], visit);
                visit[i] = false;
            }
        }
    }
}
