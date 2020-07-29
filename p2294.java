import java.util.*;

public class p2294 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		TreeSet<Integer> set = new TreeSet<Integer>();

		for(int i = 0; i < n; i++)
			set.add(in.nextInt());

		Object[] coin = set.toArray();

		int dp[] = new int[k+1];
		Arrays.fill(dp, 100000);
		
		dp[0] = 0;
		for(int i = 0; i < coin.length; i++) {
			for(int j = (int)coin[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j-(int)coin[i]]+1);
			}
		}

		System.out.println(dp[k] == 100000 ? -1 : dp[k]);
	}

}
