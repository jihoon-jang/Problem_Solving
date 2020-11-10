import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p10282 {
    
    static LinkedList<Edge> list[];
    static boolean visit[];
    static int weight[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < tc; t++) {
            stz = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stz.nextToken());
            int d = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());
            list = new LinkedList[n+1];
            visit = new boolean[n+1];
            weight = new int[n+1];
            Arrays.fill(weight, -1);
            for(int i = 1; i <= n; i++)
                list[i] = new LinkedList<>();
            
            for(int i = 0; i < d; i++) {
                stz = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(stz.nextToken());
                int b = Integer.parseInt(stz.nextToken());
                int s = Integer.parseInt(stz.nextToken());
                list[b].add(new Edge(a, s));
            }
            
            dijkstra(c);
            int count = 0;
            int time = 0;
            for(int i = 1; i <= n; i++) {
                if(weight[i] != -1) {
                    count++;
                    time = Math.max(time, weight[i]);
                }
            }
    
            sb.append(count + " " + time + "\n");
        }
        System.out.print(sb.toString());
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        pq.offer(new Edge(start, 0));
        weight[start] = 0;
        
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if(!visit[now.number]) {
                visit[now.number] = true;
                
                for(Edge next : list[now.number]) {
                    if(weight[next.number] == -1 || weight[next.number] > weight[now.number] + next.weight) {
                        weight[next.number] = weight[now.number] + next.weight;
                        pq.offer(new Edge(next.number, weight[next.number]));
                    }
                }
            }
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
