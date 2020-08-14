import java.io.*;
import java.util.*;

public class p11722 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int array[] = new int[n];
		int dp[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(stz.nextToken());
			dp[i] = 1;
		}
		
		for(int i = 0; i < n; i++) 
			for(int j = 0; j <= i; j++) 
				if(array[i] < array[j] && dp[i] <= dp[j])
					dp[i] = dp[j] + 1;
		
		int max = 0;
		for(int i : dp)
			max = Math.max(max, i);
		
		System.out.println(max);
	}

}
