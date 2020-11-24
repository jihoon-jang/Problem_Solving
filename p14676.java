import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p14676 {
    
    static int before[], n;
    static LinkedList<Integer> list[];
    static boolean build[], destroy[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        before = new int[n+1];
        list = new LinkedList[n+1];
        build = new boolean[n+1];
        destroy = new boolean[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            list[a].add(b);
            before[b]++;
        }
        for(int i = 0; i < k; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            if(a == 1)
                build[b] = true;
            else
                destroy[b] = true;
        }
        
        for(int i = 1; i <= n; i++) {
            if(destroy[i] && !build[i]) {
                System.out.println("Lier!");
                return;
            }
        }
        
        topology();
        for(boolean b : build) {
            if(b) {
                System.out.println("Lier!");
                return;
            }
        }
        System.out.println("King-God-Emperor");
    }
    
    public static void topology() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(before[i] == 0 && build[i]) {
                q.offer(i);
                build[i] = false;
            }
        }
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next : list[now]) {
                before[next]--;
                if(before[next] == 0 && build[next]) {
                    q.offer(next);
                    build[next] = false;
                }
            }
        }
    }
}
