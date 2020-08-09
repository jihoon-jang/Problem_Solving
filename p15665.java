import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class p15665 {
	static int n, m, array[];
	static LinkedHashSet<String> set = new LinkedHashSet<String>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		m = Integer.parseInt(stz.nextToken());
		stz = new StringTokenizer(br.readLine());
		array = new int[n];

		for(int i = 0; i < n; i++)
			array[i] = Integer.parseInt(stz.nextToken());

		Arrays.sort(array);
		dfs(0, "");

		Iterator it = set.iterator();

		while(it.hasNext())
			System.out.println(it.next());
	}

	public static void dfs(int length, String s) {
		if(length == m) {
			set.add(s);
			return;
		}

		for(int i = 0; i < n; i++) {
			dfs(length+1, s+array[i]+" ");
		}
	}

}
