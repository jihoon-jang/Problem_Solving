import java.util.*;

public class pm키패드누르기 {

	public Map<Character, Point> map = new HashMap<Character, Point>();
	public Point left, right;
	public String hand;

	public String solution(int[] numbers, String hand) {
		char c[][] = {{'1','2','3'},{'4','5','6'},{'7','8','9'},{'*','0','#'}};
		for(int i = 0; i < 4; i++) 
			for(int j = 0; j < 3; j++)
				map.put(c[i][j], new Point(i, j));

		left = map.get('*');
		right = map.get('#');
		this.hand = hand;

		StringBuilder sb = new StringBuilder();
		for(int number : numbers) {
			sb.append(touch(number));
		}

		return sb.toString();
	}

	public char touch(int n) {
		Point dest = map.get((char)('0' + n));
		if(n == 1 || n == 4 || n == 7) {
			left = dest;
			return 'L';
		}
		else if(n == 3 || n == 6 || n == 9) {
			right = dest;
			return 'R';
		}
		else {
			int l = left.dis(dest);
			int r = right.dis(dest);

			if(l < r) {
				left = dest;
				return 'L';
			}
			else if(l > r) {
				right = dest;
				return 'R';
			}
			else {
				if(hand.equals("left")) {
					left = dest;
					return 'L';
				}
				else {
					right = dest;
					return 'R';
				}
			}
		}
	}

	class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int dis(Point p) {
			return Math.abs(x - p.x) + Math.abs(y - p.y);
		}
	}
}