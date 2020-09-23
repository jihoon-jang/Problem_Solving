import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9466 {
    
    static int n, count, array[];
    static boolean visit[], finish[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            count = 0;
            n = Integer.parseInt(br.readLine());
            stz = new StringTokenizer(br.readLine());
            array = new int[n+1];
            for(int i = 1; i <= n; i++)
                array[i] = Integer.parseInt(stz.nextToken());
            visit = new boolean[n+1];
            finish = new boolean[n+1];
            for(int i = 1; i <= n; i++)
                dfs(i);
            System.out.println(n - count);
        }
    }
    
    public static void dfs(int index) {
        if(visit[index])
            return;
        visit[index] = true;
        int next = array[index];
        
        if(!visit[next])
            dfs(next);
        else {
            if(!finish[next]) {
                count++;
                for(int i = next; i != index; i = array[i])
                    count++;
            }
        }
        finish[index] = true;
    }
}
