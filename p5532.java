import java.util.Scanner;

public class p5532 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		a = (int)Math.ceil((double)a/(double)c);
		b = (int)Math.ceil((double)b/(double)d);
		System.out.println(l-a < l-b ? l-a : l-b);

	}

}
