import java.io.*;
import java.util.*;

public class p17219 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s[] = br.readLine().split(" ");
		HashMap<String, String> map = new HashMap<String, String>();
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		for(int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			map.put(s[0], s[1]);
		}
		
		for(int i = 0; i < m; i++) 
			bw.write(map.get(br.readLine())+"\n");
		
		bw.flush();
	}

}
