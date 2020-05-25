import java.util.*;
public class p13458 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int room[] = new int[n];
		long answer = 0;
		for(int i = 0; i < n; i++)
			room[i] = in.nextInt();
		
		int b = in.nextInt();
		int c = in.nextInt();
		
		for(int i = 0; i < n; i++) {
			answer ++;
			room[i] -= b;
			if(room[i] > 0) {
				answer += (long)(room[i]/c);
				if(room[i]%c !=0)
					answer++;
			}
		}
		
		System.out.println(answer);
	}

}
