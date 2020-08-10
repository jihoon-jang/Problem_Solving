import java.util.*;
import java.io.*;

public class p15658 {
	static int n, number[], op[], max, min;//+,-,*,/
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		number = new int[n];
		op = new int[4];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		stz = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			number[i] = Integer.parseInt(stz.nextToken());
		
		stz = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++)
			op[i] = Integer.parseInt(stz.nextToken());
		
		dfs(0, "");
		System.out.println(max+"\n"+min);
	}
	
	public static void dfs(int length, String s) {
		if(length == n-1) {
			int value = cal(s);
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(op[i] != 0) {
				char c;
				switch(i) {
				case 0: c = '+'; break;
				case 1: c = '-'; break;
				case 2: c = '*'; break;
				default: c = '/'; break;
				}
				op[i] --;
				dfs(length+1, s+ c + " ");
				op[i]++;
			}
		}
	}
	
	public static int cal(String s) {
		StringTokenizer stz = new StringTokenizer(s);
		long temp = number[0];
		for(int i = 1; i < n; i++) {
			char c = stz.nextToken().charAt(0);
			switch(c) {
			case '+' : 
				temp += number[i]; break;
			case '-' :
				temp -= number[i]; break;
			case '*' :
				temp *= number[i]; break;
			default:
				temp /= number[i]; break;
			}
		}
		return (int)temp;
	}

}
