import java.util.Scanner;

public class p10808 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int alphabet[] = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i)-'a'] ++;
		}
		for(int i : alphabet)
			System.out.print(i+ " ");

	}

}