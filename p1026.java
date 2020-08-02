import java.util.Arrays;
import java.util.Scanner;

public class p1026 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < n; j++)
				if(i == 0)
					a[j] = in.nextInt();
				else
					b[j] = in.nextInt();
		}
		
		Arrays.sort(b);
		Arrays.sort(a);
		int answer = 0;
		for(int i = 0; i < n; i++) {
			answer += b[i] * a[n-1-i];
			
		}
		
		System.out.println(answer);
	}

}
