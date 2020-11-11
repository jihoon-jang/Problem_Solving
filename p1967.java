import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1967 {
    
    static LinkedList<Edge> tree[];
    static int distance[], max, index;
    static boolean visit[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int n = Integer.parseInt(br.readLine());
        tree = new LinkedList[10001];
        distance = new int[10001];
        visit = new boolean[10001];
        for(int i = 1; i <= 10000; i++)
            tree[i] = new LinkedList<>();
        for(int i = 0; i < n-1; i++) {
            stz = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            tree[p].add(new Edge(c, w));
            tree[c].add(new Edge(p, w));
        }
        if(n > 1) {
            dfs(1, 0);
            visit = new boolean[10001];
            distance = new int[10001];
            dfs(index, 0);
            System.out.println(max);
        }
        else
            System.out.println(0);
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
