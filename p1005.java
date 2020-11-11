import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1005 {
    
    static int cost[], before[], w, time, dp[];
    static LinkedList<Integer> link[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int tc = 0; tc < t; tc++) {
            stz = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stz.nextToken());
            int k = Integer.parseInt(stz.nextToken());
            cost = new int[n+1];
            before = new int[n+1];
            dp = new int[n+1];
            time = 0;
            link = new LinkedList[n+1];
            for(int i = 1; i <= n; i++)
                link[i] = new LinkedList<>();
            stz = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++)
                cost[i] = Integer.parseInt(stz.nextToken());
            for(int i = 0; i < k; i++) {
                stz = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(stz.nextToken());
                int b = Integer.parseInt(stz.nextToken());
                before[b]++;
                link[a].add(b);
            }
            w = Integer.parseInt(br.readLine());
            build();
            sb.append(time + "\n");
        }
        System.out.println(sb.toString());
    }
    
    public static void build() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < before.length; i++) {
            if(before[i] == 0) {
                if(i == w) {
                    time = cost[w];
                    return;
                }
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next : link[now]) {
                before[next]--;
                dp[next] = Math.max(dp[next], cost[now] + dp[now]);
                if(before[next] == 0) {
                    q.offer(next);
                }
            }
        }
        time = cost[w] + dp[w];
    }
    
}
