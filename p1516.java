import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1516 {
    
    static LinkedList<Integer> list[];
    static int before[], cost[], dp[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int n = Integer.parseInt(br.readLine());
        list = new LinkedList[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        before = new int[n+1];
        cost = new int[n+1];
        dp = new int[n+1];
        for(int i = 1; i <= n; i++) {
            stz = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(stz.nextToken());
            
            int first = Integer.parseInt(stz.nextToken());
            while(first != -1) {
                list[first].add(i);
                before[i]++;
                first = Integer.parseInt(stz.nextToken());
            }
        }
        build();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++)
            sb.append((cost[i] + dp[i]) + "\n");
    
        System.out.println(sb.toString());
    }
    
    public static void build() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < before.length; i++) {
            if(before[i] == 0)
                q.offer(i);
        }
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next : list[now]) {
                before[next]--;
                dp[next] = Math.max(dp[next], dp[now] + cost[now]);
                if(before[next] == 0)
                    q.offer(next);
            }
        }
    }
}
