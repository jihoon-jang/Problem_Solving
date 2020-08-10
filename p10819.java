import java.util.*;
import java.io.*;

public class p10819 {
	static int n, array[], max;
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer stz = new StringTokenizer(br.readLine());
		array = new int[n];
		visit = new boolean[n];
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++)
			array[i] = Integer.parseInt(stz.nextToken());
		
		order(0, "");
		System.out.println(max);
	}
	
	public static void order(int length, String s) {
		if(length == n) {
			max = Math.max(max, cal(s));
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				order(length+1, s + array[i] + " ");
				visit[i] = false;
			}
		}
	}

	public static int cal(String s) {
		StringTokenizer stz = new StringTokenizer(s);
		int number[] = new int[n];
		for(int i = 0; i < n; i++)
			number[i] = Integer.parseInt(stz.nextToken());
		
		int value = 0;
		
		for(int i = 0; i < n-1; i++) 
			value += Math.abs(number[i] - number[i+1]);
		
		return value;
	}
	
}
