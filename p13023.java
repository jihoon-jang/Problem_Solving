import java.util.*;
import java.io.*;

public class p13023 {
	static ArrayList<Integer>[] al;
	static boolean visit[], flag = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stz.nextToken());
		int m = Integer.parseInt(stz.nextToken());
		al = new ArrayList[n];
		visit = new boolean[n];

		for(int i = 0; i < n; i++)
			al[i] = new ArrayList<Integer>();

		for(int l = 0; l < m; l++) {
			stz = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stz.nextToken());
			int b = Integer.parseInt(stz.nextToken());

			al[a].add(b);
			al[b].add(a);
		}

		for(int i = 0; i < n; i++) {
			if(flag)
				return;
			visit[i] = true;
			dfs(i, 0);
			visit[i] = false;
		}

		System.out.println(0);
	}

	public static void dfs(int p, int count) {
		if(flag)
			return;
		if(count == 4) {
			System.out.println(1);
			flag = true;
			return;
		}

		for(int i = 0; i < al[p].size(); i++) {
			int next = al[p].get(i);
			if(!visit[next]) {
				visit[next] = true;
				dfs(next, count + 1);
				visit[next] = false;
			}
		}
	}

}
