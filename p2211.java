import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p2211 {
    
    static LinkedList<Edge> list[];
    static int circuit[];
    static boolean visit[];
    static int connect[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        list = new LinkedList[n+1];
        circuit = new int[n+1];
        connect = new int[n+1];
        Arrays.fill(circuit, -1);
        visit = new boolean[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            list[a].add(new Edge(b, w));
            list[b].add(new Edge(a, w));
        }
        
        dijkstra();
        StringBuilder sb = new StringBuilder();
        sb.append((n-1) + "\n");
        for(int i = 2; i <= n; i++)
            sb.append(i + " " + connect[i]+"\n");
        System.out.println(sb.toString());
    }
    
    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        pq.offer(new Node(1, 0));
        circuit[1] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(!visit[now.number]) {
                visit[now.number] = true;
                
                for(Edge next : list[now.number]) {
                    if(circuit[next.v] == -1 || circuit[next.v] > circuit[now.number] + next.weight) {
                        circuit[next.v] = circuit[now.number] + next.weight;
                        connect[next.v] = now.number;
                        pq.offer(new Node(next.v, circuit[next.v]));
                    }
                }
            }
        }
    }
    
    static class Node {
        int number, weight;
        
        Node(int n, int w) {
            number = n;
            weight = w;
        }
    }
    
    static class Edge {
        int v, weight;
        
        Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }
}
