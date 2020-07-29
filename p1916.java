import java.io.*;
import java.util.*;

public class p1916 {
	static int n, m, start, destination;
	static boolean[] visit;
	static List<Graph>[] al;
	static int value[];

	public static void main(String[] args) throws Exception{
		init();
		dijkstra();
		System.out.println(value[destination]);
	} 

	public static void dijkstra() {
		PriorityQueue<Graph> pq = new PriorityQueue<Graph>();
		pq.add(new Graph(start, 0));
		value[start] = 0;

		while(!pq.isEmpty()) {
			Graph g = pq.poll();
			int now = g.vertex;

			if(!visit[now]) {
				visit[now] = true;
				for(int i = 0; i < al[now].size(); i++) {
					if(value[al[now].get(i).vertex] == -1 || 
							value[al[now].get(i).vertex] > value[now] + al[now].get(i).weight) {
						value[al[now].get(i).vertex] = 
								value[now] + al[now].get(i).weight;
						pq.add(new Graph(al[now].get(i).vertex, value[al[now].get(i).vertex]));
					}
				}
			}	
		}
	}

	public static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		visit = new boolean[n+1];
		value = new int[n+1];
		al = new ArrayList[n+1];
		Arrays.fill(value, -1);
		String[] s;

		for(int i = 1; i <= n; i++)
			al[i] = new ArrayList<Graph>();

		for(int i = 0; i < m; i++) {
			s = br.readLine().split(" ");
			int st = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			int weight = Integer.parseInt(s[2]);
			al[st].add(new Graph(end, weight));
		}

		s = br.readLine().split(" ");
		start = Integer.parseInt(s[0]);
		destination = Integer.parseInt(s[1]);
	}

	static class Graph implements Comparable<Graph>{
		int vertex;
		int weight;

		Graph(int v, int w){
			this.vertex = v;
			this.weight = w;
		}

		public int compareTo(Graph o) {
			return weight- o.weight;
		}
	}
}
