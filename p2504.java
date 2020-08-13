import java.io.*;
import java.util.*;

public class p2504 {
	static String s;
	static Stack<Object> st = new Stack<Object>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();

		if(!correct()) {
			System.out.println(0);
			return;
		}

		cal();
	}

	public static boolean correct() {
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(')
				st.add(c);
			else if(c == '[')
				st.add(c);
			else if(c == ')') {
				if(st.isEmpty() || !st.pop().equals('('))
					return false;
			}
			else if(c == ']')
				if(st.isEmpty() || !st.pop().equals('['))
					return false;
		}
		if(st.isEmpty())
			return true;
		else
			return false;
	}

	public static void cal() {
		int answer = 0;
		int temp;
		Object o;

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch(c) {
			case '(' : st.add(c); break;
			case '[' : st.add(c); break;
			case ')' : 
				temp = 0;
				o = st.pop();
				while(!o.equals('(')) {
					temp += (int)o;
					o = st.pop();
				}
				if(temp == 0)
					st.add(2);
				else
					st.add(temp*2); break;
			case ']' :
				temp = 0;
				o = st.pop();
				
				while(!o.equals('[')) {
					temp += (int)o;
					o = st.pop();
				}
				if(temp == 0)
					st.add(3);
				else
					st.add(temp*3); 
				break;
			}
		}
		
		while(!st.isEmpty())
			answer += (int)st.pop();
		System.out.println(answer);
	}

}
