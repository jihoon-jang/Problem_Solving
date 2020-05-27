import java.util.Scanner;

public class p11727 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int dp[] = new int[n < 2 ? 2 : n];
		dp[0] = 1;
		dp[1] = 3;
		
		for(int i = 2; i < n; i++)
			dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
		System.out.println(dp[n-1]%10007);
	}

}
