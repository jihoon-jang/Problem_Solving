import java.util.Scanner;

public class p11057 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int dp[][] = new int[n+1][10];
		for(int i = 0; i < 10; i++)
			dp[0][i] = 1;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k <= j; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		
		System.out.println(dp[n][9]);
	}

}
