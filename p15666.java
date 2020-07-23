import java.util.*;

public class p15666 {
	static int n, m, array[];
	static LinkedHashSet<String> set = new LinkedHashSet<String>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		array = new int[n];

		for(int i = 0; i < n; i++)
			array[i] = in.nextInt();

		Arrays.sort(array);
		dfs(0, 0, "");

		Iterator it = set.iterator();

		while(it.hasNext())
			System.out.println(it.next());
	}

	public static void dfs(int length, int start, String s) {
		if(length == m) {
			set.add(s);
			return;
		}
		else {
			for(int i = start; i < n; i++) {
					dfs(length+1, i, s + array[i] + " ");
			}
		}
	}

}
