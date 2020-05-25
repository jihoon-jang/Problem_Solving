import java.util.Scanner;

public class p2563 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int map[][] = new int[100][100];

		for(int i = 0; i < n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			paint(map, x, y);
		}
		int count = 0;
		for(int i = 0; i < 100; i++)
			for(int j = 0; j < 100; j++)
				if(map[i][j] == 1)
					count ++;

		System.out.println(count);
	}

	public static void paint(int map[][], int x, int y) {
		for(int i = 0; i < 10; i++) {
			if(x+i < 100) {
				map[x+i][y] = 1;
			}
			for(int j = 0; j < 10; j++)
				if(y+j < 100) {
					map[x+i][y+j] = 1;
				}
		}
	}

}
