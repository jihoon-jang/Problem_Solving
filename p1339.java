import java.util.Arrays;
import java.util.Scanner;

public class p1339 {
	static int n, alphabet[], max = 0;
	static String line[];

	public static void main(String[] args) {
		init();
		score(0,0);
		System.out.println(max);
	}

	public static boolean check() {
		boolean check[] = new boolean[10];
		for(int i = 0; i < 26; i++) {
			int value;
			value = alphabet[i];
			if(value != -1) {
				if(check[value])
					return false;
				else
					check[value] = true;
			}
		}
		return true;
	}

	public static void cal() {
		int answer = 0;
		for(int i = 0; i < n; i++) {
			String s = line[i];
			int temp = 0;
			int count = 0;
			for(int j = s.length()-1; j >= 0; j--) {
				temp += alphabet[s.charAt(j)-'A']*Math.pow(10, count++);
			}
			answer += temp;
		}

		max = Math.max(answer, max);
	}

	public static void score(int li, int th) {
		if(line.length-1 == li && line[line.length-1].length()-1 == th) {
			if(check()) {
				cal();
			}
			return;
		}
		else {
			for(int i = 9; i >= 0; i--) {
				alphabet[line[li].charAt(th) - 'A'] = i;

				if(line[li].length()-1 != th)
					score(li, th+1);
				else
					score(li+1, 0);
			}
		}
	}

	public static void init() {
		Scanner in = new Scanner(System.in);
		n = Integer.parseInt(in.nextLine());
		alphabet = new int[26];
		Arrays.fill(alphabet, -1);
		line = new String[n];
		for(int i = 0; i < n; i++)
			line[i] = in.nextLine();
	}

}
