import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1935 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Double> st = new Stack<>();
		int[] value = new int[Integer.parseInt(br.readLine())];
		String s = br.readLine();

		for(int l = 0; l < value.length; l++)
			value[l] = Integer.parseInt(br.readLine());

		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if(c >= 65)
				st.push((double) value[c-65]);
			else
			{
				double d1 = st.pop();
				double d2 = st.pop();
				switch(c)
				{
				case '+' : st.push(d1 + d2); break;
				case '-' : st.push(d2 - d1); break;
				case '/' : 	st.push(d2 / d1); break;
				case '*' : st.push(d1 * d2); break;
				}
			}
		}
		System.out.printf("%.2f", st.pop());
	}

}
