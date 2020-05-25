import java.util.Scanner;

public class p2935 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		char op = in.nextLine().charAt(0);
		String s2 = in.nextLine();
		if(s1.length() < s2.length()) {
			String temp = s1;
			s1 = s2; s2 = temp;
		}
		
		if(op == '+') {
			if(s1.length() == s2.length()) {
				System.out.print(2);
				for(int i = 0; i < s1.length()-1; i++)
					System.out.print(0);
			}
			else {
				System.out.print(1);
				for(int i = 0; i < s1.length()-1; i++) {
					if(i == (s1.length()- s2.length() - 1))
						System.out.print(1);
					else
						System.out.print(0);
				}
			}
		}
		else {
			System.out.print(1);
			for(int i = 0; i < s1.length()+s2.length()-2; i++) {
				System.out.print(0);
			}
		}

	}

}
