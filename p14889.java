import java.util.*;

public class p14889 {
	static int map[][];
	static int check[];
	static int n;
	static int gap = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		map = new int[n+1][n+1];
		check = new int[n+1];
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				map[i][j] = in.nextInt();

		check[1] = 1;
		dfs(1, 1);
		System.out.println(gap);
	}
	
	public static void cal() {
		int a[] = new int[n/2];
		int b[] = new int[n/2];
		int a_index = 0, b_index = 0;
		for(int i = 1; i <= n; i++) {
			if(check[i] == 1)
				a[a_index++] = i;
			else
				b[b_index++] = i;
		}
		
		int start = 0;
		int link = 0;
		
		for(int i = 0; i < n/2-1; i++) {
			for(int j = i+1; j < n/2; j++) {
				start += map[a[i]][a[j]] + map[a[j]][a[i]];
				link += map[b[i]][b[j]] + map[b[j]][b[i]];
			}
		}
		
		gap = Math.min(gap, Math.abs(start-link));
	}
	
	public static void dfs(int number, int count) {
		if(count == n/2) {
			cal();
		}
		else {
			for(int i = number + 1; i <= n; i++) {
				if(check[i] == 0) {
					check[i] = 1;
					dfs(i, count+1);
					check[i] = 0;
				}
			}
		}
	}

}
