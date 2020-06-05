import java.util.Scanner;

public class p10026 {
	static int n;
	static char map[][], map2[][];
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = Integer.parseInt(in.nextLine());
		map = new char[n][n];
		map2 = new char[n][n];
		for(int i = 0; i < n; i++) {
			String s = in.nextLine();
			map[i] = s.toCharArray();
			map2[i] = s.toCharArray();
		}

		int answer = 0;

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] != 'x') {
					answer ++;
					dfs(map[i][j], map[i][j], i, j, map);
				}
			}
		}
		System.out.print(answer+" ");

		answer = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map2[i][j] != 'x') {
					answer ++;
					if(map2[i][j] == 'R' || map2[i][j] == 'G')
						dfs('G', 'R', i, j, map2);
					else
						dfs('B', 'B', i, j, map2);
				}
			}
		}

		System.out.println(answer);

	}

	public static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < n;
	}

	public static void dfs(char c, char c2, int x, int y, char m[][]) {
		if(m[x][y] == c || m[x][y] == c2) {
			m[x][y] = 'x';
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(check(nx, ny) && m[nx][ny] != 'x') {
					dfs(c, c2, nx, ny, m);
				}
			}
		}
	}

}
