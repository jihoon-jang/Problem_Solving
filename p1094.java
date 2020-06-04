import java.util.*;

public class p1094 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> st = new Stack<Integer>();
		int sum = 64;
		st.add(64);
		
		while(sum != n) {
			int stick = st.pop();
			st.add(stick/2);
			st.add(stick/2);
			if(sum-st.peek() >= n) 
				sum -= st.pop();
		}
		
		System.out.println(st.size());
	}

}
