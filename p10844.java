import java.util.Scanner;

public class p10844 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long dp[][] = new long[n+1][10];

		for(int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
			if(n >=2 ) {
				if(i != 9)
					dp[2][i] = 2;
				else
					dp[2][i] = 1;
			}
		}
		if(n>=3) {
			for(int i = 3; i <= n; i++) {
				for(int j = 1; j <= 9; j++) {
					if(j== 1) 
						dp[i][j] =(dp[i-1][j+1] + dp[i-2][j])%1000000000;
					else if(j==9)
						dp[i][j] =(dp[i-1][j-1])%1000000000;
					else
						dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
				}
			}
		}
		long answer = 0;
		for(int i = 1; i <= 9; i++)
			answer += dp[n][i];
		System.out.println(answer%1000000000);
		in.close();
	}

}
