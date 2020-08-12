import java.util.*;
import java.io.*;

public class p16194 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int array[] = new int[n+1];
		int dp[] = new int[n+1];
		for(int i = 1; i <= n; i++)
			array[i] = Integer.parseInt(stz.nextToken());
		
		for(int i = 1; i <= n; i++) {
			int temp = 0;
			dp[i] = array[i];
			for(int j = 0; j <= i/2; j++) 
				dp[i] = Math.min(dp[j] + dp[i-j], dp[i]);
		}
		
		System.out.println(dp[n]);
	}

}
