import java.util.*;
import java.io.*;

public class p7785 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		TreeSet<String> set = new TreeSet<String>();

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++)
		{
			String[] s = br.readLine().split(" ");
			if (s[1].equals("enter")) 
				set.add(s[0]);
			else
				set.remove(s[0]);
		}

		for(Iterator<String> it = set.descendingIterator(); it.hasNext();) {
			sb.append(it.next()).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}

