import java.util.Scanner;

public class p11055 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int answer = 0;
		int array[] = new int[n];
		int dp[] = new int[n];

		for(int i = 0; i < n; i++) {
			array[i] = in.nextInt();
			dp[i] = array[i];
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(array[i] > array[j])
				dp[i] = Math.max(dp[i], dp[j]+ array[i]);
			}
			answer = Math.max(dp[i], answer);
		}
		
		System.out.println(answer);
	}

}
