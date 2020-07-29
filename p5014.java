import java.io.*;
import java.util.*;

public class p5014 {
	static int f, s, g, u, d, value[];
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		f = Integer.parseInt(stz.nextToken());
		s = Integer.parseInt(stz.nextToken());
		g = Integer.parseInt(stz.nextToken());
		u = Integer.parseInt(stz.nextToken());
		d = Integer.parseInt(stz.nextToken());
		value = new int[1000001];
		visit = new boolean[1000001];
		
		elevator();
	}
	
	public static void elevator() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visit[s] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();

			if(now == g) {
				System.out.println(value[g]);
				return;
			}
			
			if(now + u <= f && !visit[now+u]) {
				visit[now+u] = true;
				value[now+u] = value[now]+1;
				q.add(now+u);
			}
			if(now - d >= 1 && !visit[now-d]) {
				visit[now-d] = true;
				value[now-d] = value[now]+1;
				q.add(now-d);
			}
		}
		
		System.out.println("use the stairs");
	}

}
