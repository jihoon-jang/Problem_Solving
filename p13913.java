import java.io.*;
import java.util.*;

public class p13913 {
	static int n, k, array[], before[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		k = Integer.parseInt(s[1]);

		search();
	}

	public static void search() {
		array = new int[100001];
		before = new int[100001];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		Arrays.fill(array, -1);
		array[n] = 0;

		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == k) {
				break;
			}

			if(now*2 < 100001 && array[now*2] == -1) {
				array[now*2] = array[now]+1;
				before[now*2] = now;
				q.offer(now*2);
			}
			if(now+1 < 100001 && array[now+1] == -1) {
				array[now+1] = array[now]+1;
				before[now+1] = now;
				q.offer(now+1);
			}
			if(now-1 >= 0 && array[now-1] == -1) {	
				array[now-1] = array[now]+1;
				before[now-1] = now;
				q.offer(now-1);
			}

		}
		System.out.println(array[k]);
		path();
	}

	public static void path() {
		StringBuilder sb = new StringBuilder();

		int now = k;

		while(now != n) {
			sb.append(now+ " ");
			now = before[now];
		}
		sb.append(now);
		String s[] = sb.toString().trim().split(" ");

		for(int i = s.length-1; i >= 0; i--)
			System.out.print(s[i]+" ");
	}

}
