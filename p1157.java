import java.util.Scanner;

public class p1157 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		s = s.toUpperCase();
		int alphabet[] = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			alphabet[c-'A'] ++;
		}
		
		int max = 0;
		String index = "";
		
		for(int i = 0; i < 26; i++) {
			if(max < alphabet[i]) {
				max = alphabet[i];
				index = String.valueOf(i);
			}
			else if(max == alphabet[i]) 
				index = "?";
		}
		
		System.out.println(index.equals("?") ? "?" : (char)('A'+Integer.parseInt(index)));
		
	}

}
