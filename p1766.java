import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1766 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int link[] = new int[n+1];
        LinkedList<Integer> list[] = new LinkedList[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            list[a].add(b);
            link[b]++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++)
            if(link[i] == 0)
                pq.offer(i);
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now + " ");
            Iterator<Integer> it = list[now].iterator();
            while(it.hasNext()) {
                int next = it.next();
                link[next]--;
                if(link[next] == 0)
                    pq.offer(next);
            }
        }
        System.out.println(sb.toString());
    }
}
