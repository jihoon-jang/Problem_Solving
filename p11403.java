import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p11403 {
	static int n, map[][], answer[][];
	static boolean visit[];
	static Queue<Integer> q;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		map = new int[n+1][n+1];
		answer = new int[n+1][n+1];
		q = new LinkedList<Integer>();

		for(int i = 1; i <= n; i++) 
			for(int j = 1; j <= n; j++) 
				map[i][j] = in.nextInt();

		for(int i = 1; i <= n; i++) {
			visit = new boolean[n+1];
			for(int j = 1; j <= n; j++) {
				if(map[i][j] == 1 && !visit[j]) {
					q.add(j);
				}
			}
			while(!q.isEmpty()) {
				int number = q.poll();
				visit[number] = true;
				answer[i][number] = 1;
				dfs(i, number);
			}
		}

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) 
				System.out.print(answer[i][j] + " ");
			System.out.println();
		}

	}

	public static void dfs(int st, int line) {
		for(int i = 1; i <= n; i++) {
			if(map[line][i] == 1 && !visit[i]) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int number = q.poll();
			visit[number] = true;
			answer[st][number] = 1;
			dfs(st, number);
		}

	}

}
