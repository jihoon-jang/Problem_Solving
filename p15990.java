import java.io.*;

public class p15990 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long dp[][] = new long[100001][4];
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		for(int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
			dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009;
			dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1000000009;
		}
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			long sum = 0;
			
			for(int i = 1; i <= 3; i++)
				sum += dp[n][i];
			
			System.out.println(sum % 1000000009);
		}
	}

}
