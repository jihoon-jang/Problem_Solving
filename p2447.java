import java.util.Arrays;
import java.util.Scanner;

public class p2447 {
	static char map[][];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		map = new char[n][n];
		for(int i = 0; i < n; i++)
			Arrays.fill(map[i], ' ');
		dfs(0,0,n);
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				sb.append(map[i][j]);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static void dfs(int x, int y, int n) {
		if(n == 1) {
			map[x][y] = '*';
			return;
		}
		else {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(!(((3*x+i))%3 == 1 && ((3*y+j)%3) == 1))
						dfs(3*x+ i, 3*y +j , n/3);
				}
			}
		}

	}

}
