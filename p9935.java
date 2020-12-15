import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class p9935 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String bomb = br.readLine();
		
		Stack<Character> st = new Stack<>();
		for(int i = 0; i < input.length(); i++) {
			st.push(input.charAt(i));
			
			if(st.size() >= bomb.length()) {
				boolean same = true;
				for(int j = 0; j < bomb.length(); j++) {
					if(st.get(st.size() - bomb.length() + j) != bomb.charAt(j)) {
						same = false;
						break;
					}
				}
				if(same) {
					for(int j = 0; j < bomb.length(); j++)
						st.pop();
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c : st)
			sb.append(c);
		
		if(sb.toString().length() == 0)
			System.out.println("FRULA");
		else
			System.out.println(sb.toString());
	}
	
}
