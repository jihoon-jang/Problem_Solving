import java.io.*;
import java.util.*;

public class p14863{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(br.readLine());
		int N = sc.nextInt();
		int K = sc.nextInt();
		int [][] dp = new int[105][100005];
		int ans=0;
		int a=0,b=0,c=0,d=0;
		for(int i=1; i<=K; i++) dp[0][i] = -99999999;
	    for(int i=1; i<=N; i++) {
	    	sc = new Scanner(br.readLine());
	    	a=sc.nextInt();
	    	b=sc.nextInt();
	    	c=sc.nextInt();
	    	d=sc.nextInt();
	    	
	        for(int j=0; j<=K; j++) {
	            dp[i][j] = -99999999;
	            if(j-a>=0) dp[i][j] = max(dp[i][j], dp[i-1][j-a]+b);
	            if(j-c>=0) dp[i][j] = max(dp[i][j], dp[i-1][j-c]+d);
	        }
	    }
	    ans = dp[N][0];
	    for(int i=1; i<=K; i++) {
	    	ans = max(ans, dp[N][i]);
	    	System.out.println(dp[N][i] + " " + i +" "+ ans);
	    }
	    System.out.println(ans);
		
	}
	
	static int max(int a, int b) {
		if(a>b) return a;
		else return b;
	}
	
}