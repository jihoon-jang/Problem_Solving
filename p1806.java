import java.util.*;
import java.io.*;

public class p1806 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stz.nextToken());
		int s = Integer.parseInt(stz.nextToken());
		int array[] = new int[n];

		stz = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			array[i] = Integer.parseInt(stz.nextToken());

		int answer = Integer.MAX_VALUE;
		int sum = 0;
		int left = 0;
		int right = 0;
		while(true) {
			if(sum >= s) {
				answer = Math.min(answer, right-left);
				sum -= array[left++];
			}
			else if(right == n)
				break;
			else
				sum += array[right++];
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}

}
