import java.util.Scanner;

public class p12865 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); 
		int k = in.nextInt();
		int[][] dp = new int[n+1][k+1];
		int[][] map = new int[n+1][2];
		for(int i = 1; i <= n; i++)
			for(int j = 0; j < 2; j++)
				map[i][j] = in.nextInt();
		
		for(int i = 1; i <= n; i++) {
			int w = map[i][0];
			int v = map[i][1];
			for(int j = 1; j <= k; j++) {
				if(j - w < 0) {
					dp[i][j] = dp[i-1][j];
					continue;
				}
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w]+v);
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
