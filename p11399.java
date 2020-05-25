import java.util.Arrays;
import java.util.Scanner;

public class p11399 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int array[] = new int[n];
		for(int i = 0; i < n; i++)
			array[i] = in.nextInt();
		Arrays.sort(array);
		int time[] = new int[n];
		time[0] = array[0];
		for(int i = 1; i < n; i++)
			time[i] = time[i-1] + array[i];
		int answer = 0;
		for(int i = 0; i < n; i++)
			answer += time[i];
		System.out.println(answer);
	}

}
