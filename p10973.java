import java.util.*;
import java.io.*;

public class p10973 {
	static String str = "";
	static String answer;
	static boolean visit[], flag = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stz.nextToken());
		int array[] = new int[n];
		answer = br.readLine();
		stz = new StringTokenizer(answer);
		visit = new boolean[n];

		for(int i = 0; i < n; i++)
			array[i] = Integer.parseInt(stz.nextToken());
		Arrays.sort(array);
		dfs(0, n, str, array);
	}

	public static void dfs(int length, int n, String s, int array[]) {
		if(flag)
			return;
		if(length == n) {
			if(s.trim().equals(answer)) {
				if(str.length() > 0)
					System.out.println(str);
				else
					System.out.println(-1);
				flag = true;
				return;
			}
			str = s;
			return;
		}

		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(length +1, n, s + array[i] +" ", array);
				visit[i] = false;
			}
		}
	}

}
