import java.io.*;
import java.util.*;

public class p7562 {
	static int dx[] = {-2,-2,2,2,-1,1,-1,1};
	static int dy[] = {-1,1,-1,1,-2,-2,2,2};
	static int i, nowX, nowY, endX, endY;
	static boolean visit[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(stz.nextToken());

		for(int t = 0; t < tc; t++) {
			stz = new StringTokenizer(br.readLine());
			i = Integer.parseInt(stz.nextToken());
			visit = new boolean[i][i];
			stz = new StringTokenizer(br.readLine());
			nowX = Integer.parseInt(stz.nextToken());
			nowY = Integer.parseInt(stz.nextToken());
			stz = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(stz.nextToken());
			endY = Integer.parseInt(stz.nextToken());
			knight();
		}

	}

	public static void knight() {
		Queue<Point> q = new LinkedList<Point>();
		int count = 0;
		visit[nowX][nowY] = true;
		q.add(new Point(nowX, nowY));
		q.add(new Point(-1, -1));

		while(!q.isEmpty()) {
			Point p = q.poll();

			if(p.x == endX && p.y == endY){
				System.out.println(count);
				return;
			}

			if(p.x == -1) {
				count++;
				if(q.size() > 0)
					q.add(new Point(-1, -1));
				continue;
			}

			for(int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if(check(nx, ny) && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
	}

	public static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < i && y < i;
	}

	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
