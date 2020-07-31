import java.util.*;
import java.io.*;

public class p11559 {
	static final int X = 12, Y = 6;
	static char map[][] = new char[X][Y];
	static int answer;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean visit[][];
	static LinkedList<Point> list = new LinkedList<Point>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = 0;

		for(int i = 0; i < 12; i++) {
			String s = br.readLine();
			for(int j = 0; j < 6; j++)
				map[i][j] = s.charAt(j);
		}
		
		searchGroup();
		System.out.println(answer-1);
	}

	public static void searchGroup() {
		boolean finish = false;

		while(!finish) {
			finish = true;
			visit = new boolean[X][Y];
			for(int i = 0; i < X; i++) {
				for(int j = 0; j < Y; j++) {
					if(map[i][j] != '.') {
						list.clear();
						visit[i][j] = true;
						list.add(new Point(i,j));
						grouping(i, j, map[i][j]);
						if(list.size() >= 4) {
							boom();
							finish = false;
						}
					}
				}
			}
			set();
			answer ++;
		}
	}

	public static void print() {
		for(int i = 0; i < X; i++) {
			for(int j = 0; j < Y; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
		System.out.println();
	}

	public static void grouping(int x, int y, char c) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(check(nx, ny) && !visit[nx][ny]) {
				if(map[nx][ny] == c) {
					visit[nx][ny] = true;
					list.add(new Point(nx,ny));
					grouping(nx, ny, c);
				}
			}
		}
	}

	public static void boom() {
		for(int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			map[p.x][p.y] = '.';
		}
	}

	public static void set() {
		LinkedList<Character> ll = new LinkedList<Character>();
		for(int j = 0; j < Y; j++) {
			ll.clear();
			for(int i = X-1; i >= 0; i--) {
				if(map[i][j] != '.') {
					ll.add(map[i][j]);
					map[i][j] = '.';
				}
			}
			
			for(int i = 0; i < ll.size(); i++) {
				map[X-1-i][j] = ll.get(i);
			}
		}
	}

	public static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < X && y < Y;
	}

	static class Point{
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
