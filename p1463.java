import java.util.Scanner;

public class p1463 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int dp[] = new int[n+1];
		if(n>1)
			dp[2] = 1;
		if(n>2)
			dp[3] = 1;

		for(int i = 4; i <= n; i++) {
			dp[i] = dp[i-1] + 1;
			if(i%3==0)
				dp[i] = Math.min(dp[i/3] +1, dp[i]);
			if(i%2==0)
				dp[i] = Math.min( dp[i],dp[i/2] +1);
		}
		System.out.println(dp[n]);
		in.close();
	}

}
