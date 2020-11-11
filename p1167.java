import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1167 {
    
    static LinkedList<Edge> tree[];
    static int distance[], index;
    static long max;
    static boolean visit[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int v = Integer.parseInt(br.readLine());
        tree = new LinkedList[v+1];
        distance = new int[v+1];
        visit = new boolean[v+1];
        for(int i = 1; i <= v; i++)
            tree[i] = new LinkedList<>();
        
        for(int i = 0; i < v; i++) {
            stz = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(stz.nextToken());
            int child = Integer.parseInt(stz.nextToken());
            
            while(child != -1) {
                int weight = Integer.parseInt(stz.nextToken());
                tree[parent].add(new Edge(child, weight));
                tree[child].add(new Edge(parent, weight));
                child = Integer.parseInt(stz.nextToken());
            }
        }
        
        dfs(1, 0);
        visit = new boolean[v+1];
        distance = new int[v+1];
        dfs(index, 0);
        System.out.println(max);
    }
    
    public static void dfs(int node, int weight) {
        distance[node] = weight;
        visit[node] = true;
        
        if(weight > max) {
            max = weight;
            index = node;
        }
        
        for(Edge next : tree[node]) {
            if(!visit[next.number])
                dfs(next.number, weight + next.weight);
        }
    }
    
    static class Edge {
        int number, weight;
        
        Edge(int n, int w) {
            number = n;
            weight = w;
        }
    }
}
