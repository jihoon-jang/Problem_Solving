import java.util.Scanner;

public class p2475 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = 0;
		for(int i = 0; i < 5; i++) {
			int n = in.nextInt();
			num += Math.pow(n, 2);
		}
		
		System.out.println(num%10);
	}

}
