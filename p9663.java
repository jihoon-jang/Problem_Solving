import java.util.Scanner;

public class p9663 {
	static int answer, n;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int map[] = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			map[1] = i;
			dfs(map, 1);
		}
		System.out.println(answer);
	}
	
	public static boolean check(int map[], int x) {
		for(int i = 1; i < x; i++) {
			if(map[i] == map[x])
				return false;
			else if(Math.abs(i-x) == Math.abs(map[i] - map[x])) {
				return false;
			}
		}
		return true;
	}
	
	public static void dfs(int map[], int count) {
		if(count == n) {
			answer ++;
			return;
		}
		else {
			for(int i = 1; i <= n; i++) {
				map[count+1] = i; 
				if(check(map, count+1)) {
					dfs(map, count+1);
				}
			}
		}
	}

}
