import java.io.*;
import java.util.*;

public class p2002 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		ArrayList<String> al = new ArrayList<String>();

		for(int i = 0; i < n; i++)
			al.add(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			if(al.get(0).equals(s))
				al.remove(0);
			else {
				answer++;
				al.remove(al.indexOf(s));
			}
		}
		
		System.out.println(answer);
	}

}

