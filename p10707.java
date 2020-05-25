import java.util.Scanner;

public class p10707 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		int p = in.nextInt();
		int cost = a*p;
		int cost2 = p-c > 0 ? b+(p-c)*d : b;
		
		System.out.println(cost > cost2 ? cost2 : cost);

	}

}
