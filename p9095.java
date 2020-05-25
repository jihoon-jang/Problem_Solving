import java.util.Scanner;

public class p9095 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int dp[] = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i <= 10; i++) {
			dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
		}
		
		for(int i = 0; i < t; i++) {
			int n = in.nextInt();
			System.out.println(dp[n]);
		}

	}

}
