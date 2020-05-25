import java.util.Scanner;

public class p2231 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 1; i < n; i++) {
			int number = i;
			String s = String.valueOf(i);
			for(int j = 0; j < s.length(); j++) {
				number += s.charAt(j) - '0';
			}
			if(number == n) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);

	}

}
