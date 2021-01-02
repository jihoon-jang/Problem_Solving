import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p1446 {
    
    static int distance[], d;
    static PriorityQueue<Path> pq;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        d = Integer.parseInt(stz.nextToken());
        distance = new int[d+1];
        Arrays.fill(distance, -1);
        pq = new PriorityQueue<>(new Comparator<Path>() {
            @Override
            public int compare(Path o1, Path o2) {
                return o1.start - o2.start;
            }
        });
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stz.nextToken());
            int e = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());
            if(s <= d && e <= d)
                pq.offer(new Path(s, e, c));
        }
        
        dijkstra();
        System.out.println(distance[d]);
    }
    
    public static void dijkstra() {
        distance[0] = 0;
        for(int i = 0; i <= d; i++) {
            if(i != 0) {
                if(distance[i] == -1 || distance[i] > distance[i-1] + 1) {
                    distance[i] = distance[i-1] + 1;
                }
            }
            
            while(!pq.isEmpty() && pq.peek().start == i) {
                Path now = pq.poll();
                if(distance[now.end] == -1 || distance[now.end] > distance[i] + now.cost) {
                    distance[now.end] = distance[i] + now.cost;
                }
            }
        }
    }
    
    static class Path{
        int start, end, cost;
        
        Path(int s, int e, int c) {
            start = s;
            end = e;
            cost = c;
        }
    }
}
