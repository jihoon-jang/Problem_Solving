import java.util.Scanner;

public class p9465 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();

		for(int t = 0; t < tc; t++) {
			int n = in.nextInt();
			int array[][] = new int[2][n+1];
			int dp[][] = new int[2][n+1];
			
			for(int i = 0; i < 2; i++) 
				for(int j = 1; j <= n; j++) 
					array[i][j] = in.nextInt();

			dp[0][1] = array[0][1];
			dp[1][1] = array[1][1];
			
			for(int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + array[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + array[1][i];
			}
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}

}
