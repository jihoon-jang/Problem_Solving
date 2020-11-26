import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p1219 {
    
    static long dist[], INF = Long.MIN_VALUE;
    static int n, cost[];
    static LinkedList<Edge> list[];
    static Set<Integer> conn;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        int s = Integer.parseInt(stz.nextToken());
        int e = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        dist = new long[n];
        Arrays.fill(dist, INF);
        cost = new int[n];
        list = new LinkedList[n];
        conn = new HashSet<>();
        for(int i = 0; i < n; i++)
            list[i] = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());
            list[a].add(new Edge(b, c));
        }
        stz = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            cost[i] = Integer.parseInt(stz.nextToken());
        for(int i = 0; i < n; i++) {
            for(Edge edge : list[i]) {
                edge.w = cost[edge.v] - edge.w;
            }
        }
        boolean result = bellmanFord(s, e);
        if(dist[e] == INF)
            System.out.println("gg");
        else if(result)
            System.out.println("Gee");
        else
            System.out.println(dist[e]+cost[s]);
    }
    
    public static boolean bellmanFord(int start, int e) {
        dist[start] = 0;
        boolean update = false;
        
        for(int i = 0; i < n-1; i++) {
            update = false;
            for(int j = 0; j < n; j++) {
                for(Edge edge : list[j]) {
                    if(dist[j] != INF && dist[edge.v] < dist[j] + edge.w) {
                        dist[edge.v] = dist[j] + edge.w;
                        update = true;
                    }
                }
            }
            
            if(!update)
                break;
        }
        
        for(int j = 0; j < n; j++) {
            for(Edge edge : list[j]) {
                if(dist[j] != INF && dist[edge.v] < dist[j] + edge.w) {
                    dist[edge.v] = dist[j] + edge.w;
                    conn.add(j);
                    conn.add(edge.v);
                }
            }
        }
        
        for(int vertex : conn) {
            if(bfs(vertex, e))
                return true;
        }
        
        return false;
    }
    
    public static boolean bfs(int s, int e) {
        boolean visit[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visit[s] = true;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            if(now == e)
                return true;
            
            for(Edge edge : list[now]) {
                if(!visit[edge.v]) {
                    visit[edge.v] = true;
                    q.offer(edge.v);
                }
            }
        }
        
        return false;
    }
    
    static class Edge {
        int v, w;
        
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
