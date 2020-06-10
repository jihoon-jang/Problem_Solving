import java.util.Scanner;

public class p1018 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt(); int n = in.nextInt(); in.nextLine();
		char map[][] = new char[m][n];
		for(int i = 0; i < m; i++) {
			String s = in.nextLine();
			map[i] = s.toCharArray();
		}
		int answer = Integer.MAX_VALUE;

		char white[][] = new char[m][n];
		char c = 'W';
		for(int i = 0; i < m; i++) {
			if(i % 2 == 1)
				c = 'B';
			else
				c = 'W';
			for(int j = 0; j < n; j++) {
				white[i][j] = c;
				if(c == 'W')
					c = 'B';
				else
					c = 'W';
			}
		}
		char black[][] = new char[m][n];
		c = 'B';
		for(int i = 0; i < m; i++) {
			if(i % 2 == 0)
				c = 'B';
			else
				c = 'W';
			for(int j = 0; j < n; j++) {
				black[i][j] = c;
				if(c == 'W')
					c = 'B';
				else
					c = 'W';
			}
		}

		int w, b;
		for(int i = 0; i <= m-8; i++) {
			for(int j = 0; j <= n-8; j++) {
				
				w = b = 0;
				for(int k = 0; k < 8; k++) {
					for(int l = 0; l < 8; l++) {
						if(map[i+k][j+l] != white[k][l])
							w ++;
						if(map[i+k][j+l] != black[k][l])
							b ++;						
					}
				}
				answer = Math.min(w, Math.min(answer, b));
			}
		}

		System.out.println(answer);
	}

}
