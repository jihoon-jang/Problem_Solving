import java.io.*;

public class p2225 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		long dp[][] = new long[201][201];
		
		for(int i = 0; i <= n; i++) 
			dp[1][i] = 1;
		
		for(int i = 1; i <= 200; i++) 
			for(int j = 0; j <= 200; j++) 
				for(int l = 0; l <= j; l++)
					dp[i][j] += (dp[i-1][j-l])%1000000000;
		
		System.out.println(dp[k][n]%1000000000);
	}

}
