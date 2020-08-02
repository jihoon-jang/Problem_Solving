import java.util.Scanner;

public class p1789 {

	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long sum = 0;
		for(long i = 1;;i++) {
			sum += i;
			if(sum > n) {
				System.out.println(i-1);
				return;
			}
			else if(sum == n) {
				System.out.println(i);
				return;
			}
		}
	}

}
