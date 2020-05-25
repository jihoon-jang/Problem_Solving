import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2178 {
	static int map[][], length[][];
	static boolean visit[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int n, m, answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); m = in.nextInt(); in.nextLine();
		map = new int[n][m];
		visit = new boolean[n][m];
		length = new int[n][m];
		for(int i = 0; i < n; i++) {
			String s = in.nextLine();
			for(int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}

		length[0][0] = 1;
		bfs(0,0);
		
		System.out.println(map[n-1][m-1]);
	}

	public static boolean check(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m; 
	}

	public static void bfs(int x, int y) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		qx.add(x); qy.add(y);

		while(!qx.isEmpty()) {
			x = qx.poll(); y = qy.poll();
			if(!visit[x][y] && map[x][y] != 0) {
				visit[x][y] = true;
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];	
					if(check(nx,ny) && !visit[nx][ny] && map[nx][ny] != 0) {
						qx.add(nx);
						qy.add(ny);
						map[nx][ny] = map[x][y] + 1;
					}
				}
			}
		}
	}
}

