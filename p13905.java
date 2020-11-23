import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p13905 {
    
    static int n, parent[], max;
    static LinkedList<Edge> list[], path[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        stz = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(stz.nextToken());
        int e = Integer.parseInt(stz.nextToken());
        parent = new int[n+1];
        for(int i = 1; i <= n; i++)
            parent[i] = i;
        list = new LinkedList[n+1];
        path = new LinkedList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new LinkedList<>();
            path[i] = new LinkedList<>();
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.w-o1.w;
            }
        });
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            list[a].add(new Edge(b, w));
            list[b].add(new Edge(a, w));
            pq.offer(new Node(a, b, w));
        }
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(find(now.v1) != find(now.v2)) {
                union(now.v1, now.v2);
                path[now.v1].add(new Edge(now.v2, now.w));
                path[now.v2].add(new Edge(now.v1, now.w));
            }
        }
        for(int i = 1; i <= n; i++)
            Collections.sort(path[i], new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o2.w - o1.w;
                }
            });
        
        int result = bfs(s, e);
        System.out.println(result == 987654321 ? 0 : result);
    }
    
    public static int bfs(int s, int e) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.w - o1.w;
            }
        });
        boolean visit[] = new boolean[n+1];
        pq.offer(new Edge(s, 0));
        int maxWeight[] = new int[n+1];
        Arrays.fill(maxWeight, 987654321);
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if(now.v == e)
                break;
            
            if(!visit[now.v]) {
                visit[now.v] = true;
                
                for(Edge next : path[now.v]) {
                    pq.offer(next);
                    maxWeight[next.v] = Math.min(next.w, maxWeight[now.v]);
                }
            }
        }
        
        return maxWeight[e];
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
        int v, w;
        
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    
    static class Node{
        int v1, v2, w;
        
        Node(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
    }
}
