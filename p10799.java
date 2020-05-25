import java.io.*;
import java.util.*;

public class p10799 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] c = br.readLine().toCharArray();
		Stack<Character> st = new Stack<>();
		int count = 0;
		
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] == '(')
				st.push('(');
			else if(c[i] == ')' && c[i-1] == '(')
			{
				st.pop();
				count += st.size();
			}
			else
			{
				st.pop();
				count ++;
			}
		}
		System.out.println(count);
	}

}
