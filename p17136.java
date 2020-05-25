import java.io.*;

public class p17136 {
	static int answer = Integer.MAX_VALUE;
	static int paper[] = {0,5,5,5,5,5};
	static int map[][] = new int[10][10];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 10; i++) {
			String sa[] = br.readLine().split(" ");
			for(int j = 0; j < 10; j++)
				map[i][j] = Integer.parseInt(sa[j]);
		}

		dfs(0,0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	public static boolean check(int x, int y, int size) {
		if(x+size > 10 || y+size > 10)
			return false;
		else {
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(map[x+i][y+j] == 0)
						return false;
				}
			}
		}
		return true;
	}

	public static void paint(int x, int y, int size, int num) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				map[x+i][y+j] = num;
			}
		}
	}

	public static void dfs(int index, int count) {
		if(index == 100) {
			answer = Math.min(count, answer);
			return;
		}
		else if(count >= answer) return;
		else {
			int x = index/10;
			int y = index%10;
			if(map[x][y] == 1) { 	
				for(int i = 5; i >= 1; i--) {
					if(check(x, y, i)) {
						paper[i] --;
						if(paper[i] < 0) {
							paper[i]++;
							return;
						}
						paint(x,y,i,0);
						dfs(index+1,count+1);
						paint(x,y,i,1);
						paper[i] ++;
					}
				}
			}
			else
				dfs(index+1, count);
		}
	}

}
