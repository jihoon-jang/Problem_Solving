import java.util.Scanner;

public class p8979 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); int k = in.nextInt()-1;
		int map[][] = new int[n][3];
		int rank = 1;
		
		for(int i = 0; i < n; i++) {
			int line = in.nextInt()-1; 
			map[line][0] = in.nextInt();
			map[line][1] = in.nextInt();
			map[line][2] = in.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			if(map[i][0] > map[k][0] || (map[i][0] == map[k][0] && map[i][1] > map[k][1]) || (map[i][0] == map[k][0] && map[i][1] == map[k][1] && map[i][2] > map[k][2]))
				rank ++;
		}
		System.out.println(rank);
	}

}
