import java.util.*;
import java.io.*;

public class p14391 {
	static int n, m, answer, map[][];
	static boolean visit[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		m = Integer.parseInt(stz.nextToken());
		answer = 0;
		map = new int[n][m];
		visit = new boolean[n][m];

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++)
				map[i][j] = s.charAt(j) - '0';
		}

		divide(0, 0);
		System.out.println(answer);
	}	

	public static void divide(int x, int y) {
		if(y == m) {
			x++;
			y = 0;
		}

		if(x == n) {
			max();
			return;
		}

		visit[x][y] = true;
		divide(x, y+1);
		visit[x][y] = false;

		divide(x, y+1);
	}

	public static void max() {
		int sum = 0;
		boolean temp[][] = new boolean[n][m];
	
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!temp[i][j] && visit[i][j]) {
					String number = ""+map[i][j];
					for(int k = 1; k+j < m && visit[i][j+k]; k++) {
						temp[i][j+k] = true;
						number += map[i][j+k];
					}
					sum += Integer.parseInt(number);
				}
				else if(!temp[i][j] && !visit[i][j]) {
					String number = ""+map[i][j];
					for(int k = 1; k+i < n && !visit[i+k][j]; k++) {
						temp[i+k][j] = true;
						number += map[i+k][j];
					}
					sum += Integer.parseInt(number);	
				}
			}
		}
		answer = Math.max(answer, sum);
	}

}
