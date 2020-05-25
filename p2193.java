import java.util.Scanner;

public class p2193 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long dp[] = new long[91];
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 3; i <= 90; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		System.out.println(dp[n]);
	}

}
