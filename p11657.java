import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p11657 {
    
    static long dist[];
    static int n, INF = 987654321;
    static LinkedList<Edge> list[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        dist = new long[n+1];
        Arrays.fill(dist, INF);
        list = new LinkedList[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());
            list[a].add(new Edge(b, c));
        }
        
        StringBuilder sb = new StringBuilder();
        if(bellmanFord()) {
            System.out.println(-1);
            return;
        }
        else {
            for(int i = 2; i <= n; i++)
                sb.append(dist[i] == INF ? -1 : dist[i]).append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
    public static boolean bellmanFord() {
        dist[1] = 0;
        boolean update = false;
        
        for(int i = 1; i <= n; i++) {
            update = false;
            
            for(int j = 1; j <= n; j++) {
                for(Edge edge : list[j]) {
                    if(dist[j] != INF && dist[edge.v] > dist[j] + edge.w) {
                        dist[edge.v] = dist[j] + edge.w;
                        update = true;
                    }
                }
            }
            
            if(!update)
                break;
            else if(update && i == n)
                return true;
        }
        
        return false;
    }
    
    static class Edge{
        int v, w;
        
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
