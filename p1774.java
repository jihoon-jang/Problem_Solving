import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1774 {
    
    static int parent[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        parent = new int[n+1];
        for(int i = 1; i <= n; i++)
            parent[i] = i;
        God god[] = new God[n+1];
        for(int i = 1; i <= n; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            god[i] = new God(i, a, b);
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 1; i < n; i++) {
            for(int j = i+1; j <= n; j++) {
                pq.offer(new Edge(i, j, Math.sqrt(Math.pow(Math.abs(god[i].x - god[j].x), 2) + Math.pow(Math.abs(god[i].y - god[j].y), 2))));
            }
        }
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            union(a, b);
        }
        
        double weight = 0;
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if(find(now.v1) != find(now.v2)) {
                union(now.v1, now.v2);
                weight += now.weight;
            }
        }
        System.out.printf("%.2f", weight);
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
    
    static class God {
        int number, x, y;
        
        God(int n, int x, int y) {
            number = n;
            this.x = x;
            this.y = y;
        }
    }
    
    static class Edge implements Comparable<Edge> {
        int v1, v2;
        double weight;
        
        Edge(int v1, int v2, double weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
        
        public int compareTo(Edge e) {
            return Double.compare(weight, e.weight);
        }
    }
}
