import java.util.*;
import java.io.*;

public class p1062 {
	static int n, m, answer = 0;
	static ArrayList<String> al = new ArrayList<String>();
	static boolean alphabet[] = new boolean[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		m = Integer.parseInt(stz.nextToken());
		StringBuilder sb = new StringBuilder();

		if(m < 5) {
			System.out.println(0);
			return;
		}
		else if(m == 26) {
			System.out.println(n);
			return;
		}
		m -= 5;
		alphabet['a'-'a'] = true;
		alphabet['n'-'a'] = true;
		alphabet['t'-'a'] = true;
		alphabet['i'-'a'] = true;
		alphabet['c'-'a'] = true;

		for(int i = 0; i < n; i++) {
			sb.append(br.readLine());
			al.add(sb.toString().substring(4, sb.length() - 4));
			sb.delete(0, sb.length());
		}

		dfs(0, 0);
		System.out.println(answer);
	}

	public static void dfs(int start, int length) {
		if(length == m) {
			int temp = 0;
		l:	for(int i = 0; i < al.size(); i++) {
				String s = al.get(i);
				for(int j = 0; j < s.length(); j++) {
					if(!alphabet[s.charAt(j)-'a']) 
						continue l;
				}
				temp++;
			}

			answer = Math.max(answer, temp);
			return;
		}

		for(int i = start; i < 26; i++) {
			if(!alphabet[i]) {
				alphabet[i] = true;
				dfs(i, length + 1);
				alphabet[i] = false;
			}
		}
	}



}
