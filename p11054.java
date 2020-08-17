import java.util.*;
import java.io.*;

public class p11054 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int array[] = new int[n];
		int dp[][] = new int[2][n];
		Arrays.fill(dp[0], 1);
		Arrays.fill(dp[1], 1);
		int max = 0;

		for(int i = 0; i < n; i++)
			array[i] = Integer.parseInt(stz.nextToken());

		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(array[i] > array[j] && dp[0][i] <= dp[0][j])
					dp[0][i] = dp[0][j] + 1;

				dp[1][i] = Math.max(dp[0][i], dp[1][i]);
				if(array[i] < array[j]) 
					dp[1][i] = Math.max(dp[1][i], dp[1][j]+1);

				max = Math.max(dp[1][i], max);
			}
		}
		
		System.out.println(max);
	}

}
