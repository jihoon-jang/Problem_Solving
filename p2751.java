import java.io.*;
import java.util.*;

public class p2751 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> al = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++)
			al.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(al);
		
		sb.append(al.get(0)+"\n");
		for(int i = 1; i < n; i++)
			if(al.get(i-1) != al.get(i))
				sb.append(al.get(i)+"\n");
		bw.write(sb.toString());
		
		bw.flush();
	}
}