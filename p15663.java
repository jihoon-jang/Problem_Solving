import java.util.Arrays;
import java.util.Scanner;

public class p15663 {
	static int n, m, array[];
	static boolean visit[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);	
		n = in.nextInt();
		m = in.nextInt();
		array = new int[n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++)
			array[i] = in.nextInt();
		Arrays.sort(array);

		dfs(0, "");
	}
	static int temp;
	public static void dfs(int len, String s) {
		if(len == m) {
			System.out.println(s);
			return;
		}
		else {
			for(int i = 0; i < n; i ++) {
				if(!visit[i]) {
					if(len == 0 || array[temp] != array[i]) {
						visit[i] = true;
						temp = i;
						dfs(len+1, s + array[i] + " ");
						visit[i] = false;
					}
				}


			}
		}
	}

}
