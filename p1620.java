import java.io.*;
import java.util.*;

public class p1620 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		String array[] = new String[n+1];
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 1; i <= n; i++) {
			String poket = br.readLine();
			array[i] = poket;
			map.put(poket, i);
		}
		
		for(int i = 0; i < m; i++) {
			String command = br.readLine();
			if(command.charAt(0) >= '0' && command.charAt(0) <= '9') {
				int number = Integer.parseInt(command);
				bw.write(String.valueOf(array[number])+"\n");
			}
			else
				bw.write(String.valueOf(map.get(command)+"\n"));
			
		}
		
		bw.flush();
	}

}
