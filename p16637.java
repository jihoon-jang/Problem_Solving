import java.util.*;
import java.io.*;

public class p16637 {   
	static int n, answer = Integer.MIN_VALUE;
	static int num[];
	static char op[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		num = new int[n/2+1];
		op = new char[n/2];
		for(int i = 0; i < n; i++) {
			if(i % 2 == 0)
				num[i/2] = s.charAt(i) - '0';
			else if(i == n-1)
				num[i/2+1] = s.charAt(i) - '0';
			else
				op[i/2] = s.charAt(i);
		}
		if(n>1)
		cal(0,num[0], num[1], op[0], false);
		
		System.out.println(n == 1 ? s :answer);
	}

	public static int c(int n1, int n2, char oper) {
		int result = 0;
		switch(oper) {
		case '+' : result = n1+n2; break;
		case '-' : result = n1-n2; break;
		case '*' : result = n1*n2; break;
		}
		return result;
	}

	public static void cal(int index, int n1, int n2, char oper, boolean pa) {
		int result = 0;
		if(index == n/2-1) {
			answer = Math.max(answer, c(n1,n2,oper));
			return;
		}
		else {
			result = c(n1,n2,oper);
			if(index+1 <= n/2-1 && !pa) {
				cal(index+1, n1, c(n2, num[index+2], op[index+1]), op[index],  true);
			}
			cal(index+1, result, num[index+2], op[index+1], false);
		}
	}

}