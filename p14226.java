import java.util.*;
import java.io.*;

public class p14226 {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());	

		emoticon();
	}

	public static void emoticon() {
		int time[][] = new int[n+1][n+1];
		Queue<Now> q = new LinkedList<Now>();
		q.add(new Now(1, 0));
		for(int i = 0; i < n+1; i++)
			Arrays.fill(time[i], -1);
		time[1][0] = 0;

		while(!q.isEmpty()) {
			Now now = q.poll();

			if(time[now.screen][now.screen] == -1) {
				time[now.screen][now.screen] = time[now.screen][now.clip] + 1;
				q.add(new Now(now.screen, now.screen));
			}
			if(now.screen+now.clip <= n && time[now.screen+now.clip][now.clip] == -1) { 
				time[now.screen+now.clip][now.clip] = time[now.screen][now.clip] + 1;
				q.add(new Now(now.screen+now.clip, now.clip));
			}
			if(now.screen-1 >= 0 && time[now.screen-1][now.clip] == -1) {
				time[now.screen-1][now.clip] = time[now.screen][now.clip] + 1;
				q.add(new Now(now.screen-1, now.clip));
			}
		}
		int answer = Integer.MAX_VALUE;

		for(int i = 0; i <= n; i++)
			if(time[n][i] != -1)
				answer = Math.min(answer, time[n][i]);
		System.out.println(answer);
	}

	static class Now{
		int screen;
		int clip;

		Now(int screen, int clip){
			this.screen = screen;
			this.clip = clip;
		}
	}
}
