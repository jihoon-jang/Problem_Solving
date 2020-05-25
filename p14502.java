import java.util.Scanner;

public class p14502 {
	static int map[][];
	static boolean visit[][];
	static int n, m;
	static int answer =0;
	static boolean vi[][];
	static int dx[] = {-1,0,0,1};
	static int dy[] = {0,-1,1,0};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < m; j++)
				map[i][j] = in.nextInt();

		boolean t[][] = new boolean[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				t[i][j] = visit[i][j];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visit[i][j] = true;
				for(int a = 0; a < n; a++)
					for(int b = 0; b < m; b++)
						t[a][b] = visit[a][b];
				if(map[i][j] == 0) {
					map[i][j] = 1;
					wall(i,j,1);
					for(int a = 0; a < n; a++)
						for(int b = 0; b < m; b++)
							visit[a][b] = t[a][b];
					map[i][j] = 0;
				}
			}
		}
		System.out.println(answer);
	}

	public static void wall(int x, int y, int cnt) {
		if(cnt == 3)
			return;

		for(int i = 0; i < n; i++) 
			for(int j = 0 ; j< m; j++) {
				if(!visit[i][j] && map[i][j] == 0 && cnt < 2) {
					map[i][j] = 1;
					visit[i][j] = true;
					wall(i, j, cnt+1);
					map[i][j] = 0;
				}
				else if(!visit[i][j] && map[i][j] == 0 && cnt == 2) {
					map[i][j] = 1;	
					virus();
					map[i][j] = 0;
				}
			}
	}

	public static boolean check(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y <m;
	}
	public static void cal() {
		int cnt =0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0)
					cnt++;
			}
		}
		
		answer = Math.max(answer, cnt);
	}

	public static void virus() {
		int temp[][] = new int[n][m];
		for(int a = 0; a < n; a++)
			for(int b = 0 ; b < m; b++)
				temp[a][b] = map[a][b];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 2) {
					virus(i, j);
				}
			}
		}
		cal();
		for(int a = 0; a < n; a++)
			for(int b = 0 ; b < m; b++)
				map[a][b] = temp[a][b];
	}


	public static void virus(int x, int y) {
		map[x][y] = 2;
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			if(check(tx,ty) && map[tx][ty] == 0) {
				virus(tx,ty);
			}
		}
	}

}
