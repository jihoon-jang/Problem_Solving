import java.io.*;
import java.util.*;

public class p1717 {
	
	static int parent[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stz.nextToken());
		int m = Integer.parseInt(stz.nextToken());
		parent = new int[n+1];
		for(int i = 0; i <= n; i++)
			parent[i] = i;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < m; i++) {
			stz = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(stz.nextToken());
			int a = Integer.parseInt(stz.nextToken());
			int b = Integer.parseInt(stz.nextToken());
			
			if(op == 0)
				union(a, b);
			else {
				if(find(a) == find(b))
					sb.append("YES").append("\n");
				else
					sb.append("NO").append("\n");
			}
		}
		
		System.out.println(sb.toString());
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
		
		return parent[number] = find(parent[number]);
	}
}
