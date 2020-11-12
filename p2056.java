import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2056 {
    
    static LinkedList<Integer> list[];
    static int max, before[], cost[], dp[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int n = Integer.parseInt(br.readLine());
        list = new LinkedList[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        max = 0;
        before = new int[n+1];
        cost = new int[n+1];
        dp = new int[n+1];
        
        for(int i = 1; i <= n; i++) {
            stz = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(stz.nextToken());
            int loop = Integer.parseInt(stz.nextToken());
            
            for(int j = 0; j < loop; j++) {
                list[Integer.parseInt(stz.nextToken())].add(i);
                before[i]++;
            }
        }
        
        task();
        System.out.println(max);
    }
    
    public static void task() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < before.length; i++) {
            if(before[i] == 0) {
                q.offer(i);
                max = Math.max(max, cost[i]);
            }
        }
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next : list[now]) {
                before[next]--;
                dp[next] = Math.max(dp[next], cost[now] + dp[now]);
                max = Math.max(dp[next] + cost[next], max);
                if(before[next] == 0)
                    q.offer(next);
            }
        }
    }
}
