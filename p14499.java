import java.util.Scanner;

public class p14499 {
	static int n, m, r, c, k;
	static int map[][];
	static int dix[];
	static int diy[];
	static int dx[] = {0,0,0,-1,1};
	static int dy[] = {0,1,-1,0,0};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); m = in.nextInt(); r = in.nextInt();
		c = in.nextInt(); k = in.nextInt();
		map = new int[n][m];
		dix = new int[4];
		diy = new int[4];

		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				map[i][j] = in.nextInt();

		for(int i = 0; i < k; i++) {
			int n = in.nextInt();
			if(check(r + dx[n],c + dy[n])) {
				r += dx[n];
				c += dy[n];
				roll(n);
			}
		}
	}

	public static void set(int dir) {
		int temp;
		switch(dir) {
		case 1:
			temp = diy[3];
			for(int i = 0; i < 3; i++) {
				diy[3-i] = diy[2-i];
			}
			diy[0] = temp;
			dix[3] = diy[3];
			dix[1] = diy[1];
			break;
		case 2:
			temp = diy[0];
			for(int i = 0; i < 3; i++) {
				diy[i] = diy[i+1];
			}
			diy[3] = temp;
			dix[3] = diy[3];
			dix[1] = diy[1];
			break;
		case 3:
			temp = dix[0];
			for(int i = 0; i < 3; i++) {
				dix[i] = dix[i+1];
			}
			dix[3] = temp;
			diy[3] = dix[3];
			diy[1] = dix[1];
			break;	
		case 4:
			temp = dix[3];
			for(int i = 0; i < 3; i++) {
				dix[3-i] = dix[2-i];
			}
			dix[0] = temp;
			diy[3] = dix[3];
			diy[1] = dix[1];
			break;
		}	
	}

	public static void roll(int dir) {
		set(dir);
		if(map[r][c] != 0) {
			dix[3] = map[r][c];
			diy[3] = map[r][c];
			map[r][c] = 0;
		}
		else {
			map[r][c] = dix[3];
		}
		System.out.println(dix[1]);

	}

	public static boolean check(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m; 
	}

}
