import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2623 {
    
    static LinkedList<Integer> list[];
    static int before[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        before = new int[n+1];
        list = new LinkedList[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int loop = Integer.parseInt(stz.nextToken());
            
            if(loop >= 2) {
                int p = Integer.parseInt(stz.nextToken()), c;
                for(int j = 0; j < loop-1; j++) {
                    c = Integer.parseInt(stz.nextToken());
                    list[p].add(c);
                    before[c]++;
                    p = c;
                }
            }
        }
    
        System.out.println(order());
    }
    
    public static String order() {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < before.length; i++) {
            if(before[i] == 0)
                q.offer(i);
        }
        
        while(!q.isEmpty()) {
            int now = q.poll();
            sb.append(now + "\n");
            
            for(int next : list[now]) {
                before[next]--;
                if(before[next] < 0)
                    break;
                if(before[next] == 0)
                    q.offer(next);
            }
        }
        
        for(int i = 1; i < before.length; i++) {
            if(before[i] != 0)
                return "0";
        }
        return sb.toString();
    }
}
