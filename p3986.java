import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class p3986 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int loop = Integer.parseInt(br.readLine());
		int count = 0; 

		for(int l = 0; l < loop; l++)
		{
			Stack<Character> st = new Stack<>();
			char[] c = br.readLine().toCharArray();
			st.push(c[0]);

			for(int i = 1; i < c.length; i++)
			{
				if(st.isEmpty() || st.peek() != c[i] ) 
					st.push(c[i]);
				else
					st.pop();
			}
			if(st.isEmpty())
				count++;
		}
		System.out.println(count);
	}

}
