import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p14938 {
    static int item[], weight[];
    static LinkedList<Edge> list[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int r = Integer.parseInt(stz.nextToken());
        item = new int[n+1];
        weight = new int[n+1];
        list = new LinkedList[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        stz = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++)
            item[i] = Integer.parseInt(stz.nextToken());
        for(int i = 0; i < r; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }
        
        int max = 0;
        int count = 0;
        for(int i = 1; i <= n; i++) {
            count = 0;
            Arrays.fill(weight, -1);
            dijkstra(i);
            for(int j = 1; j <= n; j++)
                if(weight[j] <= m)
                    count += item[j];
    
            max = Math.max(max, count);
        }
    
        System.out.println(max);
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w-o2.w;
            }
        });
        pq.offer(new Edge(start, 0));
        weight[start] = 0;
        boolean visit[] = new boolean[weight.length];
        
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if(!visit[now.v]) {
                visit[now.v] = true;
                
                for(Edge next : list[now.v]) {
                    if(weight[next.v] == -1 || weight[next.v] > weight[now.v] + next.w) {
                        weight[next.v] = weight[now.v] + next.w;
                        pq.offer(new Edge(next.v, weight[next.v]));
                    }
                }
            }
        }
    }
    
    static class Edge {
        int v, w;
        
        Edge(int v, int w) {
            this.v = v;;
            this.w = w;
        }
    }
}
