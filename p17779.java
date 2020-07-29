import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17779 {
	static int n, map[][], answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		map = new int[n+1][n+1];
		answer = Integer.MAX_VALUE;

		for(int i = 1; i <= n; i++) {
			stz = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++)
				map[i][j] = Integer.parseInt(stz.nextToken());
		}
		startPoint();
		System.out.println(answer);
	}

	public static void startPoint() {
		for(int i = 1; i <= n-2; i++) 
			for(int j = 2; j <= n-1; j++) 
				boundary(i, j);
	}

	public static void boundary(int x, int y) {
		for(int d1 = 1; d1 <= 100 ; d1++) {
			for(int d2 = 1; d2 <= 100 ; d2++) {
				if(!check(x+d1,y) || !check(x+d2,y) || !check(x,y-d1) || !check(x,y+d2)
						||!check(x+d1+d2,y) || !check(x,y-d1+d2) || !check(x+d2+d1,y) || !check(x, y+d2-d1))
					break;
				population(x, y, d1, d2);
			}
		}
	}
	
	public static void population(int x, int y, int d1, int d2) {
		int p1, p2, p3, p4, p5;
		int min = Integer.MAX_VALUE;
		int max = 0;
		boolean visit[][] = new boolean[n+1][n+1];
		p1 = p2 = p3 = p4 = p5 = 0;
		
		int nx = y; 
		int ny = y;
		int n1 = d1;
		int n2 = 0;
		boolean b1 = false;
		boolean b2 = false;
		
		for(int i = x; i <= x + d1+d2; i++) {
			for(int j = nx; j <= ny; j++) {
				visit[i][j] = true;
				p5 += map[i][j];
			}
			if(!b1) {
				nx--;
				n1--;
			}
			else 
				nx++;
			if(!b2) {
				ny++;
				n2++;
			}		
			else
				ny--;
			if(n1 == 0)
				b1 = true;
			if(n2 == d2)
				b2 = true;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(!visit[i][j] && i < x+d1 && j <= y)
					p1 += map[i][j];
				else if(!visit[i][j] && i <= x+d2 && j > y)
					p2 += map[i][j];
				else if(!visit[i][j] && i >= x+d1 && j < y-d1+d2)
					p3 += map[i][j];
				else if(!visit[i][j] && i > x+d2 && j >= y-d1+d2)
					p4 += map[i][j];
			}
		}
		
		min = Math.min(p1, Math.min(p2, Math.min(p3, Math.min(p4, p5))));
		max = Math.max(p1, Math.max(p2, Math.max(p3, Math.max(p4, p5))));
		answer = Math.min(max-min, answer);
	}

	public static boolean check(int x, int y) {
		return x >= 1 && y >= 1 && y <= n && x <= n;
	}

	static void print(){
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
	}

}
