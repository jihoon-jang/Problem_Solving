import java.util.*;
import java.io.*;

public class p14002 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int array[] = new int[n];
		int dp[] = new int[n];
		int max = 0;
		int index = 0;
		String s[] = new String[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(stz.nextToken());
			dp[i] = 1;
			s[i] = array[i]+" ";
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(array[i] > array[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
					s[i] = s[j] + array[i]+" ";
				}
				
				if(max < dp[i]) {
					index = i;
					max = dp[i];
				}
			}
		}

		System.out.println(dp[index]+"\n"+s[index]);
	}

}
