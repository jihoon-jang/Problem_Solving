import java.util.*;
import java.io.*;

public class p1182 {
	static int n, s, answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		s = Integer.parseInt(stz.nextToken());
		int array[] = new int[n];

		stz = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			array[i] = Integer.parseInt(stz.nextToken());

		solve(0, 0, array);

		System.out.println(s == 0 ? answer-1 : answer);
	}

	public static void solve(int length, int sum, int array[]) {
		if(length == n) {
			if(sum == s)
				answer++;
			return;
		}

		solve(length+1, sum, array);
		solve(length+1, sum+array[length], array);

	}

}
