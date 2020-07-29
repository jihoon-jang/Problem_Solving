import java.io.*;
import java.util.*;

public class p2468 {
	static int n, map[][], max, answer;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		map = new int[n][n];
		answer = 0;
		max = 0;
		
		for(int i = 0; i < n; i++) {
			stz = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		for(int i = 0; i <= max; i++) 
			rain(i);
		
		System.out.println(answer);
	}
	
	public static void rain(int amount) {
		int temp[][] = new int[n][n];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++) {
				temp[i][j] = map[i][j];
				if(temp[i][j] < amount)
					temp[i][j] = -1;
			}
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(temp[i][j] != -1 && temp[i][j] != 999) {
					temp[i][j] = 999;
					sink(temp, i, j, 999);
					count ++;
				}
			}
		}
		
		answer = Math.max(count, answer);
	}
	
	public static void sink(int temp[][], int x, int y, int count) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(check(nx, ny) && temp[nx][ny] != -1 && temp[nx][ny] != 999) {
				temp[nx][ny] = count;
				sink(temp, nx, ny, count);
			}
		}
	}
	
	public static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < n; 
	}
	

}
