import java.util.Scanner;

public class p1780 {
	static int n, map[][];
	static int _one = 0, zero = 0, one = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		map = new int[n][n];

		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				map[i][j] = in.nextInt();

		if(n != 1)
			if(!check(map[0][0], 0, 0, n))
				part(0, 0, n/3);
			else {
				switch(map[0][0]) {
				case 1: one ++; break;
				case 0: zero ++; break;
				case -1: _one ++; break;
				}
			}

		System.out.println(_one + "\n" + zero+"\n"+one);
	}

	public static void part(int x, int y, int size) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(check(map[x+i*size][y+j*size], x+i*size, y+j*size, size)) {
					if(map[x+i*size][y+j*size] == 1)
						one++;
					else if(map[x+i*size][y+j*size] == 0)
						zero++;
					else
						_one++;
				}
				else 
					part(x+i*size, y+j*size, size/3);
			}
		}
	}

	public static boolean check(int color, int x, int y, int size) {
		for(int i = 0; i < size; i++) 
			for(int j = 0; j < size; j++)
				if(map[x + i][y + j] != color)
					return false;

		return true;
	}

}
