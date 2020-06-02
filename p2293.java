import java.util.Scanner;

public class p2293 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int coin[] = new int[n];
		for(int i = 0; i < n; i++) 
			coin[i] = in.nextInt();
		
		int dp[] = new int[k+1];
		dp[0] = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = 1; j <= k; j++) {
				int now = coin[i];
				if(j >= now)
					dp[j] += dp[j-now];
			}
		}
		System.out.println(dp[k]);
	}

}
