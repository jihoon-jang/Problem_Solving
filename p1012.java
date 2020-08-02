import java.util.Scanner;

public class p1012 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	static int count, m, n, k;
	static int map[][];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for(int t = 0; t < tc; t++) {
			m = in.nextInt();
			n = in.nextInt();
			k = in.nextInt();
			count = 0;

			map = new int[m][n];
			for(int i = 0; i < k; i++) {
				map[in.nextInt()][in.nextInt()] = 1;
			}

			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == 1) {
						dfs(i, j, count+2);
						count++;
					}
				}
			}
			System.out.println(count);
		}

	}

	public static boolean check(int x, int y) {
		return x >= 0 && x < m && y < n && y >= 0;
	}

	public static void dfs(int x, int y, int num) {
		map[x][y] = num;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(check(nx,ny) && map[nx][ny] == 1) 
				dfs(nx, ny, num);

		}
	}

}
