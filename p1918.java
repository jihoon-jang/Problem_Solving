import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1918 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] c = br.readLine().toCharArray();
		Stack<Character> st = new Stack<>();
		boolean open = false;

		for(int i = 0; i < c.length; i++)
		{
			if(c[i] >= 65)
				sb.append(c[i]);
			else if(c[i] == '(')
				st.push('(');
			else if(c[i] == ')')
			{
				while(st.peek() != '(')
					sb.append(st.pop());
				st.pop();
			}
			else
			{
				if(c[i] == '*' || c[i] == '/')
					while(!st.isEmpty() && (st.peek() == '*' || st.peek() == '/'))
						sb.append(st.pop());

				else if(c[i] == '+' || c[i] == '-')
					while(!st.isEmpty() && (st.peek() != '('))
						sb.append(st.pop());
				st.push(c[i]);
			}
		}
		while(!st.isEmpty())
			sb.append(st.pop());
		System.out.println(sb);
	}

}