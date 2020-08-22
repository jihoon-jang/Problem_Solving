import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p11655 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char sa[] = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < sa.length; i++) {
			char c = sa[i];
			if(c >= 'a' && c < 'n')
				sb.append((char)(c+13));
			else if(c >= 'n' && c <= 'z')
				sb.append((char)(c-13));
			else if(c >= 'A' && c < 'N')
				sb.append((char)(c+13));
			else if(c >= 'N' && c <= 'Z')
				sb.append((char)(c-13));
			else
				sb.append(c);
		}
		
		System.out.println(sb.toString());
	}

}
