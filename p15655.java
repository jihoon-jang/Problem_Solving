import java.util.Arrays;
import java.util.Scanner;

public class p15655 {
	static int n, m, number[];
	static boolean visit[];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		number = new int[n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++)
			number[i] = in.nextInt();
		Arrays.sort(number);

		dfs(0,0,"");

	}

	public static void dfs(int len, int start, String s) {
		if(len == m) {
			System.out.println(s);
			return;
		}
		else {
			for(int i =start; i < n; i++) {
				if(!visit[i]) {
					visit[i]  = true;
					dfs(len+1, i,s+number[i] + " ");
					visit[i] = false;
				}

			}
		}
	}

}
