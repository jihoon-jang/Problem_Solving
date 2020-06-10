import java.util.Scanner;

public class p1010 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();

		for(int t = 0; t < tc; t++) {
			int n = in.nextInt();
			int m = in.nextInt();
			long dp[][] = new long[31][31];//n, m은 최대 30까지.
			
			for(int i = 1; i <= 30; i++) 
				dp[1][i] = i;			//초기값
			
			for(int i = 2; i <= n; i++) {
				for(int j = i; j <= m; j++) {
					for(int k = 1; k <= j-i+1; k++) {
						dp[i][j] += dp[i-1][j-k];		//점화식
					}
				}
			}
			
			System.out.println(dp[n][m]);
		}
		
	}

}
