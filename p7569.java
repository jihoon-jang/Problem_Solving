import java.util.*;
import java.io.*;

public class p7569 {
	static int m, n, h, map[][][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	static boolean visit[][][], change = false;
	static Queue<coor> q = new LinkedList<coor>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		m = Integer.parseInt(s[0]);
		n = Integer.parseInt(s[1]);
		h = Integer.parseInt(s[2]);
		map = new int[h][n][m];
		visit = new boolean[h][n][m];

		for(int k = 0; k < h; k++)
			for(int i = 0; i < n; i++) {
				s = br.readLine().split(" ");
				for(int j = 0; j < m; j++)
					map[k][i][j] = Integer.parseInt(s[j]);

			}

		int count = 0;
		boolean flag = false;

		while(!flag) {
			flag = true;
			for(int k = 0; k < h; k++) {
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < m; j++) {
						if(map[k][i][j] == 1) {
							if(!visit[k][i][j]) {
								q.add(new coor(k,i,j));
								visit[k][i][j] = true;
							}
						}
					}
				}
			}
			q.add(new coor(-1, -1, -1));

			while(!q.isEmpty()) {
				coor c = q.poll();
				if(c.k == -1) {
					if(change)
						count ++;
					if(!q.isEmpty()) {
						q.add(new coor(-1, -1, -1));
						change = false;
					}
				}
				else {
					map[c.k][c.x][c.y] = 1;
					bfs(c.k, c.x, c.y);
				}
			}
		}

		boolean one = false;
		for(int k = 0; k < h; k++) 
			for(int i = 0; i < n; i++) 
				for(int j = 0; j < m; j++) { 
					if(map[k][i][j] == 1)
						one = true;
					if(map[k][i][j] == 0) {
						System.out.println(-1);
						return;
					}
				}
		if(one)
			System.out.println(count);
		else
			System.out.println(-1);
	}

	public static void bfs(int k, int x, int y) {
		for(int i = 0; i < 2; i++) {
			int nk = k;
			if(i == 0)
				nk = k - 1;
			else if(i == 1)
				nk = k + 1;

			if(check(nk, x, y) && map[nk][x][y] == 0) {
				if(!visit[nk][x][y]) {
					q.add(new coor(nk, x, y));
					visit[nk][x][y] = true;
					change = true;
				}
			}
		}

		for(int l = 0; l < 4; l++) {
			int nx = x + dx[l];
			int ny = y + dy[l];

			if(check(k, nx, ny) && map[k][nx][ny] == 0) {
				if(!visit[k][nx][ny]) {
					q.add(new coor(k, nx, ny));
					visit[k][nx][ny] = true;
					change = true;
				}
			}
		}
	}

	public static boolean check(int k, int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < m && k >= 0 && k < h;
	}
}

class coor{
	int k;
	int x;
	int y;

	coor(int k, int x, int y){
		this.k = k;
		this.x = x;
		this.y = y;
	}
}
