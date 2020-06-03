import java.util.Scanner;
import java.util.Stack;

public class p1874 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int array[] = new int[n+1];
		int index = 1;
		Stack<Integer> st = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= n; i++)
			array[i] = in.nextInt();

		for(int i = 1; i <= n; i++) {
			st.push(i);
			sb.append("+\n");
			
			while(!st.isEmpty() && array[index] == st.peek()) {
				index ++;
				sb.append("-\n");
				st.pop();
			}
		}
		
		if(st.isEmpty())
			System.out.println(sb);
		else
			System.out.println("NO");
	}

}
