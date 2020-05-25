import java.util.Scanner;

public class p13140 {
	static int d, e, h, l, o, r, w;
	static int n1, n2, answer;
	static boolean visit[] = new boolean[10];
	static boolean search = false;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		answer = in.nextInt();
		
		dfs(0);
		
		if(!search)
			System.out.println("No Answer");
	}

	public static void dfs(int len) {
		if(search)
			return;
		if(len == 7) {
			set();
			return;
		}
		else {
			for(int i = 0; i <= 9; i++) {
				if(!visit[i]) {
					if(len <= 1) {
						if(i == 0)
							continue;
					}
					visit[i] = true;
					switch(len) {
					case 0: h = i; break;
					case 1: w = i; break;
					case 2: l = i; break;
					case 3: e = i; break;
					case 4: o = i; break;
					case 5: r = i; break;
					case 6: d = i; break;
					}
					dfs(len+1);
					visit[i] = false;
				}
			}
		}
	}

	public static void set() {
		n1 = h*10000+e*1000+l*110+o;
		n2 = w*10000+o*1000+r*100+l*10+d;
		if(n1 + n2 == answer) {
			search = true;
			System.out.format("%7d\n",n1);
			System.out.format("+%6d\n",n2);
			System.out.println("-------");
			System.out.format("%7d\n",answer);
		}
		
	}

}
