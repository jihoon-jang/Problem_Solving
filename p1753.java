import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1753 {
    
    static LinkedList<Node> list[];
    static int distance[];
    static boolean visit[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(stz.nextToken());
        int e = Integer.parseInt(stz.nextToken());
        int start = Integer.parseInt(br.readLine());
        visit = new boolean[v+1];
        list = new LinkedList[v+1];
        distance = new int[v+1];
        Arrays.fill(distance, -1);
        for(int i = 1; i <= v; i++)
            list[i] = new LinkedList<>();
        for(int i = 0; i < e; i++) {
            stz = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(stz.nextToken());
            int v2 = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            list[v1].add(new Node(v2, w));
        }
        
        dijkstra(start);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= v; i++)
            sb.append(distance[i] == -1 ? "INF" : distance[i]).append("\n");
        System.out.print(sb.toString());
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(!visit[now.number]) {
                visit[now.number] = true;
                for(Node next : list[now.number]) {
                    if(distance[next.number] == -1 || distance[next.number] > distance[now.number] + next.weight) {
                        distance[next.number] = distance[now.number] + next.weight;
                        pq.offer(new Node(next.number, distance[next.number]));
                    }
                }
            }
        }
    }
    
    static class Node implements Comparable<Node> {
        int number, weight;
        
        Node(int n, int w) {
            this.number = n;
            this.weight = w;
        }
        
        public int compareTo(Node n) {
            return weight - n.weight;
        }
    }
}
