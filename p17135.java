import java.util.*;

public class p17135 {
	static int n, m, d, answer, map[][];
	static int hunter[] = new int[3];
	static boolean visit[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); m = in.nextInt(); d = in.nextInt();
		map = new int[n][m];
		visit = new boolean[m];
		answer = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				map[i][j] = in.nextInt();
		hunt(0,0);
		System.out.println(answer);
	}

	public static boolean check(int x, int y) { 
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	public static void detect(int numb, int x, int y, int dis) {
		int nx, ny;
		for(int i = 1; i <= dis; i++) {
			ny = y-i;
			nx = n-x;
			for(int j = 1; j <= 2*i-1; j++) { 
				if(j <= (2*i-1)/2+1) 
					nx -= 1; 
				else 
					nx += 1; 
				ny += 1;
				if(check(nx, ny) && (map[nx][ny] == 1 ||map[nx][ny] == 2 )) {
					map[nx][ny] = 2;
					h[numb] = true;
					return;
				}
			}

		}
	}
	static boolean h[];
	public static void fight() { 
		int count = 0;
		int temp[][] = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				temp[i][j] = map[i][j];

		for(int i = 0; i < n; i++) {
			h = new boolean[3];
			for(int k = 1; k <= d; k++) {
				for(int j = 0; j < 3; j++) {
					int p = hunter[j];
					if(!h[j])
						detect(j, i, p, k);
				}
			}
			for(int a = 0; a < n; a++)
				for(int j = 0; j < m; j++) {
					if(map[a][j] == 2) {
						count ++;
						map[a][j] = 3;
					}
				}
		}

		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				map[i][j] = temp[i][j];

		answer = Math.max(count, answer);
	}

	public static void hunt(int len, int start) {
		if(len == 3) { 
			fight();
			return;
		}
		else {
			for(int i = start; i < m; i++) {
				if(!visit[i]) {
					visit[i] = true;
					hunter[len] = i;
					hunt(len+1, i);
					visit[i] = false;
				}
			}
		}
	}

}

