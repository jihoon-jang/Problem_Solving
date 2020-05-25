import java.util.Scanner;

public class p2580 {
	static int map[][] = new int[9][9];
	static int zx[] = new int[81];
	static int zy[] = new int[81];
	static int index = 0;
	static boolean flag = false;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++) {
				map[i][j] = in.nextInt();
				if(map[i][j] == 0) {
					zx[index] = i;
					zy[index] = j;
					index ++;
				}
			}

		dfs(zx[0], zy[0], 1);
	}

	public static boolean check(int x, int y, int n) {
		for(int i = 0; i < 9; i++) {
			if(map[x][i] == n) {
				return false;
			}
			else if(map[i][y] == n) {
				return false;
			}
		}
		int nx = x/3;
		int ny = y/3;

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(map[nx*3+i][ny*3+j] == n)
					return false;
			}
		}

		return true;
	}

	public static void dfs(int x, int y, int ind) {
		if(!flag)
			for(int i = 1; i <= 9; i++) {
				if(check(x, y, i)) {
					map[x][y] = i;
					if(ind == index && ind == index) {
						for(int q = 0; q < 9; q++) {
							for(int j = 0; j < 9; j++)
								System.out.print(map[q][j] + " ");
							System.out.println();
						}
						flag = true;
						return;
					}
					dfs(zx[ind], zy[ind], ind+1);
					map[x][y] = 0;
				} 
			}
	}

}
