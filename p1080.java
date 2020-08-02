import java.util.Scanner;

public class p1080 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		in.nextLine();
		int map[][] = new int[n][m];
		int change[][] = new int[n][m];
		for(int i = 0; i < n; i++) {
			String s = in.nextLine();
			char c[] = s.toCharArray();
			for(int j = 0; j < m; j++) 
				map[i][j] = c[j]-'0';
		}
		for(int i = 0; i < n; i++) {
			String s = in.nextLine();
			char c[] = s.toCharArray();
			for(int j = 0; j < m; j++) 
				change[i][j] = c[j]-'0';
		}
		int cnt = 0;
		for(int i = 0; i <= n-3; i++) { 
			for(int j = 0; j <= m-3; j++) {
				if(map[i][j] != change[i][j]) {
					cnt ++;
					paint(i, j, map);
				}
			}
		}
		if(check(n, m, map, change))
			System.out.println(cnt);
		else 
			System.out.println(-1);

	}
	
	public static void paint(int x, int y, int map[][]) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(map[x+i][y+j] == 1)
					map[x+i][y+j] = 0;
				else
					map[x+i][y+j] = 1;
					
			}
		}
	}

	public static boolean check(int n, int m, int map[][], int change[][]) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] != change[i][j])
					return false;
			}
		}
		
		return true;
	}
}
