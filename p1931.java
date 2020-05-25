import java.util.Arrays;
import java.util.Scanner;

public class p1931 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int answer = 0;
		int time = 0;
		
		int table[][] = new int[n][2];
		for(int i = 0; i < n; i++) {
			table[i][0] = in.nextInt();
			table[i][1] = in.nextInt();
		}
		Arrays.sort(table, (a,b) -> a[1] == b[1]? a[0] - b[0] : a[1] - b[1]);
		for(int i = 0; i < n; i++) {
			if(table[i][0] >= time) {
				time = table[i][1];
				answer ++;
			}
		}
		System.out.println(answer);
		
	}

}
