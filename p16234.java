import java.util.Scanner;
import java.util.Stack;

public class p16234 {
	static int n, l, r, answer = -1, sum = 0;
	static int map[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean visit[][];
	static Stack<Integer> stx;
	static Stack<Integer> sty;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); l = in.nextInt(); r = in.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];
		stx = new Stack<Integer>();
		sty = new Stack<Integer>();

		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				map[i][j] = in.nextInt();

		boolean flag = true;
		while(flag) {
			flag = false;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!visit[i][j]) {
						for(int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if(check(nx, ny) && Math.abs(map[i][j] - map[nx][ny]) >= l && Math.abs(map[i][j] - map[nx][ny]) <= r) {
								if(!visit[i][j]) {
									sum += map[i][j];
									stx.add(i);
									sty.add(j);
									visit[i][j] = true;
									flag = true;
								}
								open(nx,ny);
							}							
						}
					}
					int t = stx.size();
					for(int z = 0; z < t; z++) {
						map[stx.pop()][sty.pop()] = sum/t;
					}
					sum = 0;
				}
			}
			answer ++;
			visit = new boolean[n][n];/*
			for(int i = 0; i < n; i++) {
				for(int j = 0 ; j < n; j++)
					System.out.print(map[i][j]+" ");
				System.out.println();
			}
			System.out.println();*/

		}
		System.out.println(answer);
	}

	public static void open(int x, int y) {
		if(!visit[x][y]) {
			visit[x][y] = true;
			stx.add(x);
			sty.add(y);
			sum += map[x][y];
			for(int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(check(nx, ny) && Math.abs(map[x][y] - map[nx][ny]) >= l && Math.abs(map[x][y] - map[nx][ny]) <= r && !visit[nx][ny]) {
					open(nx, ny);
				}
			}
		}
	}

	public static boolean check(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n; 
	}
}
