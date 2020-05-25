import java.util.Scanner;

public class p9461 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		
		for(int t = 0; t < tc; t++) {
			int n = in.nextInt();
			long a[] = new long[n+1];
			a[1] = 1;
			if(n >= 2)
			a[2] = 1;
			if(n >= 3)
			a[3] = 1;
			for(int i = 3; i <= n; i++) {
				a[i] = a[i-2] + a[i-3];
			}
			System.out.println(a[n]);
		}
	}

}
