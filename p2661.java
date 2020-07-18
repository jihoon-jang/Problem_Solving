import java.util.Scanner;

public class p2661 {
	static int n, count = 0;
	static boolean flag = false;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		makeNumber(1, "1");	
	}

	public static boolean check(String s) {
		int length = s.length()/2;
		String s1="", s2="";
		for(int i = 1; i <= length; i++) {
			s1 = s.substring(s.length()-2*i, s.length()-i);
			s2 = s.substring(s.length()-i, s.length());
		if(s1.equals(s2))
			return false;
		}
		return true;
	}

	public static void makeNumber(int length, String s) {
		if(flag)
			return;
		if(length == n) {
			System.out.println(s);
			flag = true;
			return;
		}
		else {
			for(int i = 1; i <= 3; i++) {
				if(check(s+i)) {
					makeNumber(length+1, s+i);
				}
			}
		}
	}

}
