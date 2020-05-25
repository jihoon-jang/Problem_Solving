import java.util.Scanner;

public class p11726 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long dp[] = new long[1001];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i < 1001; i++)
			dp[i] = (dp[i-2]+dp[i-1])%10007;
		System.out.println(dp[n]%10007);
	}

}
