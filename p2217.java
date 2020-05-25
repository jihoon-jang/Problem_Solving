import java.util.Arrays;
import java.util.Scanner;

public class p2217 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int rope[] = new int[n];
		for(int i = 0; i < n; i++) {
			rope[i] = in.nextInt();
		}
		int answer = 0;
		Arrays.sort(rope);
		
		for(int i = 0; i < n; i++) {
			answer = Math.max(answer, rope[n-i-1]*(i+1));
		}
		System.out.println(answer);
	}

}
