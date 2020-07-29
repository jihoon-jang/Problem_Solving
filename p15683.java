import java.util.*;

public class p15683 {
	static int n, m, map[][], answer;
	static ArrayList<cctv> al = new ArrayList<cctv>();
	static boolean[] visit;

	public static void main(String[] args) {
		init();
		makeDir(0);	
		System.out.println(answer);
	}

	public static void check() {
		int temp[][] = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				temp[i][j] = map[i][j];

		for(int i = 0; i < al.size(); i++) {
			int x = al.get(i).x;
			int y = al.get(i).y;
			int dir = al.get(i).direction;

			switch(al.get(i).number) {
			case 1 : temp = fill(temp, x, y, dir); break;
			case 2 : 
				if(dir == 1 || dir == 3) {
					temp = fill(temp, x, y, 1);
					temp = fill(temp, x, y, 3);
				}
				else {
					temp = fill(temp, x, y, 2);
					temp = fill(temp, x, y, 4);
				}
				break;
			case 3:
				switch(dir) {
				case 1:
					fill(temp, x, y, 1);
					fill(temp, x, y, 2);
					break;
				case 2:
					fill(temp, x, y, 2);
					fill(temp, x, y, 3);
					break;
				case 3:
					fill(temp, x, y, 3);
					fill(temp, x, y, 4);
					break;
				case 4:
					fill(temp, x, y, 4);
					fill(temp, x, y, 1);
					break;
				}
				break;
			case 4:
				switch(dir) {
				case 1:
					fill(temp, x, y, 1);
					fill(temp, x, y, 2);
					fill(temp, x, y, 3);
					break;
				case 2:
					fill(temp, x, y, 2);
					fill(temp, x, y, 3);
					fill(temp, x, y, 4);
					break;
				case 3:
					fill(temp, x, y, 3);
					fill(temp, x, y, 4);
					fill(temp, x, y, 1);
					break;
				case 4:
					fill(temp, x, y, 4);
					fill(temp, x, y, 1);
					fill(temp, x, y, 2);
					break;
				}
				break;
			case 5:
				fill(temp, x, y, 1);
				fill(temp, x, y, 2);
				fill(temp, x, y, 3);
				fill(temp, x, y, 4);
				break;
			}
		}
		count(temp);
	}
	
	public static void count(int temp[][]) {
		int sum = 0;
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < m; j++)
				if(temp[i][j] == 0)
					sum ++;
		
		answer = Math.min(sum, answer);
	}

	public static int[][] fill(int temp[][], int x, int y, int dir) {
		switch(dir) {
		case 1:
			for(int i = 0; ; i++) {
				if(y + i < m) {
					if(temp[x][y+i] == 6)
						break;
					temp[x][y+i] = 9;
				}
				else
					break;
			}
			break;
		case 2:
			for(int i = 0; ; i++) {
				if(x + i < n) {
					if(temp[x+i][y] == 6)
						break;
					temp[x+i][y] = 9;
				}
				else
					break;
			}
			break;
		case 3:
			for(int i = 0; ; i++) {
				if(y - i >= 0) {
					if(temp[x][y-i] == 6)
						break;
					temp[x][y-i] = 9;
				}
				else
					break;
			}
			break;
		case 4:
			for(int i = 0; ; i++) {
				if(x-i >= 0){
					if(temp[x-i][y] == 6)
						break;
					temp[x-i][y] = 9;
				}
				else
					break;
			}
			break;
		}
		
		return temp;
	}

	public static void makeDir(int index) {
		if(index == al.size()){
			check();
			return;
		}
		for(int i = 1; i <= 4; i++) {
			al.get(index).direction = i;
			makeDir(index+1);
		}
	}

	public static void init() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		map = new int[n][m];
		answer = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++) {
				map[i][j] = in.nextInt();
				if(map[i][j] != 0 && map[i][j] != 6) {
					al.add(new cctv(i,j,map[i][j], 1));
				}
			}
		visit = new boolean[al.size()];
		in.close();
	}

	static class cctv{
		int x, y, number, direction;
		cctv(int x, int y, int number, int direction) {
			this.x = x;
			this.y = y;
			this.number = number;
			this.direction = direction;
		}
	}
}
