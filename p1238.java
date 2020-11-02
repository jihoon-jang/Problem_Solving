import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1238 {
    
    static int distance[];
    static boolean visit[];
    static LinkedList<Node> list[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int x = Integer.parseInt(stz.nextToken());
        distance = new int[n+1];
        visit = new boolean[n+1];
        list = new LinkedList[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            list[a].add(new Node(b, w));
        }
        
        int time[] = new int[n+1];
        for(int i = 1; i <= n; i++) {
            dijkstra(i);
            time[i] += distance[x];
        }
        
        dijkstra(x);
        for(int i = 1; i <= n; i++)
            time[i] += distance[i];
        
        int max = 0;
        for(int i = 1; i <= n; i++)
            max = Math.max(max, time[i]);
    
        System.out.println(max);
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        visit = new boolean[visit.length];
        distance = new int[distance.length];
        Arrays.fill(distance, -1);
        distance[start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(!visit[now.num]) {
                visit[now.num] = true;
                
                for(Node next : list[now.num]) {
                    if(distance[next.num] == -1 || distance[next.num] > distance[now.num] + next.w) {
                        distance[next.num] = distance[now.num] + next.w;
                        pq.offer(new Node(next.num, distance[next.num]));
                    }
                }
            }
        }
    }
    
    static class Node implements Comparable<Node>{
        int num, w;
        
        Node(int num, int w) {
            this.num = num;
            this.w = w;
        }
    
        public int compareTo(Node o) {
            return w-o.w;
        }
    }
}
