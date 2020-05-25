import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<Integer>(); 
		for(int l = 0; l < loop; l++)
		{
			int number = Integer.parseInt(br.readLine());
			if(number == 0)
				st.pop();
			else
				st.push(number)
				;
		}
		int sum = 0;
		while(!st.isEmpty())
			sum+=st.pop();
		System.out.println(sum);
	}

}
