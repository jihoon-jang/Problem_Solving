import java.io.*;

public class p18111 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]); 
		int m = Integer.parseInt(s[1]); 
		int b = Integer.parseInt(s[2]); 
		int map[][] = new int[n][m];
		int min = 256;
		int max = 0;
		int sum = 0;

		for(int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
				sum += map[i][j];
			}
		}

		int answer = Integer.MAX_VALUE;
		int height = 0;
		for(int i = max; i >= min; i--) {
			int temp = 0;
			if(i*n*m > sum+b)
				continue;
			else {
				l:	for(int l = 0; l < n; l++) {
					for(int o = 0; o < m; o++) {
						if(temp > answer)
							break l;
						if(map[l][o] > i)
							temp += (map[l][o] - i) * 2;
						else
							temp += i - map[l][o];
					}
				}
			}

			if(answer > temp) {
				answer = temp;
				height = i;
			}
		}

		System.out.println(answer + " "+ height);

	}

}
