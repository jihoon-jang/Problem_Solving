import java.util.*;

public class pm수식최대화 {

	public char op[];
	public String exp;
	public ArrayList<Long> number = new ArrayList<Long>();
	public ArrayList<Character> oper = new ArrayList<Character>();
	public Long answer = Long.MIN_VALUE;

	public long solution(String expression) {
		op = new char[] {'-', '*', '+'};
		this.exp = expression;

		dfs(0, "", new boolean[3]);
		return answer;
	}

	public void cal(char c[]) {
		getNumber();
		getOp();
		for(char op : c) {
			int cycle = oper.size();
			for(int i = 0; i < cycle; i++) {
				long op1 = number.remove(i);
				long op2 = number.remove(i);
				char nowOp = oper.remove(i);
				
				if(nowOp == op) {
					long val;
					switch(nowOp) {
					case '-':
						val = op1 - op2;
						number.add(i, val);;
						break;
					case '+':
						val = op1 + op2;
						number.add(i, val);;
						break;
					case '*':
						val = op1 * op2;
						number.add(i, val);;
						break;
					}
					cycle--;
					i--;
				}
				else {
					number.add(i, op2);
					number.add(i, op1);
					oper.add(i, nowOp);
				}
			}
		}
		
		answer = Math.max(Math.abs(number.get(0)), answer);
	}

	public void getOp() {
		oper.clear();
		for(int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if(c == '+' || c == '-' || c == '*') {
				oper.add(c);
			}
		}
	}

	public void getNumber() {
		number.clear();
		String temp = exp;
		temp = temp.replaceAll("\\-", " ");
		temp = temp.replaceAll("\\+", " ");
		temp = temp.replaceAll("\\*", " ");

		String s[] = temp.split(" ");
		for(int i = 0; i < s.length; i++)
			number.add(Long.parseLong(s[i]));
	}

	public void dfs(int length, String s, boolean visit[]) {
		if(length == 3) {
			cal(s.toCharArray());
			return;
		}

		for(int i = 0; i < 3; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(length+1, s + op[i]+ " ", visit);
				visit[i] = false;
			}
		}
	}

}