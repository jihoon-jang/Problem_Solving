import java.util.*;

public class p14890 {
	static int map[][];
	static int n, l, answer = 0;
	static boolean visit[][];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); l = in.nextInt();
		map = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				map[i][j] = in.nextInt();

		visit = new boolean[n][n];
		for(int i = 0; i < n; i++)
			searchx(i);
		visit = new boolean[n][n];
		for(int i = 0; i < n; i++)
			searchy(i);

		System.out.println(answer);
	}

	public static void searchy(int line) {
		int temp = 0;
		int number = map[0][line];
		for(int i = 0; i < n; i++) {
			if(number > map[i][line]+1)
				return;
			if(number == map[i][line])
				temp++;
			else if(number > map[i][line]){
				temp = 0;
				number = map[i][line];
				if(i+l-1 > n-1)
					return;
				for(int j = 0; j < l; j++) {
					if(number == map[i+j][line]) {
						if(visit[i+j][line])
							return;
						visit[i+j][line] = true;
						temp++;
					}
					else
						return;
				}
				i += l-1;
			}
			else {
				temp = 1;
				number = map[i][line];
			}
		}	
		
		temp = 0;
		number = map[n-1][line];
		for(int i = n-1; i >= 0; i--) {
			if(number+1 < map[i][line])
				return;
			if(number == map[i][line])
				temp++;
			else if(number > map[i][line]){
				temp = 0;
				number = map[i][line];
				if(i-l+1 < 0)
					return;
				for(int j = 0; j < l; j++) {
					if(number == map[i-j][line]) {
						if(visit[i-j][line])
							return;
						visit[i-j][line] = true;
						temp++;
					}
					else 
						return;
				}
				i -= l-1;
			}
			else {
				temp = 1;
				number = map[i][line];
			}

		}
		answer ++;
		
	}

	public static void searchx(int line) {
		int temp = 0;
		int number = map[line][0];
		for(int i = 0; i < n; i++) {
			if(number > map[line][i]+1)
				return;
			if(number == map[line][i])
				temp++;
			else if(number > map[line][i]){
				temp = 0;
				number = map[line][i];
				if(i+l-1 > n-1)
					return;
				for(int j = 0; j < l; j++) {
					if(number == map[line][i+j]) {
						if(visit[line][i+j])
							return;
						visit[line][i+j] = true;
						temp++;
					}
					else
						return;
				}
				i += l-1;
			}
			else {
				temp = 1;
				number = map[line][i];
			}
		}	

		temp = 0;
		number = map[line][n-1];
		for(int i = n-1; i >= 0; i--) {
			if(number+1 < map[line][i])
				return;
			if(number == map[line][i])
				temp++;
			else if(number > map[line][i]){
				temp = 0;
				number = map[line][i];
				if(i-l+1 < 0)
					return;
				for(int j = 0; j < l; j++) {
					if(number == map[line][i-j]) {
						if(visit[line][i-j])
							return;
						visit[line][i-j] = true;
						temp++;
					}
					else 
						return;
				}
				i -= l-1;
			}
			else {
				temp = 1;
				number = map[line][i];
			}
		}

		answer ++;
	}

}
