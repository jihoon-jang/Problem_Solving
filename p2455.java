import java.util.Scanner;

public class p2455 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sum = 0;
		int max = 0;
		
		for(int i = 0; i < 4; i++) {
			sum = sum - in.nextInt() + in.nextInt();
			max = Math.max(max, sum);
		}
		
		System.out.println(max);

	}

}
