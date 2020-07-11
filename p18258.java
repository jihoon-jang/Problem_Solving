import java.io.*;
import java.util.*;

public class p18258 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int current = 0;

		for(int i = 0; i < n; i++)
		{
			String s = br.readLine();
			String c = s.split(" ")[0];
			switch(c)
			{
			case "push":
				q.add(Integer.parseInt(s.split(" ")[1]));
				current = Integer.parseInt(s.split(" ")[1]);
				break;
			case "pop":
				if (q.size() == 0)
					sb.append("-1\n");
				else
					sb.append(q.poll()+"\n");
				break;
			case "size":
				sb.append(q.size()+"\n");
				break;
			case "empty":
				sb.append(q.size() == 0 ? 1+"\n" : 0+"\n");
				break;
			case "front":
				if (q.size() == 0)
					sb.append("-1"+"\n");
				else
					sb.append(q.peek()+"\n");
				break;
			case "back":
				if (q.size() == 0)
					sb.append("-1"+"\n");
				else
					sb.append(current+"\n");
				break;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();

	}

}
