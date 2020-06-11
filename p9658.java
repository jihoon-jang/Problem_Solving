import java.util.Scanner;

public class p9658 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int dp[] = new int[1001];
		dp[2] = 1;
		dp[4] = 1;
		
		for(int i = 5; i <= 1000; i++) {
			if(dp[i-1] == 0 || dp[i-3] == 0 || dp[i-4] == 0)
				dp[i] = 1;
		}
		
		System.out.println(dp[n] == 1 ? "SK" : "CY");
		
	}

}
