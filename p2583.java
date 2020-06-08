import java.util.*;

public class p2583 {
	static int m, n, k, map[][], answer = 0, count;
	static int dx[] = {1,-1,0,0}, dy[] = {0,0,-1,1};
	static ArrayList<Integer> al = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		k = in.nextInt();
		map = new int[m][n];

		for(int i = 0; i < k; i++) {
			int y1 = in.nextInt();
			int x1 = in.nextInt();
			int y2 = in.nextInt();
			int x2 = in.nextInt();

			for(int x = x1; x < x2; x++) {
				for(int y = y1; y < y2; y++) {
					map[x][y] = 1;
				}
			}

		}

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0) {
					answer ++;
					count = 0;
					count ++;
					map[i][j] = 1;
					dfs(i, j);
					al.add(count);
				}
			}
		}
		
		System.out.println(answer);
		Collections.sort(al);
		for(int i : al)
			System.out.print(i+" ");
	}

	public static boolean check(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}

	public static void dfs(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(check(nx, ny) && map[nx][ny] == 0) {
				count ++;
				map[nx][ny] = 1;
				dfs(nx, ny);
			}
		}
	}

}
