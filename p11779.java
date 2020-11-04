import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p11779 {
    
    static LinkedList<Node> list[];
    static boolean visit[];
    static int distance[];
    static int path[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = new LinkedList[n+1];
        visit = new boolean[n+1];
        distance = new int[n+1];
        Arrays.fill(distance, -1);
        path = new int[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            list[a].add(new Node(b, w));
        }
        stz = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stz.nextToken());
        int end = Integer.parseInt(stz.nextToken());
        
        dijkstra(start);
        System.out.println(distance[end]);
        Stack<Integer> st = new Stack<>();
        
        int parent = end;
        st.push(parent);
        while(parent != start) {
            parent = path[parent];
            st.push(parent);
        }
    
        System.out.println(st.size());
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop() + " ");
        System.out.println(sb.toString());
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        path[start] = start;
        distance[start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(!visit[now.number]) {
                visit[now.number] = true;
                
                for(Node next : list[now.number]) {
                    if(distance[next.number] == -1 || distance[next.number] > distance[now.number] + next.weight) {
                        distance[next.number] = distance[now.number] + next.weight;
                        path[next.number] = now.number;
                        pq.offer(new Node(next.number, distance[next.number]));
                    }
                }
            }
        }
    }
    
    static class Node implements Comparable<Node>{
        int number, weight;
        
        Node(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
        
        public int compareTo(Node n) {
            return weight - n.weight;
        }
    }
}
