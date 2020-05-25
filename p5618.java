import java.util.Scanner;

public class p5618 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int min = Integer.MAX_VALUE;
		int number[] = new int[3];
		for(int i = 0; i < n; i++) {
			number[i] = in.nextInt();
			if(number[i] < min)
				min = number[i];
		}

		for(int i = 1; i <= min; i++) {
			if(n == 2 && number[0] % i == 0 && number[1] % i == 0)
				System.out.println(i);
			else if(n == 3 && number[0] % i == 0 && number[1] % i == 0 && number[2] % i == 0)
				System.out.println(i);
		}


	}

}
