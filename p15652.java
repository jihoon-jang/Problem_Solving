import java.util.Scanner;

public class p15652 {
	static int n, m;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 n = in.nextInt();
		 m = in.nextInt();
		String s= "";
		dfs(0,1,s);
	}

	public static void dfs(int len, int start, String s) {
		if (len == m) {
			System.out.println(s);
			return;
		}
		else {
			for(int i = start; i <= n; i++) {
				dfs(len+1, i, s+i+" ");
			}
		}
	}
}
