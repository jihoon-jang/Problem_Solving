import java.util.*;

public class p17406 {
	static int map[][];
	static int n, m, k;
	static boolean visit[];
	static ver v[];
	static int answer;
	static int dx[] = {-1,-1,1,1};
	static int dy[] = {1,-1,-1,1};
	static int rx[] = {0,1,0,-1};
	static int ry[] = {-1,0,1,0};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); m = in.nextInt(); k = in.nextInt();
		map = new int[n+1][m+1];
		for(int i = 1; i <= n; i ++) 
			for(int j = 1; j <= m; j++)
				map[i][j] = in.nextInt();
		visit = new boolean[k];
		v = new ver[k];
		for(int i = 0; i < k; i++)
			v[i] = new ver(in.nextInt(), in.nextInt(), in.nextInt());
		answer = Integer.MAX_VALUE;
		mix(0);

		System.out.println(answer);
	}

	public static void cal(int index) {
		ver vr = v[index];
		int x = vr.x;
		int y = vr.y;
		int len = vr.len;

		for(int a = 1; a <= len; a++) { // 몇 번째 라인.
			int num = map[x+dx[0]*a][y+dy[0]*a];
			for(int f = 0; f < 4; f++ ) { //4번 반 복.
				int sx = (x + dx[f]*a);
				int sy = (y + dy[f]*a);
				for(int i = 1; i <= 2*a; i++) { // 라인의 갯수
					map[sx+(i-1)*rx[f]][sy+(i-1)*ry[f]] = map[sx+(i)*rx[f]][sy+(i)*ry[f]];
				}
			}
			map[x+dx[3]*a+(2*a-1)*rx[3]][y+dy[3]*a+(2*a-1)*ry[3]] = num;
		}
		
	}
	
	public static void ismin() {
		for(int i = 1; i <= n; i++) {
			int sum = 0;
			for(int j = 1; j <= m; j++)
				sum += map[i][j];
			answer = Math.min(sum, answer);
		}
	}

	public static void mix(int len) {
		if(len == k) {
			ismin();
			return;
		}
		else {
			for(int i = 0; i < k; i++) { 
				if(!visit[i] ) {
					visit[i] = true;
					int temp[][] = new int[n+1][m+1];
					for(int a = 1; a <= n; a++)
						for(int j = 1; j <= m; j++)
							temp[a][j] = map[a][j];
					cal(i);
					mix(len + 1);
					for(int a = 1; a <= n; a++)
						for(int j = 1; j <= m; j++)
							map[a][j] = temp[a][j];
					visit[i] = false;
				}
			}
		}
	}

}

class ver {
	int x, y, len;
	ver(int x, int y, int len) {
		this.x = x;
		this.y = y;
		this.len = len;
	}
}