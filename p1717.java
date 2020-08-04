import java.io.*;
import java.util.*;

public class p1717 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stz.nextToken());
		int m = Integer.parseInt(stz.nextToken());
		Graph g = new Graph(n+1);

		for(int i = 0; i < m; i++) {
			stz = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(stz.nextToken());
			int a = Integer.parseInt(stz.nextToken());
			int b = Integer.parseInt(stz.nextToken());

			if(op == 0) 
				g.union(a, b);
			else {
				if(g.find(a) == g.find(b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

	static class Graph{
		static int parent[];

		Graph(int n){
			parent = new int[n+1];

			for(int i = 0; i <= n; i++)
				parent[i] = i;
		}

		public static void union(int n1, int n2) {
			int p1 = find(n1);
			int p2 = find(n2);

			if(p1 > p2)
				parent[p1] = p2;
			else
				parent[p2] = p1;
		}

		public static int find(int number) {
			if(number == parent[number])
				return number;
			else
				return find(parent[number]);
		}

	}

}
