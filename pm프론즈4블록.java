import java.util.*;

class pm프론즈4블록 {
	public int solution(int m, int n, String[] board) {
		char map[][] = new char[m][n];
		for(int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
		}
		block(m,n,map);

		return count(m, n, map);
	}

	public int count(int m, int n, char map[][]) {
		int count = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == ' ')
					count ++;
			}
		}

		return count;
	}

	public void block(int m, int n, char map[][]) {
		boolean finish = false;        

		while(!finish) {
			finish = true;
			LinkedList<Integer> x = new LinkedList<Integer>();
			LinkedList<Integer> y = new LinkedList<Integer>();

			for(int i = 0; i < m-1; i++) {
				for(int j = 0; j < n-1; j++) {
					if(check(i, j, map) && map[i][j] != ' '){
						finish = false;
						x.add(i);
						x.add(i);
						x.add(i+1);
						x.add(i+1);
						y.add(j);
						y.add(j+1);
						y.add(j);
						y.add(j+1);
					}
				}
			}

			while(x.size() != 0) {
				int bx = x.remove(0);
				int by = y.remove(0);
				map[bx][by] = ' ';
			}
			set(m,n,map);
		}
	}

	public void set(int m, int n, char map[][]) {
		ArrayList<Character> al;
		for(int i = 0; i < n; i++) {
			al = new ArrayList<Character>();
			for(int j = m-1; j>=0; j--) {
				if(map[j][i] != ' ')
					al.add(map[j][i]);
				map[j][i] = ' ';
			}

			for(int j = 0; j < al.size(); j++)
				map[m-1-j][i] = al.get(j);
		}
	}

	public boolean check(int x, int y, char map[][]) {
		if(map[x][y] == map[x+1][y] && map[x][y] == map[x][y+1] && map[x][y+1] == map[x+1][y+1])
			return true;
		else
			return false;
	}
}