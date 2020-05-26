import java.util.Arrays;
import java.util.Scanner;

public class p2309 {
	static int sum = -100;
	static int array[];
	static boolean visit[], flag = false;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		array = new int[9];
		visit = new boolean[9];
		
		for(int i = 0; i < 9; i++) {
			array[i] = in.nextInt();
			sum += array[i];
		}

		find(0, 0, 0);
	}
	
	public static void find(int count, int s, int start) {
		if(flag)
			return;
		if(s > sum)
			return;
		if(count == 2) {
			if(sum == s) {
				int answer[] = new int[7];
				int index = 0;
				for(int i = 0; i < 9; i++)
					if(!visit[i])
						answer[index++] = array[i];
				Arrays.sort(answer);
				for(int i : answer)
					System.out.println(i);
				flag = true;
				return;
			}
		}
		else {
			for(int i = start; i < 9; i++) {
				if(!visit[i]) {
					visit[i] = true;
					find(count + 1, s + array[i], i);
					visit[i] = false;
				}
			}
		}
	}

}
