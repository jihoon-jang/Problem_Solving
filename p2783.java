import java.util.Scanner;

public class p2783 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double a = in.nextDouble();
		double b = in.nextDouble();
		double answer = Math.round(a/b*1000.0*100.0)/100.0;
		int r = in.nextInt();
		
		for(int i = 0; i < r; i++) {
			a = in.nextDouble();
			b = in.nextDouble();
			double n = Math.round(a/b*1000.0*100.0)/100.0;
			answer = Math.min(answer, n);
		}
		System.out.println(answer);
	}

}
