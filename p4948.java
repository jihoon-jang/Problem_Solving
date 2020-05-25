import java.util.Arrays;
import java.util.Scanner;

public class p4948 {
	final static int SIZE = 123456*2+1;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number[] = new int[SIZE];
		Arrays.fill(number, 1);

		for(int i = 2; i < SIZE-1; i++) {
			for(int j = 2; i*j <= SIZE; j++) {
				number[i*j] = 0;
			}
		}
		int n = in.nextInt();
		while(n != 0) {
			int count = 0;
			for(int i = n+1; i <= 2*n; i++) {
				if(number[i] == 1)
					count++;
			}
			System.out.println(count);
			n = in.nextInt();
		}

	}

}
