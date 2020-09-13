import java.util.*;
import java.io.*;

public class p2953 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int index = 0;
		for(int i = 0; i < 5; i++) {
			int score = 0;
			StringTokenizer stz = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++)
				score += Integer.parseInt(stz.nextToken());
		}
	}

}
