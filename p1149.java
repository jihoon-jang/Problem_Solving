import java.util.*;
public class p1149 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int room = in.nextInt();
		int dp[][] = new int[room+1][3];
		int a[][] = new int[room+1][3];

		for(int i = 1 ; i <= room; i++) 
			for(int j = 0; j < 3; j++) 
				a[i][j] = in.nextInt();

		for(int i = 1; i <= room; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + a[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + a[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + a[i][2]; 
		}	
		System.out.println(Math.min(Math.min(dp[room][0], dp[room][1]), dp[room][2]));
	}
}