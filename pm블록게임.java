
public class pm블록게임 {

	public int map[][];
	public int n;
	public int board[][];
	public int answer;
	public boolean finish;

	public int solution(int[][] board) {
		n = board.length;
		answer = 0;
		map = new int[n][n];
		this.board = board;
		finish = false;

		while(!finish) {
			finish = true;
			for(int i = 0; i < n; i++)
				map[i] = board[i].clone();
			black();
		}

		return answer;
	}

	public void black() {
		for(int i = 0; i < n; i++) {
			int count = 2;
			int j = 0;
			for(; j < n; j++) 
				if(map[j][i] != 0)
					break;
			j -= 1;
			while(count > 0 && j >= 0){
				map[j--][i] = -1;
				count--;
			}
		}

		search();
	}

	public void search() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				remove(i, j);
			}
		}
	}

	public void remove(int x, int y) {
		int black = 2;
		int other = 4;
		int block = -2;

		l:	for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++) {
				int nx = x + i;
				int ny = y + j;

				if(check(nx, ny)) {
					if(map[nx][ny] == -1)
						black--;
					else if(map[nx][ny] == 0)
						break l;
					else {
						if(block == -2)
							block = map[nx][ny];
						if(block != map[nx][ny])
							break l;
						other--;
					}
				}
			}
		}

		if(black == 0 && other == 0) {
			answer++;
			finish = false;
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 3; j++) {
					int nx = x + i;
					int ny = y + j;

					board[nx][ny] = 0;
				}
			}
			return;
		}

		black = 2;
		other = 4;
		block = -2;

		l:	for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 2; j++) {
				int nx = x + i;
				int ny = y + j;

				if(check(nx, ny)) {
					if(map[nx][ny] == -1)
						black--;
					else if(map[nx][ny] == 0)
						break l;
					else {
						if(block == -2)
							block = map[nx][ny];
						if(block != map[nx][ny])
							break l;
						other--;
					}
				}
			}
		}

		if(black == 0 && other == 0) {
			answer++;
			finish = false;
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 2; j++) {
					int nx = x + i;
					int ny = y + j;

					board[nx][ny] = 0;
				}
			}
			return;
		}

	}

	public boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < n;
	}
}