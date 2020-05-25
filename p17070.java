import java.util.Scanner;

public class p17070 {
	static int map[][];
	static int n, answer = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		map = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				map[i][j] = in.nextInt();

		dfs(0,1,'r');
		System.out.println(answer);
	}

	public static boolean check(int x, int y) {
		return x < n && y < n && x >= 0 && y >= 0;
	}

	public static boolean go(int x, int y, char dir) {
		switch(dir) {
		case 'r' : if(map[x][y] != 0) return false;  break;
		case 'l' : if(map[x][y] != 0 || map[x-1][y] != 0 || map[x][y-1] != 0) return false; break;
		case 'd' : if(map[x][y] != 0)return false; break;
		}

		return true;
	}

	public static void dfs(int x, int y, char c) {
		if(x == n-1 && y == n-1) {
			answer++;
			return;
		}
		else {
			int nx, ny;
			nx = x;
			ny = y + 1;
			if(check(nx, ny) &&(c == 'r' || c== 'l')&&go(nx, ny, 'r')) 
				dfs(nx, ny, 'r');
			nx = x +1;
			ny = y +1;
			if(check(nx, ny) &&(c == 'r' || c== 'l' || c=='d') &&go(nx, ny, 'l'))
				dfs(nx,ny, 'l');
			nx = x+1;
			ny = y;
			if(check(nx, ny) &&(c == 'd' || c== 'l') &&go(nx,ny,'d'))
				dfs(nx,ny ,'d');

		}
	}
}
