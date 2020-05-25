import java.util.ArrayList;
import java.util.Scanner;

public class p7576_1 {
	static int m, n, map[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		m = in.nextInt(); n = in.nextInt();
		map = new int[n][m];

		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				map[i][j] = in.nextInt();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1) {
					dfs(i, j);
				}
			}
		}

		perfect();
	}

	public static void perfect() {
		int max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, map[i][j]);
			}
		}
		
		System.out.println(max-1 == -2 ? -1 : max-1);
	}

	public static boolean check(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	public static void dfs(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(check(nx, ny) && map[nx][ny] != 1) {
				int value = Integer.MAX_VALUE;
				for(int j = 0; j < 4; j++) {
					int mx = nx + dx[j];
					int my = ny + dy[j];
					if(check(mx,my)) {
						if(map[mx][my] != 0 && map[mx][my] != -1) {
							value = Math.min(value, map[mx][my]);
						}
					}
				}
				if(map[nx][ny] == 0) {
					map[nx][ny] = value+1;
					dfs(nx, ny);
				}

				if(value+1 < map[nx][ny]) {
					map[nx][ny] = value + 1;
					dfs(nx, ny);
				}

			}
		}
	}

}