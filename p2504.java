import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2504 {
	static Stack<String> st = new Stack<>();
	static int sum = 0;
	static boolean right = true;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());

		String s = str.nextToken();
	}

	public static void cal(String s)
	{
		if(s.equals("(") || s.equals("["))
			st.push(s);
		else if(s.equals(")"))
		{
			if(st.pop().equals("]"))
			{
				sum = 0;
				
				right = false;
			}
			else
				sum += 2;

		}
	}
}
