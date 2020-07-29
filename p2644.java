import java.util.*;
import java.io.*;

public class p2644 {
	static int n, a, b;
	static ArrayList<Integer>[] al;
	static boolean visit[];
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(stz.nextToken());
		b = Integer.parseInt(stz.nextToken());
		al = new ArrayList[n+1];
		visit = new boolean[n+1];

		for(int i = 1; i <= n; i++)
			al[i] = new ArrayList<Integer>();
		
		int loop = Integer.parseInt(br.readLine());
		
		for(int l = 0; l < loop; l++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(stz.nextToken());
			int c = Integer.parseInt(stz.nextToken());
			
			al[p].add(c);
			al[c].add(p);
		}
		
		find();
	}
	
	public static void find() {
		Queue<Integer> q = new LinkedList<Integer>();
		int value[] = new int[n+1];
		value[a] = 0;
		q.add(a);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i = 0; i < al[now].size(); i++) {
				if(!visit[al[now].get(i)]) {
					visit[al[now].get(i)] = true;
					value[al[now].get(i)] = value[now] + 1;
					q.add(al[now].get(i));
				}
			}
		}
		System.out.println(value[b] == 0 ? -1 : value[b]);
	}

}
