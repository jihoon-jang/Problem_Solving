import java.util.Scanner;

public class p14501 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int map[][] = new int[2][n+2];
		int dp[] = new int[n+7];
		
		for(int i = 1; i <= n; i++) {
			map[0][i] = in.nextInt();
			map[1][i] = in.nextInt();
		}
		
		for(int i = 1; i <= n+1; i++) {
			dp[i] = Math.max(dp[i-1], dp[i]);
			dp[i+map[0][i]] = Math.max(dp[i+map[0][i]], dp[i]+map[1][i]);
		}
		System.out.println(dp[n+1]);
	}

}
