import java.util.HashMap;
import java.util.Scanner;

public class p9375 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());

		for(int tc = 0; tc < t; tc++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int n = Integer.parseInt(in.nextLine());
			for(int i = 0; i < n; i++) {
				String k = in.nextLine().split(" ")[1];

				if(!map.containsKey(k))
					map.put(k, 1);
				else
					map.put(k, map.get(k)+1);
			}
			int answer = 1;
			int sum = 0;

			for(int v :map.values()) {
				answer *= v;
				sum += v;
			}

			System.out.println(map.size() != 1 ? answer+sum : answer);
		}
	}
}