import java.util.Scanner;

public class p11724 {
	static boolean visit[];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		visit = new boolean[n+1];
		int map[][] = new int[n+1][n+1];

		for(int i = 0; i < m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}

		int answer = 0;

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(map[i][j] == 1) {
					answer ++;
					map[i][j] = 2;
					map[j][i] = 2;
					visit[i] = visit[j] = true;
					connect(i, n, map);
					connect(j, n, map);
				}
			}
		}	
		
		for(int i = 1; i <= n; i++)
			if(!visit[i])
				answer ++;
		
		System.out.println(answer);
	}

	public static void connect(int n, int x, int map[][]) {
		for(int i = 1; i <= x; i++) {
			if(map[n][i] == 1 || map[i][n] == 1) {
				map[n][i] = 2;
				map[i][n] = 2;
				visit[i] = visit[n] = true;
				connect(i, x, map);
			}
		}
	}

}
