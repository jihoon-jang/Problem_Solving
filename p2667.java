import java.util.*;
public class p2667 {
	static Scanner in = new Scanner(System.in);
	static int size = Integer.parseInt(in.nextLine());
	static int map[][] = new int[size+2][size+2];
	static boolean visit[][] = new boolean[size+2][size+2];
	static int n = 0;
	static int xc[] = {-1, 0, 0, 1};
	static int yc[] = {0, 1, -1, 0};

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		makemap();
		for(int i = 1; i <= size; i++) {
			for(int j = 1; j <= size; j++) {
				if(n != 0) 
					al.add(n);
				n = 0;
				dfs(i, j);
			}
		}
		System.out.println(al.size());
		Collections.sort(al);
		for(int i = 0; i < al.size(); i++)
			System.out.println(al.get(i));
	}

	public static void dfs(int x, int y) {
		if(!visit[x][y]) {
			visit[x][y] = true;
			if(map[x][y] == 1) {
					n++;
				for(int i = 0; i < 4; i++) {
					dfs(x+xc[i], y+yc[i]);
				}
			}
		}
	}

	public static void makemap() {
		for(int i = 1; i <= size; i++) {
			String s = in.nextLine();
			String sa[] = s.split("");
			for(int j = 1; j <= size; j++) {
				map[i][j] = Integer.parseInt(sa[j-1]);
			}
		}
	}
}
