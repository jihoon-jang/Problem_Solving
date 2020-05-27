import java.util.Scanner;

public class p11053 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);	
		int n = in.nextInt();
		int array[] = new int[n];
		int dp[] = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = in.nextInt();
			dp[i] = 1;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(array[i] > array[j] && dp[i] <= dp[j])
					dp[i] = dp[j] + 1;
			}
		}
		int max = 0;
		for(int i : dp)
			max = Math.max(i, max);
		System.out.println(max);
	}

}
