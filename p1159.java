import java.util.Scanner;

public class p1159 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		int alphabet[] = new int[26];
		
		for(int i = 0; i < n; i++) {
			char c = in.nextLine().charAt(0);
			alphabet[c-'a']++;
		}
		boolean no = false;
		for(int i = 0; i < 26; i++)
			if(alphabet[i] >= 5) {
				no = true;
				System.out.print((char)('a'+i));
			}

		if(!no)
			System.out.println("PREDAJA");
	}

}
