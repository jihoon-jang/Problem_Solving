import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1992 {
	static int n, map[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			for(int j = 0; j < n; j++) 
				map[i][j] = line.charAt(j)-'0';
		}

		if(check(map[0][0], 0, 0, n)) {
			System.out.println(map[0][0]);
			return;
		}
		else
			part(0, 0, n/2);

		System.out.println(sb.toString());
	}

	public static void part(int x, int y, int size) {
		sb.append("(");
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				if(check(map[x+i*size][y+j*size], x+i*size, y+j*size, size)) {
					if(map[x+i*size][y+j*size] == 1)
						sb.append(1);
					else
						sb.append(0);
				}
				else {
					part(x+i*size, y+j*size, size/2);
				}
			}
		}
		sb.append(")");
	}

	public static boolean check(int color, int x, int y, int size) {
		for(int i = 0; i < size; i++) 
			for(int j = 0; j < size; j++)
				if(map[x + i][y + j] != color)
					return false;

		return true;
	}

}
