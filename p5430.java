import java.io.*;
import java.util.*;


public class p5430 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		l:	for(int t = 0; t < tc; t++) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			List<Integer> ll = new ArrayList<Integer>();
			String number = br.readLine();
			number = number.replace("[", "");
			number = number.replace("]", "");
			String s[] = number.split(",");
			for(int i = 0; i < n; i++)
				ll.add(Integer.parseInt(s[i]));
			
			boolean first = true;
			for(int i = 0; i < command.length(); i++) {
				char c = command.charAt(i);
				if(c == 'D' && ll.size() == 0) {
					bw.write("error\n");
					continue l;
				}
				switch(c) {
				case 'D':if(first) ll.remove(0); else ll.remove(ll.size()-1); break;
				case 'R':if(first) first = false; else  first = true; break;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			if(first) {
				sb.append("[");

				System.out.println(ll.iterator().toString());
				
				
				
				for(int i = 0; i < ll.size(); i++) 
					sb.append(ll.get(i)+",");
				sb.deleteCharAt(sb.length()-1);
				sb.append("]\n");
			}
			else {
				sb.append("[");
				for(int i = ll.size()-1; i >= 0; i--) 
					sb.append(ll.get(i)+",");
				sb.deleteCharAt(sb.length()-1);
				sb.append("]\n");
			}
			
			bw.write(sb.length() == 2? "[]\n":sb.toString());
		}
		bw.flush();
	}

}
