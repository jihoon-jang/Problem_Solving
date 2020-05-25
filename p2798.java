import java.util.Scanner;

public class p2798 {
	static int array[], n, m, answer = 0;
	static boolean visit[];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); 
		m = in.nextInt();
		array = new int[n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++)
			array[i] = in.nextInt();
		
		dfs(0,0,0);
		System.out.println(answer);
	}
	
	public static void dfs(int length, int start, int sum) {
		if(length == 3) {
			if(sum <= m)
				answer = Math.max(sum, answer);
			return;
		}
		else {
			for(int i = start; i < n; i++) {
				if(!visit[i]) {
					visit[i] = true;
					dfs(length + 1, i, sum + array[i]);
					visit[i] = false;
				}
			}
		}
	}

}
