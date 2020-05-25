import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p17281 {
	static int map[][];
	static int order[] = new int[9];
	static boolean visit[] = new boolean[9];
	static int board[];
	static int answer = 0;
	static int inning;
	static int score;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inning = Integer.parseInt(br.readLine());
		order[3] = 1;
		visit[0] = true;
		map = new int[inning][9];
		for(int i = 0; i < inning; i++) {
			String sa[] = br.readLine().split(" ");
			for(int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(sa[j]);
			}
		}
		torder(0);

		System.out.println(answer);

	}

	public static void b(int s) {
		for(int i = 1; i <= 3; i++) {
			if(board[i] == 1 && i-s <= 0) {
				board[i] = 0;;
				score ++;
			}
			else if(board[i] == 1 &&i-s > 0) {
				board[i-s] = board[i];
				board[i]= 0;
			}
		}
		board[4-s] = 1;
		if(s==4)
			score++;
	}

	public static void cal() {
		score = 0;
		int start = 0;
		for(int i = 0; i < inning; i++) {
			board = new int[4];
			int out = 0;
			for(int j = start; ; j=(j+1)%9) {
				start = (j+1)%9;
				int n = map[i][order[j]-1];
				switch(n) {
				case 0: out++; break;
				case 1:b(1); break;
				case 2:b(2); break;
				case 3:b(3); break;
				case 4:b(4); break;
				}
				if(out == 3)
					break;
			}
		}
		answer = answer < score ? score : answer;
	}

	public static void torder(int len) {
		if(len == 9) {
			cal();
			return;
		}
		else if(len ==3) {
			torder(len+1);
		}
		else {
			for(int i = 1; i < 9; i++) {
				if(!visit[i]) {
					visit[i] = true;
					if(len != 3) 
						order[len] = i+1;
					torder(len+1);
					visit[i] = false;
				}
			}
		}
	}

}
