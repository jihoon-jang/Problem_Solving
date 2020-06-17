import java.util.Scanner;

public class p2630 {
	static int n, map[][];
	static int blue = 0, white = 0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		map = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				map[i][j] = in.nextInt();
		
		part(0, 0, n/2);
		
		System.out.println(white + "\n" + blue);
	}
	
	public static void part(int x, int y, int size) {
		if(check(map[x][y], x, y, size)) {
			if(map[x][y] == 1)
				blue++;
			else
				white++;
		}
		else 
			part(x, y, size/2);

		if(check(map[x+size][y], x+size, y, size)) {
			if(map[x+size][y] == 1)
				blue++;
			else
				white++;
		}
		else 
			part(x+size, y, size/2);

		if(check(map[x][y+size], x, y+size, size)) {
			if(map[x][y+size] == 1)
				blue++;
			else
				white++;
		}
		else 
			part(x, y+size, size/2);

		if(check(map[x+size][y+size], x+size, y+size, size)) {
			if(map[x+size][y+size] == 1)
				blue++;
			else
				white++;
		}
		else 
			part(x+size, y+size, size/2);
	}
	
	public static boolean check(int color, int x, int y, int size) {
		for(int i = 0; i < size; i++) 
			for(int j = 0; j < size; j++)
				if(map[x + i][y + j] != color)
					return false;
		
		return true;
	}

}
