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
		int answer = 0;

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

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] != white[i][j])
					answer ++;
			}
		}
		int temp = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] != black[i][j])
					temp ++;
			}
		}
		if(answer < temp)
			System.out.println(answer);
		else 
			System.out.println(temp);
	}

}
