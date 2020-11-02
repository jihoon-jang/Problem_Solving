import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1504 {
    
    static int distance[];
    static boolean visit[];
    static LinkedList<Node> list[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int e = Integer.parseInt(stz.nextToken());
        distance = new int[n+1];
        visit = new boolean[n+1];
        list = new LinkedList[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        for(int i = 0; i < e; i++) {
            stz = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(stz.nextToken());
            int v2 = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            list[v1].add(new Node(v2, w));
            list[v2].add(new Node(v1, w));
        }
        stz = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stz.nextToken());
        int b = Integer.parseInt(stz.nextToken());
        int sum1 = 0;
        int sum2 = 0;
        boolean error1 = false;
        boolean error2 = false;
        
        l :  {
            dijkstra(1);
            if(distance[a] == -1) {
                error1 = true;
                break l;
            }
            sum1 += distance[a];
            dijkstra(a);
            if(distance[b] == -1) {
                error1 = true;
                break l;
            }
            sum1 += distance[b];
            dijkstra(b);
            if(distance[n] == -1) {
                error1 = true;
                break l;
            }
            sum1 += distance[n];
        }
        
        l :
        {
            dijkstra(1);
            if(distance[b] == -1) {
                error2 = true;
                break l;
            }
            sum2 += distance[b];
            dijkstra(b);
            if(distance[a] == -1) {
                error2 = true;
                break l;
            }
            sum2 += distance[a];
            dijkstra(a);
            if(distance[n] == -1) {
                error2 = true;
                break l;
            }
            sum2 += distance[n];
        }
        
        if(!error1 && !error2)
            System.out.println(Math.min(sum1, sum2));
        else if(error1 && !error2)
            System.out.println(sum2);
        else if(!error1 && error2)
                System.out.println(sum1);
        else
                System.out.println(-1);
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance = new int[distance.length];
        visit = new boolean[visit.length];
        Arrays.fill(distance, -1);
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
    
    static class Node implements Comparable<Node>{
        int number, weight;
        
        Node(int n, int w){
            number = n;
            weight = w;
        }
        
        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
