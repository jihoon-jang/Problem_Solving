import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p13418 {
    
    static int parent[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        parent = new int[n+1];
        for(int i = 0; i <= n; i++)
            parent[i] = i;
        PriorityQueue<Edge> max = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        PriorityQueue<Edge> min = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.weight - o1.weight;
            }
        });
        for(int i = 0; i <= m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            min.offer(new Edge(a, b, w));
            max.offer(new Edge(a, b, w));
        }
        
        int maxValue = 0;
        int minValue = 0;
        while(!min.isEmpty()) {
            Edge now = min.poll();
            
            if(find(now.v1) != find(now.v2)) {
                union(now.v1, now.v2);
                if(now.weight == 0)
                    minValue++;
            }
        }
        for(int i = 0; i <= n; i++)
            parent[i] = i;
        
        while(!max.isEmpty()) {
            Edge now = max.poll();
        
            if(find(now.v1) != find(now.v2)) {
                union(now.v1, now.v2);
                if(now.weight == 0)
                    maxValue++;
            }
        }
    
        System.out.println((int)(Math.pow(maxValue, 2) - Math.pow(minValue, 2)));
    }
    
    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        
        if(p1 > p2)
            parent[p1] = p2;
        else
            parent[p2] = p1;
    }
    
    public static int find(int n) {
        if(parent[n] == n)
            return n;
        
        return parent[n] = find(parent[n]);
    }
    
    static class Edge{
        int v1, v2, weight;
        
        Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = w;
        }
    }
}
