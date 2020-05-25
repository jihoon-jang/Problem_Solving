import java.util.Scanner;

public class p5032 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int e = in.nextInt() + in.nextInt();
		int c = in.nextInt();
		int count = 0;

		while(e >= c) {
			int num = e/c;
			count += num;
			e %= c;
			e += num;
		}
		System.out.println(count);
	}

}
