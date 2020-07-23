import java.util.*;
import java.io.*;

public class p1339 {
	static int n, max = 0;
	static String line[];
	static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		init();
		value();
		cal();
		System.out.println(max);
	}

	public static void cal() {
		List<Character> list = new ArrayList<>(map.keySet());
		list.sort(new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				// TODO Auto-generated method stub
				return map.get(o2).compareTo(map.get(o1));
			}

		});
		Iterator it = list.listIterator();
		int value = 9;
		while(it.hasNext()) {
			max += map.get(it.next()) * value--;
		}
	}

	public static void value() {
		for(int i = 0; i < n; i++) {
			String s = line[i];
			int count = 0;
			for(int j = s.length()-1; j >= 0; j--) {
				char ch = line[i].charAt(j);
				map.put(ch, map.get(ch)+(int)Math.pow(10, count++));
			}
		}
	}

	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		line = new String[n];

		for(int i = 0; i < n; i++) {
			line[i] = br.readLine();
			for(int j = 0; j < line[i].length(); j++) {
				char ch = line[i].charAt(j);
				map.put(ch, 0);
			}
		}
	}

}