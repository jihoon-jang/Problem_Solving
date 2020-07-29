import java.util.*;

public class p15684 {
	static int n, m, h, map[][];
	static boolean flag = false;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		m = in.nextInt();
		h = in.nextInt();
		map = new int[h+1][n];
		int count = 0;

		for(int i = 0; i < m; i++) {
			int a = in.nextInt();
			int b = in.nextInt()-1;

			map[a][b] = 1;
			if(b+1 < n)
				map[a][b+1] = 2;
		}
		if(firstCheck()) {
			System.out.println(-1);
			return;
		}

		for(int i = 0; i <= 3; i++)
			dfs(0, 0, 0, i);
		if(!flag)
			System.out.println(-1);
	}

	public static boolean finalCheck() {
		
		for(int i = 0; i < n-1; i++) {
			int o = i;
			for(int j = 1; j <= h; j++) {
				if(map[j][o] == 1)
					o++;
				else if(map[j][o] == 2)
					o--;
			}
			if(o != i)
				return false;
		}
		return true;
	}

	public static void dfs(int x, int y, int count, int size) {
		if(flag) 
			return;
		if(count == size) {
			if(finalCheck()) {
				System.out.println(size);
				flag = true;
			}
			return;
		}

		for(int j = y; j < n-1; j++) {
			for(int i = x; i <= h; i++) {
				if(map[i][j] != 0 || (j+1 < n && map[i][j+1] == 1)) 
					continue;

				int temp=0;
				map[i][j] = 1;
				if(j+1 < n) {
					temp = map[i][j+1];
					map[i][j+1] = 2;
				}	
				dfs(x, y, count + 1, size);
				map[i][j] = 0;
				if(j+1 < n)
					map[i][j+1] = temp;
			}
			x = 0;
		}
	}

	public static boolean firstCheck() {
		int odd = 0;

		int temp = 0;
		for(int j = 0; j < n-1; j++) {
			for(int i = 1; i <= h; i++) {
				if(map[i][j] == 1)
					temp ++;
			}
			if(temp % 2 == 1)
				odd ++;
		temp = 0;
		}
		if(odd > 3)
			return true;
		else 
			return false;
	}

}
