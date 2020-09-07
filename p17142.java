import java.util.*;
import java.io.*;

public class p17142 {

	public static int n, m, answer, map[][];
	public static ArrayList<Point> al = new ArrayList<>();
	public static boolean visit[];
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		m = Integer.parseInt(stz.nextToken());
		answer = Integer.MAX_VALUE;
		map = new int[n][n];

		for(int i = 0; i < n; i++) {
			stz = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
				if(map[i][j] == 2)
					al.add(new Point(i, j));
			}
		}
		visit = new boolean[al.size()];
		per(0, 0, new int[m]);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	public static void per(int length, int start, int array[]) {
		if(length == m) {
			virus(array);
			return;
		}

		for(int i = start; i < al.size(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				array[length] = i;
				per(length+1, i, array);
				visit[i] = false;
			}
		}
	}

	public static void virus(int array[]) {
		Queue<Point> q = new LinkedList<Point>();
		int time = 0;
		int temp = 1;
		boolean count = false;
		boolean history[][] = new boolean[n][n];

		for(int i = 0; i < array.length; i++) {
			Point now = al.get(array[i]);
			q.add(now);
			history[now.x][now.y] = true;
		}
		q.add(new Point(-1, -1));

		while(!q.isEmpty()) {
			Point now = q.poll();

			if(now.x == -1) {
				if(count) {
					time += temp;
					temp = 1;
				}
				else
					temp++;
				count = false;
				if(!q.isEmpty())
					q.add(now);
				continue;
			}

			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if(check(nx, ny) && !history[nx][ny]) {
					history[nx][ny] = true;
					q.add(new Point(nx, ny));
					if(map[nx][ny] != 2)
						count = true;
				}
			}
		}

		for(int i = 0; i < n; i++) 
			for(int j = 0; j < n; j++) 
				if(!history[i][j] && map[i][j] != 1)
					return;

		answer = Math.min(answer, time);
	}

	public static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < n && map[x][y] != 1;
	}

	static class Point{
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
