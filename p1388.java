import java.io.*;
import java.util.*;

public class p1388 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stz.nextToken());
		int m = Integer.parseInt(stz.nextToken());
		char map[][] = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) 
				map[i][j] = s.charAt(j);
		}
		
		count(map, n, m);
	}
	
	public static void count(char map[][], int n, int m) {
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				count++;
				if(map[i][j] == '-' && j > 0 && map[i][j-1] == '-')
					count--;
				if(map[i][j] == '|' && i > 0 && map[i-1][j] == '|')
					count--;
			}
		}
		
		System.out.println(count);
	}

}
