import java.util.*;

class Solution {
    //크루스칼 알고리즘 사용(우선순위 큐 + 유니온 파인드)
    int parent[];
    public int solution(int n, int[][] costs) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>(){
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
        for(int i = 0; i < costs.length; i++)
            pq.offer(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        
        int weight = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            
            if(find(now.v1) != find(now.v2)) {
                union(now.v1, now.v2);
                weight += now.weight;
            }
        }
        return weight;
    }
    
    public void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        
        if(p1 > p2)
            parent[p1] = p2;
        else
            parent[p2] = p1;
    }
    
    public int find(int n) {
        if(parent[n] == n)
            return n;
        
        return parent[n] = find(parent[n]);
    }
    
    class Edge {
        int v1, v2, weight;
        
        Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }
}