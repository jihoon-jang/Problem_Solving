import java.util.Scanner;

public class p5565 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < 9; i++) {
			n -= in.nextInt();
		}
		System.out.println(n);
	}

}
