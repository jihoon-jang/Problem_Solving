import java.util.Arrays;
import java.util.Scanner;

public class p15657 {
	static int n, m, array[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);	
		n = in.nextInt();
		m = in.nextInt();
		array = new int[n];
		for(int i = 0; i < n; i++)
			array[i] = in.nextInt();
		Arrays.sort(array);

		dfs(0,0, "");
	}

	public static void dfs(int len, int start, String s) {
		if(len == m) {
			System.out.println(s);
			return;
		}
		else {
			for(int i = start; i < n; i ++) {
					dfs(len+1, i, s + array[i] + " ");
				

			}
		}
	}

}
