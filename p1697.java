import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1697 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();

		if(n1 >= n2)
			System.out.println(Math.abs(n1-n2));
		else
			dfs(n1, n2);
	}

	public static boolean check(int n) {
		return n >= 0 && n <= 100000;
	}

	public static void dfs(int n1, int n2) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n1);
		int num[] = new int[100001];

		while(!q.isEmpty()) {
			int now = q.poll();
			int next;

			next = now + 1;
			if(check(next) && num[next] == 0) {
				q.add(next);
				num[next] = num[now] + 1;
				if(next == n2) {
					System.out.println(num[next]);
					return;
				}
			}

			next = now - 1;
			if(check(next) && num[next] == 0) {
				q.add(next);
				num[next] = num[now] + 1;
				if(next == n2) {
					System.out.println(num[next]);
					return;
				}
			}

			next = now * 2;
			if(check(next) && num[next] == 0) {
				q.add(next);
				num[next] = num[now] + 1;
				if(next == n2) {
					System.out.println(num[next]);
					return;
				}
			}
		}
	}

}
