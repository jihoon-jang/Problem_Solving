import java.util.Arrays;
import java.util.Scanner;

public class p1759 {
	static char[] alphabet;
	static boolean[] visit;
	static int l, c, n;

	public static void main(String[] agrs) {
		init();
		search(0, 0, "");		
	}

	public static boolean check(String s) {
		int a = 1;
		int b = 2;

		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == 'a' || ch == 'i' || ch == 'o' || ch =='u' || ch == 'e')
				a--;
			else
				b--;
			if(a <= 0 && b <= 0)
				return true;
		}
		return false;
	}

	public static void search(int length, int start, String s) {
		if(length == l) {
			if(check(s))
				System.out.println(s);
			return;
		}
		else {
			for(int i = start; i < n; i++) {
				if(!visit[i]) {
					visit[i] = true;
					search(length + 1, i, s + alphabet[i]);
					visit[i] = false;
				}
			}
		}
	}

	public static void init() {
		Scanner in = new Scanner(System.in);
		l = in.nextInt();
		c = in.nextInt();
		alphabet = new char[c];
		visit = new boolean[c];
		n = 0;

		for(int i = 0; i < c; i++) {
			char input = in.next().charAt(0);
			alphabet[n++] = input;
		}
		Arrays.sort(alphabet);
	}
}
