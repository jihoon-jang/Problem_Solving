import java.util.Scanner;

public class p9660 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int dp[] = new int[1001];
		dp[1] = 1;
		dp[3] = 1;
		dp[4] = 1;
		
		for(int i = 5; i <= 1000; i++) {
			if(dp[i-1] == 0 || dp[i-3] == 0 || dp[i-4] == 0)
				dp[i] = 1;
		}
		System.out.println(dp[n] == 1 ? "SK" : "CY");
		
	}

}
