import java.util.*;

public class p17471 {
	static int n, p1, p2;
	static int pop[];
	static int map[][];
	static int team[];
	static int answer;
	static boolean visit[];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		pop = new int[n];
		for(int i = 0; i < n; i++)
			pop[i] = in.nextInt();
		map = new int[n][n];
		team = new int[n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++) {
			int temp = in.nextInt();
			for(int j = 0; j < temp; j++) {
				int index = in.nextInt()-1;
				map[i][index] = 1;
			}
		}
		answer = Integer.MAX_VALUE;
		maketeam(0);

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	public static void cal(int now) {
		visit[now] = true;
		for(int i = 0; i < n; i++) {
			if(team[now] == team[i] && !visit[i] && map[now][i] == 1) {
				if(team[i] == 1 )
					p1 += pop[i];
				else
					p2 += pop[i];
				cal(i);
			}
		}
	}

	public static void maketeam(int len) {
		if(len == n) {
			visit = new boolean[n];
			p1 = p2 = 0;
			for(int i = 0; i < n; i++) {
				if(team[i] == 1 && !visit[i]) {
					visit[i] = true;
					p1 += pop[i];
					cal(i);
					break;
				}
			}

			for(int i = 0; i < n; i++) {
				if(team[i] == 2 && !visit[i]) {
					visit[i] = true;
					p2 += pop[i];
					cal(i);
					break;
				}
			}

			for(int i = 0; i < n; i++)
				if(!visit[i])
					return;

			answer = Math.min(answer, Math.abs(p1-p2));
			return;
		}
		else {
			for(int i = 1; i <= 2; i++) {
				team[len] = i;
				maketeam(len+1);
			}
		}
	}
}