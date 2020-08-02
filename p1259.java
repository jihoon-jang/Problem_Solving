import java.util.Scanner;

public class p1259 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for(;;) {
			String s = in.nextLine();
			if(s.equals("0"))
				break;
			if(check(s))
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
	
	public static boolean check(String s) {
		for(int i = 0; i < s.length()/2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i))
				return false;
		}
		
		return true;
	}

}
