import java.io.*;

public class p17626 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[n+1];
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			
			for(int j = 1; j*j <= i; j++) 
				min = Math.min(min, dp[i-j*j]);
			
			dp[i] = min + 1;
			
		}

		bw.write(String.valueOf(dp[n]));
		bw.flush();
		
	}

}
