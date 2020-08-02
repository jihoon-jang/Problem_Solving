import java.util.Scanner;

public class p1074 {
	static int n, r, c, answer = 0;
	static boolean b = false;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		r = in.nextInt();
		c = in.nextInt();

		check(0, 0, (int)Math.pow(2, n));
	}

	public static void check(int x, int y, int size) {
		if(size == 0 || b)
			return; 
		
		if(!((x <= r && x+size >= r)&&(y <= c && y+size >= c))) {
			answer += size*size;
			return;
		}
		if((x != r || y != c ) && size == 1) 
			answer ++;
		
		else if(x == r && c == y && size == 1) {
			System.out.println(answer);
			b = true;
			return;
		}
		
		else
			for(int i = 0; i < 2; i++)
				for(int j = 0; j < 2; j++)
					check(x + i*size/2, y + j*size/2, size/2);
	}

}
