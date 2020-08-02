import java.util.Scanner;

public class p1748 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= n; i++) {
			sb.delete(0, sb.length());
			sb.append(i);
			sum += sb.length();
		}
		System.out.println(sum);
	}

}
