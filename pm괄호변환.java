import java.util.*;

public class pm°ýÈ£º¯È¯ {

	public static void main(String[] args) {
		System.out.println(solution("()))((()"));
	}

	public static String solution(String p) {
		if(check(p))
			return p;
		return rec(p);
	}

	public static String rec(String s) {
		if(s.equals(""))
			return "";

		int temp = 0;
		String u = "", v = "";

		for(int i = 0; i < s.length(); i++) {
			char c= s.charAt(i);
			if(c == '(')
				temp ++;
			else
				temp --;
			if(temp == 0 && i != 0) {
				u = s.substring(0, i+1);
				if(i + 1 != s.length())
					v = s.substring(i+1, s.length());
				else
					v = "";
				break;
			}
		}

		if(check(u)) {
			return u + rec(v);
		}
		else {
			StringBuilder sb = new StringBuilder();
			sb.append("(");
			sb.append(rec(v)+")");
			for(int i = 1; i < u.length()-1; i++) {
				char c = u.charAt(i);
				if(c == '(')
					sb.append(")");
				else
					sb.append('(');
			}
			return sb.toString();
		}
	}

	public static boolean check(String p) {
		Stack<Character> st = new Stack<Character>();
		for(int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if(c == '(')
				st.push(c);
			else {
				if(st.isEmpty())
					return false;
				st.pop();
			}
		}

		return true;
	}
}