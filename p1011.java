import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1011 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < t; tc++) {
			stz = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stz.nextToken());
			int y = Integer.parseInt(stz.nextToken());
			int distance = y-x;
			int max = (int)Math.sqrt(distance);
			
			if(max == Math.sqrt(distance))
				sb.append(max*2-1).append("\n");
			else if(distance <= max*max + max)
				sb.append(max*2).append("\n");
			else
				sb.append(max*2+1).append("\n");
		}
		System.out.println(sb.toString());
	}


}
