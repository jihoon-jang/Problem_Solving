import java.util.ArrayList;
import java.util.Scanner;

public class p7576 {
	static int m, n, map[][], answer = -1;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean visit[][];
	static ArrayList<po1> al = new ArrayList<po1>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		m = in.nextInt(); n = in.nextInt();
		map = new int[n][m];

		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				map[i][j] = in.nextInt();

		while(true) {
			answer ++;
			al.clear();
			visit = new boolean[n][m];

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] == 1) {
						dfs(i, j);
					}
				}
			}
			if(al.isEmpty())
				break;
			else
				tomato();
		}
		if(perfect())
			System.out.println(answer);
		else
			System.out.println(-1);
	}

	public static boolean perfect() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	public static boolean check(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	public static void dfs(int x, int y) {
		visit[x][y] = true;
		int stack = 0;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(check(nx,ny) && map[nx][ny] == 1)
				stack ++;
			if(check(nx, ny) && map[nx][ny] == 0 && map[x][y] == 1) {
				al.add(new po1(nx, ny));
				if(!visit[nx][ny])
					dfs(nx, ny);
			}
		}
		if (stack == 4)
			map[x][y] = 2;
	}

	public static void tomato() {
		for(int i = 0; i < al.size(); i++) {
			po1 temp = al.get(i);
			int x = temp.x;
			int y = temp.y;
			if(map[x][y] == 0) {
				map[x][y] = 1;
			}
		}
	}
}

class po1{
	int x, y;
	po1(int x, int y){
		this.x = x;
		this.y = y;
	}
}