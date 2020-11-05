import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14890 {
	
	static int n, l, answer, map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		l = Integer.parseInt(stz.nextToken());
		answer = 0;
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			stz = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(stz.nextToken());
		}
		
		searchX();
		searchY();
		System.out.println(answer);
	}
	
	public static void searchX() {
		for(int i = 0; i < n; i++) {
			int count = 1;
			int value = map[i][0];
			boolean path = true;
			for(int j = 1; j < n; j++) {
				int now = map[i][j];
				if(now == value)
					count++;
				else if(count < 0) {
					path = false;
					break;
				}
				else if(Math.abs(now - value) > 1) {
					path = false;
					break;
				}
				else if(now > value) {
						if(count >= l) {
							value = now;
							count = 1;
						}
						else {
							path = false;
							break;
						}
					}
					else {
						count = -l+1;
						value = now;
					}
			}
			if(path && count >= 0)
				answer++;
		}
	}
	
	public static void searchY() {
		for(int i = 0; i < n; i++) {
			int count = 1;
			int value = map[0][i];
			boolean path = true;
			for(int j = 1; j < n; j++) {
				int now = map[j][i];
				if(now == value)
					count++;
				else if(count < 0) {
					path = false;
					break;
				}
				else if(Math.abs(now - value) > 1) {
					path = false;
					break;
				}
				else if(now > value) {
						if(count >= l) {
							value = now;
							count = 1;
						}
						else {
							path = false;
							break;
						}
					}
					else {
						count = -l+1;
						value = now;
					}
			}
			if(path && count >= 0)
				answer++;
		}
	}
}
