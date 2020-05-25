import java.util.Scanner;

public class p17144 {
	static int map[][], temp[][];
	static int r, c, t, answer;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
	static int tx=0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		r = in.nextInt(); c = in.nextInt(); t = in.nextInt();
		map = new int[r][c];

		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++) {
				map[i][j] = in.nextInt();
				if(map[i][j] == -1 && tx == 0) {
					tx = i;
				}
			}

		for(int tc = 0; tc < t; tc++) {
			temp = new int[r][c];
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(map[i][j] != 0 && map[i][j] != -1)
						dust(i, j);
				}
			}
			sum();
			clean();
		}
			cal();
			System.out.println(answer);
	}

	public static void cal() {
		for(int i = 0; i < r; i++) 
			for(int j = 0 ; j< c; j++) 
				if(map[i][j] != -1)
				answer += map[i][j];
	}
	
	public static void clean() {
		int x = tx+1;

		for(int i = 0; i < tx-1; i++) {//1
			map[tx-i-1][0] = map[tx-i-2][0]; 
		}
		for(int i = 0; i < c-1; i++) {//2
			map[0][i] = map[0][i+1]; 
		}
		for(int i = 0; i < tx; i++) {//3
			map[i][c-1] = map[i+1][c-1]; 
		}
		for(int i = 0; i < c-1; i++) {//4
			map[tx][c-1-i] = (map[tx][c-2-i] == -1 ? 0 : map[tx][c-i-2]); 
		}
		
		
		for(int i = 1; i < r-x-1; i++) {//3
			map[x+i][0] = map[x+i+1][0];
		}
		for(int i = 0; i < c-1; i++) {//4
			map[r-1][i] = map[r-1][i+1];
		}
		for(int i = 0; i < r-x-1; i++) {//1
			map[r-1-i][c-1] = map[r-i-2][c-1];
		}
		for(int i = 0; i < c-1; i++) {//2
			map[x][c-1-i] = (map[x][c-2-i] == -1 ? 0 : map[x][c-2-i]);
		}
		
	}

	public static void sum() {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				map[i][j] += temp[i][j];
			}
		}
	}

	public static boolean check(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c; 
	}

	public static void dust(int x, int y) {
		int count = 0;
		for(int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(check(nx, ny) && map[nx][ny] != -1){
				temp[nx][ny] += map[x][y] / 5;
				count ++;
			}
		}
		map[x][y] -= map[x][y]/5*count;
	}

}
