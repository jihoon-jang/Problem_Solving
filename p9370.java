import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p9370 {
    
    static int weight[];
    static boolean visit[];
    static LinkedList<Edge> list[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int tt = 0; tt < tc; tt++) {
            stz = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stz.nextToken());
            int m = Integer.parseInt(stz.nextToken());
            int t = Integer.parseInt(stz.nextToken());
            weight = new int[n+1];
            Arrays.fill(weight, -1);
            visit = new boolean[n+1];
            list = new LinkedList[n+1];
            for(int i = 1; i <= n; i++)
                list[i] = new LinkedList<>();
            LinkedList<Integer> st = new LinkedList<>();
            stz = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stz.nextToken());
            int g = Integer.parseInt(stz.nextToken());
            int h = Integer.parseInt(stz.nextToken());
            
            for(int i = 0; i < m; i++) {
                stz = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(stz.nextToken());
                int b = Integer.parseInt(stz.nextToken());
                int d = Integer.parseInt(stz.nextToken());
                
                if((a == g && b == h) || (a == h && b == g)) {
                    list[a].add(new Edge(b, 2*d-1));
                    list[b].add(new Edge(a, 2*d-1));
                }
                else {
                    list[a].add(new Edge(b, 2*d));
                    list[b].add(new Edge(a, 2*d));
                }
            }
            for(int i = 0; i < t; i++)
                st.add(Integer.parseInt(br.readLine()));
            dijkstra(s);
            Collections.sort(st);
            for(int i : st) {
                if(weight[i] != -1 && weight[i] % 2 == 1)
                    sb.append(i + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        weight[start] = 0;
        pq.offer(new Edge(start, 0));
        
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
    
    static class Edge{
        int number, weight;
        
        Edge(int n, int w) {
            number = n;
            weight = w;
        }
    }
}
