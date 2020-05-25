import java.util.Scanner;

public class p1120 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String s1 = in.next(); String s2 = in.next();
		int answer = Integer.MAX_VALUE;

		for(int i = 0; i <= s2.length() - s1.length(); i++) {
			int cnt = 0;
			for(int j = 0; j < s1.length(); j++) {
				if(s1.charAt(j) != s2.charAt(j+i))
					cnt ++;
			}
			answer = Math.min(answer, cnt);
		}
		System.out.println(answer);
	}

}
