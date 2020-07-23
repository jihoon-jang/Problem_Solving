import java.io.*;
import java.util.*;

public class p1753{
	static int v, e, start;
	static int value[];
	static boolean visit[];
	static List<Node>[] al; 

	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}

	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		v = Integer.parseInt(s[0]);
		e = Integer.parseInt(s[1]);
		start = Integer.parseInt(br.readLine());
		al = new ArrayList[v+1];
		value = new int[v+1];
		visit = new boolean[v+1];
		Arrays.fill(value, -1);

		for(int i = 1; i < al.length; i++)
			al[i] = new ArrayList<Node>();

		for(int i = 0; i < e; i++) {
			s = br.readLine().split(" ");
			al[Integer.parseInt(s[0])].add(new Node(Integer.parseInt(s[1]), Integer.parseInt(s[2])));
		}
	}

	public static void solve() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));
		value[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.vertex;
			
			if(!visit[now]) {
				visit[now] = true;

				for(int i = 0; i < al[now].size(); i++) {
					if(value[al[now].get(i).vertex] == -1 || 
							value[al[now].get(i).vertex] > value[now] + al[now].get(i).weight) {
						value[al[now].get(i).vertex] = value[now] + al[now].get(i).weight;
						pq.add(new Node(al[now].get(i).vertex, value[al[now].get(i).vertex]));
					}
				}
			}
		}
	}

	public static void print() {
		StringBuilder sb = new StringBuilder();

		for(int i = 1; i <= v; i++)
			if(value[i] == -1)
				sb.append("INF\n");
			else
				sb.append(value[i]+"\n");

		System.out.println(sb.toString());
	}

	static class Node implements Comparable<Node> {
		int vertex;
		int weight;

		Node(int v, int w) {
			vertex = v;
			weight = w;
		}

		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
}

