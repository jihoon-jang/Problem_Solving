import java.util.Scanner;

public class p1904 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number= in.nextInt();
		long a[] = new long[number+1];
		a[1] = 1;
		a[2] = 2;
		for(int i = 3; i <= number; i++) {
			a[i] = (a[i-1] + a[i-2])%15746;
		}
		System.out.println(a[number]);
		
		in.close();
	}

}
