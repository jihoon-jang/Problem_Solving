import java.util.Scanner;

public class p6064 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		l:		for(int tc = 0; tc < t; tc++) {
			int m = in.nextInt();
			int n = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			int lcm = lcm(m, n);
			int bigger = 1;

			if(m < n)
				bigger = 2;

			int count;
			if(bigger == 1)
				count = x;
			else
				count = y;
			boolean flag = false;

			while(count <= lcm) {
				if(bigger == 1) {
					if(count % n == y)
						flag = true;
					else if(count % n == 0)
						if(y == n)
							flag = true;
				}
				else
					if(count % m == x)
						flag = true;
					else if(count % m == 0)
						if(x == m)
							flag = true;
				
				if(flag) {
					System.out.println(count);
					continue l;
				}
				
				if(bigger == 1)
					count += m;
				else
					count += n;
			}
			System.out.println(-1);
		}
	}

	public static int lcm(int a, int b) {
		if(a > b) {
			int temp = a;
			a = b;
			b = temp;
		}

		for(int i = a; a > 1; i--) {
			if(b % i == 0 && a % i == 0)
				return a/i*b;
		}

		return a*b;
	}

}
