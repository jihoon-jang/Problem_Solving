import java.util.Scanner;

public class p15651 {
	static int n,m;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 n = in.nextInt();
		 m = in.nextInt();
		String s = "";
		dfs(0,s);
	}

	public static void dfs(int len, String s) {
		if(len == m) {
			System.out.println(s);
			return;
		}
		else {
			for(int i = 1; i <= n; i++) {
				dfs(len+1, s+i+" ");
			}
		}
	}
}
