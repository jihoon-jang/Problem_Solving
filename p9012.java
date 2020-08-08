import java.io.*;
import java.util.*;

public class p9012 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
	l:	for(int t = 0; t < tc; t++) {
			String line = br.readLine();
			Stack<Character> st = new Stack<Character>();
			
			for(int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				
				if(c == '(')
					st.push(c);
				else {
					if(st.size() == 0) {
						System.out.println("NO");
						continue l;
					}
					st.pop();
				}
			}
			
			if(st.size() == 0)
			System.out.println("YES");
			else
				System.out.println("NO");
		}
		
	}

}
