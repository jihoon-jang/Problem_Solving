import java.util.*;

public class p1932 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int dp[][] = new int[n+1][n+1];
		int a[][] = new int[n+1][n+1];

		for(int i = 1; i <= n; i++) 
			for(int j = 1; j <= i; j++) 
				a[i][j] = in.nextInt();

		dp[1][1] = a[1][1];

		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + a[i][j];
			}
		}
		int max = 0;
		for(int i = 1; i <= n; i++) {
			max = Math.max(dp[n][i], max);
		}


		System.out.println(max);
	}

}
