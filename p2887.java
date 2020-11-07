import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p2887 {
    
    static int n, parent[];
    static Planet planet[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer stz;
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
        planet = new Planet[n];
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stz.nextToken());
            int y = Integer.parseInt(stz.nextToken());
            int z = Integer.parseInt(stz.nextToken());
            planet[i] = new Planet(i, x, y, z);
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        ArrayList<Planet> sortX = new ArrayList<Planet>(Arrays.asList(planet));
        Collections.sort(sortX, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.x - o2.x;
            }
        });
        ArrayList<Planet> sortY = new ArrayList<Planet>(Arrays.asList(planet));
        Collections.sort(sortY, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.y - o2.y;
            }
        });
        ArrayList<Planet> sortZ= new ArrayList<Planet>(Arrays.asList(planet));
        Collections.sort(sortZ, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.z - o2.z;
            }
        });
        
        for(int i = 0; i < n-1; i++) {
            Planet p1 = sortX.get(i);
            Planet p2 = sortX.get(i+1);
            pq.offer(new Edge(p1.number, p2.number, Math.min(Math.abs(p1.x-p2.x), Math.min(Math.abs(p1.y-p2.y), Math.abs(p1.z - p2.z)))));
            p1 = sortY.get(i);
            p2 = sortY.get(i+1);
            pq.offer(new Edge(p1.number, p2.number, Math.min(Math.abs(p1.x-p2.x), Math.min(Math.abs(p1.y-p2.y), Math.abs(p1.z - p2.z)))));
            p1 = sortZ.get(i);
            p2 = sortZ.get(i+1);
            pq.offer(new Edge(p1.number, p2.number, Math.min(Math.abs(p1.x-p2.x), Math.min(Math.abs(p1.y-p2.y), Math.abs(p1.z - p2.z)))));
        }
        
        long weight = 0;
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if(find(now.v1) != find(now.v2)) {
                union(now.v1, now.v2);
                weight += now.weight;
            }
        }
        System.out.println(weight);
    }
    
    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        
        if(p1 > p2)
            parent[p1] = p2;
        else
            parent[p2] = p1;
    }
    
    public static int find(int n) {
        if(parent[n] == n)
            return n;
        
        return parent[n] = find(parent[n]);
    }
    
    static class Planet {
        int number, x, y, z;
        
        Planet(int n, int x, int y, int z) {
            number = n;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    static class Edge implements Comparable<Edge> {
        int v1, v2, weight;
        
        Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
        
        public int compareTo(Edge e) {
            return weight - e.weight;
        }
    }
}
