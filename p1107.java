import java.util.Scanner;

public class p1107 {
	static boolean remote[] = new boolean[10];
	static int n;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = Integer.parseInt(in.nextLine());
		int m = in.nextInt();

		for(int i = 0; i < m; i++)
			remote[in.nextInt()] = true;

		int min = Math.abs(n-100);

		l:	for(int i = 0; i <= 1000000; i++) {
			String s = String.valueOf(i);
			for(int j = 0; j < s.length(); j++) {
				if(remote[s.charAt(j) -'0'])
					continue l;
			}
			if(n >= i)
				min = Math.min(min, n-i+String.valueOf(i).length());
			else if(n < i)
				min = Math.min(min, i-n+String.valueOf(i).length());
		}

		System.out.println(n == 100 ? 0 : min);
	}

}
