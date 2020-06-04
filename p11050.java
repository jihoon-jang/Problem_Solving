import java.util.Scanner;

public class p11050 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		System.out.println(fac(n)/fac(k)/fac(n-k));
		
	}
	
	public static int fac(int num) {
		int n = 1;
		
		for(int i = num; i > 1; i--)
			n *= i;
		
		return n;
	}

}
