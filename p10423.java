import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p10423 {
    
    static int parent[];
    static boolean electric[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        parent = new int[n+1];
        electric = new boolean[n+1];
        for(int i = 1; i <= n; i++)
            parent[i] = i;
        Set<Integer> set = new HashSet<>();
        stz = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int sup = Integer.parseInt(stz.nextToken());
            set.add(sup);
            electric[sup] = true;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            pq.offer(new Edge(a, b, w));
        }
        
        int weight = 0;
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if(find(now.v1) != find(now.v2) && (!electric[find(now.v1)] || !electric[find(now.v2)])) {
                union(now.v1, now.v2);
                weight += now.weight;
            }
        }
    
        System.out.println(weight);
    }
    
    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        
        if(p1 > p2) {
            if(electric[p1])
                electric[p2] = true;
            parent[p1] = p2;
        }
        else {
            if(electric[p2])
                electric[p1] = true;
            parent[p2] = p1;
        }
    }
    
    public static int find(int n) {
        if(parent[n] == n)
            return n;
        
        return parent[n] = find(parent[n]);
    }
    
    static class Edge {
        int v1, v2, weight;
        
        Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }
}
