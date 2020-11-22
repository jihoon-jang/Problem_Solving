import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p1719 {
    
    static int weight[], path[];
    static LinkedList<Edge> list[];
    static boolean visit[];
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        list = new LinkedList[n+1];
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
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            set();
            dijkstra(i);
            for(int j = 1; j <= n; j++) {
                sb.append(getPath(i, j) + " ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w - o2.w;
            }
        });
        pq.offer(new Edge(start, 0));
        weight[start] = 0;
        
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if(!visit[now.v]) {
                visit[now.v] = true;
                
                for(Edge next : list[now.v]) {
                    if(weight[next.v] == -1 || weight[next.v] > weight[now.v] + next.w) {
                        path[next.v] = now.v;
                        weight[next.v] = weight[now.v] + next.w;
                        pq.offer(new Edge(next.v, weight[next.v]));
                    }
                }
            }
        }
    }
    
    public static void set(){
        weight = new int[n+1];
        path = new int[n+1];
        Arrays.fill(weight, -1);
        visit = new boolean[n+1];
    }
    
    public static String getPath(int start, int index) {
        int num = path[index];
        if(num == 0)
            return "-";
        
        else if(num == start)
            return String.valueOf(index);
        
        while(path[num] != start) {
            num = path[num];
        }
        
        return String.valueOf(num);
    }
    
    static class Edge{
        int v, w;
        
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
