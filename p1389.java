import java.util.Scanner;

public class p1389 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); 
		int m = in.nextInt();
		int map[][] = new int[n+1][n+1];
		
		for(int i = 0; i < m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		int max = 0;
		int value = 0;
		
		for(int i = 1; i <= n; i++) {
			int sum = 0;
			for(int j = 1; j <= n; j++) {
				if(map[i][j] == 1)
					sum ++;
			}
			
			if(max < sum) {
				max = sum;
				value = i;
			}
		}
		System.out.println(value);
	}

}
