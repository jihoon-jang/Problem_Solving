import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p2252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        LinkedList<Integer> list[] = new LinkedList[n+1];
        int link[] = new int[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        for(int i = 0; i < m; i++){
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            list[a].add(b);
            link[b]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++)
            if(link[i] == 0)
                q.offer(i);
            
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int now = q.poll();
            sb.append(now+" ");
            
            Iterator<Integer> it = list[now].iterator();
            while(it.hasNext()) {
                int index = it.next();
                link[index]--;
                if(link[index] == 0)
                    q.offer(index);
            }
        }
        System.out.println(sb.toString());
    }
}
