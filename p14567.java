import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p14567 {
    
    static int before[], n, answer[];
    static LinkedList<Integer> list[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        before = new int[n+1];
        list = new LinkedList[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        answer = new int[n+1];
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            list[a].add(b);
            before[b]++;
        }
        topology();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++)
            sb.append(answer[i] + " ");
    
        System.out.println(sb.toString());
    }
    
    public static void topology() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(before[i] == 0) {
                answer[i] = 1;
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next : list[now]) {
                before[next]--;
                if(before[next] == 0) {
                    q.offer(next);
                    answer[next] = answer[now]+1;
                }
            }
        }
    }
}
