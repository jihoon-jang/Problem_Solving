import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p18352 {
    
    static int weight[];
    static boolean visit[];
    static LinkedList<Integer> list[];
    static PriorityQueue<Edge> pq;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        int x = Integer.parseInt(stz.nextToken());
        weight = new int[n+1];
        Arrays.fill(weight, -1);
        visit = new boolean[n+1];
        list = new LinkedList[n+1];
        pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w-o2.w;
            }
        });
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            list[a].add(b);
        }
        dijkstra(x);
        boolean same = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++)
            if(weight[i] == k) {
                same = true;
                sb.append(i + "\n");
            }
        
        if(same)
            System.out.println(sb.toString());
        else
            System.out.println(-1);
    }
    
    public static void dijkstra(int start) {
        pq.offer(new Edge(start, 0));
        weight[start] = 0;
        
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if(!visit[now.v]) {
                visit[now.v] = true;
                
                for(int next : list[now.v]) {
                    if(weight[next] == -1 || weight[next] > weight[now.v] + 1) {
                        weight[next] = weight[now.v] + 1;
                        pq.offer(new Edge(next, weight[next]));
                    }
                }
            }
        }
    }
    
    static class Edge {
        int v, w;
        
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
