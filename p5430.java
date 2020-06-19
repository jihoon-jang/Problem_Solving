import java.io.*;
import java.util.LinkedList;


public class p5430 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		l:	for(int t = 0; t < tc; t++) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			LinkedList<Integer> ll = new LinkedList<Integer>();
			StringBuilder sb = new StringBuilder();
			sb.append(br.readLine());
			sb.deleteCharAt(sb.length()-1);
			sb.deleteCharAt(0);
			String s[] = sb.toString().split(",");
			for(int i = 0; i < n; i++)
				ll.add(Integer.parseInt(s[i]));
			
			boolean first = true;
			for(int i = 0; i < command.length(); i++) {
				char c = command.charAt(i);
				if(c == 'D' && ll.size() == 0) {
					bw.write("error");
					continue l;
				}
				switch(c) {
				case 'D':if(first) ll.removeFirst(); else ll.removeLast(); break;
				case 'R':if(first) first = false; else  first = true; break;
				}
			}
			
			sb = new StringBuilder();
			if(first) {
				sb.append("[");
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
	}

}
