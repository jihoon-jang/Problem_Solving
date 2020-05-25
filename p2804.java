import java.util.Scanner;

public class p2804 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();

		int x = 0; int y = 0;
		a:	
			for(int i = 0; i < s1.length(); i++) {
				for(int j = 0; j < s2.length(); j++) {
					if(s1.charAt(i) == s2.charAt(j)) {
						x = i; y = j;
						break a;
					}
				}
			}
		
		for(int i = 0; i < s2.length(); i++) {
			for(int j = 0; j < s1.length(); j++) {
				if(i != y && j != x)
					System.out.print('.');
				else if(i == y)
					System.out.print(s1.charAt(j));
				else if(j == x)
					System.out.print(s2.charAt(i));
			}
			System.out.println();
		}
	}

}