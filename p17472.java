import java.util.ArrayList;
import java.util.Scanner;

public class p17472 {
	static int n, m, answer = Integer.MAX_VALUE, index, map[][];
	static int dx[] = {-1,0,1,0};//상 우 하 좌
	static int dy[] = {0,1,0,-1};
	static int w[][];
	static ArrayList<bridge> al = new ArrayList<bridge>();
	static boolean visit[];
	static boolean v[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); m = in.nextInt();
		map = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				map[i][j] = in.nextInt();
		island();
		w =  new int[index][index];
		visit = new boolean[index];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] != 0) {
					for(int k = 0; k < 4; k++)
						make(map[i][j], i, j, k, 0);
				}
			}
		}
		list();
		v = new boolean[al.size()];
		cal(0,0,"");

		System.out.println(answer == Integer.MAX_VALUE? -1 : answer);
	}

	public static void list() {
		for(int i = 2; i < index; i++) {
			for(int j = i; j < index; j++)
				if(w[i][j] != 0) {
					al.add(new bridge(w[i][j], i, j));
				}
		}
	}

	public static void dfs(int n, ArrayList<Integer> a[]) {
		if(!visit[n]) {
			visit[n] = true;
			for(int i = 0; i < a[n].size(); i++) {
				dfs(a[n].get(i), a);
			}
		}

	}

	public static boolean connect(int n, ArrayList<Integer> a[]) {
		dfs(n, a);

		for(int i = 2; i < index; i++) {
			if(!visit[i])
				return false;
		}

		return true;
	}

	public static void cal(int len, int start, String s) {
		if(len == index -3) {
			int count = 0;
			visit = new boolean[index];
			String sa[] = s.split(" ");
			ArrayList<Integer> a[] = new ArrayList[index];
			for(int i = 2; i < index; i++)
				a[i] = new ArrayList<Integer>();

			for(int i = 0; i < sa.length; i++) {
				bridge b = al.get(Integer.parseInt(sa[i]));
				a[b.start].add(b.dis);
				a[b.dis].add(b.start);
				count += b.length;
			}
			if(!connect(2, a))
				return;
			answer = Math.min(answer, count);
			return;
		}
		else {
			for(int i =start; i < al.size(); i++) {
				if(!v[i]) {
					v[i] = true;
					cal(len+1,i, s+ i+ " ");
					v[i] = false;
				}
			}
		}
	}

	public static void make(int start, int x, int y, int ind, int count) {
		if(map[x][y] != 0 && map[x][y] != start) {
			if(count > 1) {
				if(w[start][map[x][y]] == 0 || w[start][map[x][y]] > count) {
					w[start][map[x][y]] = count;
					w[map[x][y]][start] = count;
				}
			}
			return;
		}

		if(count > 0 && map[x][y] == start)
			return;
		int nx = x + dx[ind];
		int ny = y + dy[ind];
		if(check(nx, ny)) {
			make(start, nx, ny, ind, map[nx][ny] == 0 ? count + 1: count);
		}
	}

	public static boolean check(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	public static void dfs(int x, int y, int index) {
		if(check(x,y)) {
			if(map[x][y] == 1) {
				map[x][y] = index;
				for(int i = 0; i < 4; i++)
					dfs(x+dx[i], y+dy[i], index);
			}
		}
	}

	public static void island() {
		index = 2;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(map[i][j] == 1) 
					dfs(i, j, index++);
	}
}

class bridge{
	int start ,dis, length;
	bridge(int l, int d, int s){ 
		length = l;
		dis = d;
		start = s;
	}
}
