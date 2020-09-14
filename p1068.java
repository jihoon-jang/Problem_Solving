import java.util.*;
import java.io.*;

public class p1068 {

	public static LinkedList<Integer> list[];
	public static int n, remove;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new LinkedList[n];
		for(int i = 0; i < n; i++)
			list[i] = new LinkedList<Integer>();
		StringTokenizer stz = new StringTokenizer(br.readLine());

		int start = 0;
		for(int i = 0; i < n; i++) {
			int now = Integer.parseInt(stz.nextToken());
			if(now == -1) {
				start = i;
				continue;
			}
			list[now].add(i);
			list[i].add(now);
		}
		remove = Integer.parseInt(br.readLine());
		System.out.println(start == remove ? 0 : count(start));
	}

	public static int count(int start) {
		boolean visit[] = new boolean[n];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visit[start] = true;
		int count = 0;

		while(!q.isEmpty()) {
			int now = q.poll();
			boolean leaf = true;
			Iterator<Integer> it = list[now].iterator();

			while(it.hasNext()) {
				int child = it.next();
				if(child == remove)
					visit[child] = true;

				if(!visit[child]) {
					visit[child] = true;
					q.offer(child);
					leaf = false;
				}

			}
			if(leaf)
				count++;
		}

		return count;
	}

}
