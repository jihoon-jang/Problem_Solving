import java.util.*;
public class p2579 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int dp[] = new int[n+1];
		int a[] = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			a[i] = in.nextInt();
		}
		
		dp[1] = a[1];
		if(n > 1)
			dp[2] = a[1] + a[2];
		if(n > 2)
			dp[3] = Math.max(a[1] + a[3], a[2] + a[3]);
		
		for(int i = 4; i <= n; i++) {
			dp[i] = Math.max(dp[i-2] + a[i], dp[i-3] +a[i-1]+a[i]);
		}
		System.out.println(dp[n]);
		in.close();
	}

}
