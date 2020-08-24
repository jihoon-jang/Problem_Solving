
public class pm±âµÕ°úº¸¼³Ä¡ {

	public static void main(String[] args) {
		int n = 5;
		int b[][] = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, 
				{3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};

		int a[][] = solution(n, b);

		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}



	static boolean row[][];//º¸
	static boolean col[][];//±âµÕ
	static int r;

	public static int[][] solution(int n, int[][] build_frame) {
		r = n;
		int count = 0;
		row = new boolean[n+3][n+3];
		col = new boolean[n+3][n+3];
		for(int build[] : build_frame) {
			int x = build[0]+1;
			int y = build[1]+1;
			int a = build[2];
			int b = build[3];

			if(b == 0 && a == 0) {
				if(remove(x, y, a)) {
					col[y][x] = false;
					count--;
				}
			}
			else if(b == 0 && a == 1) {
				if(remove(x, y, a)) {
					row[y][x] = false;
					count--;
				}
			}
			else if(b == 1 && a == 0) {
				if(possCol(x, y)) {
					col[y][x] = true;
					count++;
				}
			}
			else if(b == 1 && a == 1) {
				if(possRow(x, y)) {
					row[y][x] = true;
					count++;
				}
			}
		}

		int[][] answer = new int[count][3];
		int index = 0;
		for(int j = 1; j <= n + 2; j++) {
			for(int i = 1; i <= n+2; i++) {
				if(col[i][j])
					answer[index++] = new int[] {j-1, i-1, 0};
				if(row[i][j])
					answer[index++] = new int[] {j-1, i-1, 1};
			}
		}

		return answer;
	} 

	public static boolean possRow(int x, int y) {
		return col[y-1][x] || col[y-1][x+1] || (row[y][x-1] && row[y][x+1]);
	}

	public static boolean possCol(int x, int y) {
		return y == 1 || row[y][x] || row[y][x-1] || col[y-1][x];
	}

	public static boolean remove(int x, int y, int type) {
		boolean result = true;

		if(type == 0)
			col[y][x] = false;
		else
			row[y][x] = false;

		l:	for(int i = 1; i <= r+1; i++) {
			for(int j = 1; j <= r+1; j++) {
				if(col[i][j] && !possCol(j, i)) {
					result = false;
					break l;
				}
				if(row[i][j] && !possRow(j, i)) {
					result = false;
					break l;
				}
			}
		}

		if(type == 0)
			col[y][x] = true;
		else
			row[y][x] = true;

		return result;
	}
}
