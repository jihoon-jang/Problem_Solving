import java.io.*;
import java.util.*;

public class p1261 {
	static int n, m, map[][];
	static int value[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		m = Integer.parseInt(stz.nextToken());
		map = new int[m][n];
		value = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			Arrays.fill(value[i], Integer.MAX_VALUE);
			for(int j = 0; j < n; j++)
				map[i][j] = s.charAt(j)-'0';
		}
		
		search();
	}
	
	public static void search() {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		qx.add(0);
		qy.add(0);
		value[0][0] = 0;
		
		while(!qx.isEmpty()) {
			int x = qx.poll();
			int y = qy.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(check(nx, ny)) {
					if(map[nx][ny] == 1 && (value[nx][ny] == Integer.MAX_VALUE || value[nx][ny] > value[x][y] + 1)) {
						value[nx][ny] = value[x][y] + 1;
						qx.add(nx);
						qy.add(ny);
					}
					else if(map[nx][ny] == 0 && (value[nx][ny] == Integer.MAX_VALUE || value[nx][ny] > value[x][y])) {
						value[nx][ny] = value[x][y];
						qx.add(nx);
						qy.add(ny);
					}
				}
			}
		}
		
		System.out.println(value[m-1][n-1]);
	}
	
	public static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < m && y < n;
	}

}
