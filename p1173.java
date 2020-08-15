import java.util.*;
import java.io.*;

public class p1173 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stz.nextToken()); //¸ñÇ¥ ½Ã°£
		int m = Integer.parseInt(stz.nextToken()); //Ã¹ ¸Æ¹Ú, ÃÖ¼Ò ¸Æ¹Ú
		int M = Integer.parseInt(stz.nextToken()); //ÃÖ´ë ¸Æ¹Ú
		int T = Integer.parseInt(stz.nextToken()); //¸Æ¹Ú Áõ°¡Ä¡
		int R = Integer.parseInt(stz.nextToken()); //°¨¼Ò ¸Æ¹Ú

		if(m + T > M) {
			System.out.println(-1);
			return;
		}
		
		int answer = 0;
		int heart = m;
		
		while(N > 0) {
			if(heart + T <= M) {
				N--;
				heart += T;
			}
			else if(heart + T > M) {
				heart -= R;
				if(heart < m)
					heart = m;
			}
			answer++;
		}
		
		System.out.println(answer);
	}

}
