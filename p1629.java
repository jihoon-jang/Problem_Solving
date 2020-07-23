import java.util.Scanner;

public class p1629 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long a = in.nextLong();
		long b = in.nextLong();
		long c = in.nextLong();
		long d = rec(a, b, c)%c;
		
		
		System.out.println(d);
	}
	
	public static long rec(long a, long n, long c) {
		if(n == 1)
			return a;
		else {
			long temp = rec(a, n/2, c) % c;
			
			if(n % 2 == 0) {
				return (temp * temp % c);
			}
			else
				return (temp *temp%c * a%c);
		}
	}
}
