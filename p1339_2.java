import java.util.*;
import java.io.*;

public class p1339_2 {
	static int n, max = 0;
	static String line[];
	static boolean[] visit;
	static HashMap<Character, Integer> map;

	public static void main(String[] args) throws Exception {
		init();
		score(0,"");
		System.out.println(max);
	}

	public static void cal() {
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			String s = line[i];
			int temp = 0;
			int count = 0;
			for(int j = s.length()-1; j >= 0; j--) {
				temp += map.get(s.charAt(j))*Math.pow(10, count++);
			}
			answer += temp;
		}

		max = Math.max(answer, max);
	}

	public static void score(int length, String s) {
		if(length == map.size()) {
			String v[] = s.split(" ");
			Iterator it = map.keySet().iterator();
			int index = 0;
			
			while(it.hasNext()) {
				map.put((Character) it.next(), 9-Integer.parseInt(v[index++]));
			}
			cal();
			return;
		}
		else {
			for(int i = 0; i < map.size(); i++) {
				if(!visit[i]) {
					visit[i] = true;
					score(length+1, s+i+" ");
					visit[i] = false;
				}
			}
		}
	}

	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new HashMap<Character, Integer>();
		line = new String[n];
		for(int i = 0; i < n; i++) {
			line[i] = br.readLine();
			for(int j = 0; j < line[i].length(); j++) {
				char ch = line[i].charAt(j);
				map.put(ch, 0);
			}
		}
		visit = new boolean[map.size()];
	}

}