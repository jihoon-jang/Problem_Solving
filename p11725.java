import java.io.*;
import java.util.*;

public class p11725 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] al = new ArrayList[n+1];
		for(int i = 1; i <= n; i++)
			al[i] = new ArrayList<Integer>();
		int parent[] = new int[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visit[] = new boolean[n+1];

		for(int i = 0; i < n-1; i++) {
			String s[] = br.readLine().split(" ");
			int n1 = Integer.parseInt(s[0]);
			int n2 = Integer.parseInt(s[1]);
			al[n1].add(n2);
			al[n2].add(n1);
		}

		q.add(1);

		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(!visit[now]) {
				visit[now] = true;

				for(int i = 0; i < al[now].size(); i++) {
					q.add(al[now].get(i));
					if(parent[al[now].get(i)] == 0)
					parent[al[now].get(i)] = now;
				}
			}
		}

		for(int i = 2; i <= n; i++)
			System.out.println(parent[i]);
	}

}
