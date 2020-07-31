import java.io.*;
import java.util.*;

public class p3055 {
	static int r, c, answer, endX=0, endY=0, startX=0, startY=0;
	static char map[][];
	static boolean visit[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static Queue<Point> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		r = Integer.parseInt(stz.nextToken());
		c = Integer.parseInt(stz.nextToken());
		answer = 0;
		map = new char[r][c];
		visit = new boolean[r][c];
		q = new LinkedList<Point>();

		for(int i = 0; i < r; i++) {
			String s = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'D') {
					endX = i;
					endY = j;
				}
				else if(map[i][j] == 'S') {
					startX = i;
					startY = j;
				}
			}
		}

		run();
	}
	
	public static void run() {
		q.add(new Point(-1, -1));
		q.add(new Point(startX, startY));

		while(!q.isEmpty()) {
			Point point = q.poll();
			
			if(point.x == -1) {
				water();
				answer++;
				if(!q.isEmpty())
					q.add(point);
				continue;
			}

			if(point.x == endX && point.y == endY) {
				System.out.println(answer-1);
				return;
			}

			next(point.x, point.y);
		}

		System.out.println("KAKTUS");
	}

	public static void water() {
		char temp[][] = new char[r][c];

		for(int i = 0 ; i < r; i++)
			for(int j = 0; j < c; j++)
				temp[i][j] = map[i][j];

		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] == '*') {
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if(check(nx, ny) && (map[nx][ny] == '.' || map[nx][ny] == 'S'))
							temp[nx][ny] = '*';
					}
				}
			}
		}

		for(int i = 0 ; i < r; i++)
			for(int j = 0; j < c; j++)
				map[i][j] = temp[i][j];
	}

	public static void next(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(check(nx, ny) && !visit[nx][ny] && (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
				visit[nx][ny] = true;
				q.add(new Point(nx, ny));
			}
		}
	}

	public static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < r && y < c;
	}

	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
