import java.util.Scanner;

public class p1049 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		int six = 1000;
		int one = 1000;
		for(int i = 0; i < m; i++) {
			int p1 = in.nextInt();
			int p2 = in.nextInt();
			six = Math.min(six, p1);
			one = Math.min(one, p2);
		}
		if(one*6 < six)
			System.out.println(one * n);
		else {
			int answer = six * (n/6) + (one * (n%6) > six ? six : one* (n%6));
			System.out.println(answer);
			
		}
	}

}
