import java.util.Scanner;

public class p14503 {
	static int answer, n, m, map[][];
	static int r, c, d;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); m = in.nextInt(); //북 동 남 서
		r = in.nextInt(); c = in.nextInt(); d = in.nextInt();
		map = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				map[i][j] = in.nextInt();
		clean(r,c,d,1);
		System.out.println(answer);
	}

	public static boolean check(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	public static void clean(int x, int y, int dir, int count) {		
		if(map[x][y] == 0) {
			answer ++;
			map[x][y] = 2;
		}
		if(count == 5) {
			int ndir = 0;
			switch(dir) { 
			case 0: ndir = 2;break;
			case 1: ndir = 3;break;
			case 2: ndir = 0;break;
			case 3: ndir = 1;break;
			}
			int nx = x + dx[ndir];
			int ny = y + dy[ndir];
			if(map[nx][ny] != 1) {
				clean(nx, ny, dir, 1);
				return;
			}
			else 
				return;
		}

		int nx = x + dx[(dir == 0? 3: dir-1)];
		int ny = y + dy[(dir == 0? 3: dir-1)];
		if(map[nx][ny] == 0) {
			if(dir == 0)
				dir = 3;
			else
				dir -= 1;
			clean(nx, ny , dir, 1);
			return;
		}
		else {
			clean(x, y, dir == 0? 3: dir-1, count + 1);
			return;
		}

	}

}
