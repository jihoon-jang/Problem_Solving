import java.util.Arrays;
import java.util.Scanner;

public class p1920 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for(int i = 0; i < n; i++)
			a[i] = in.nextInt();
		int m = in.nextInt();
		int b[] = new int[m];
		for(int i = 0; i < m; i++)
			b[i] = in.nextInt();
		
		Arrays.sort(a);
		
		for(int i = 0; i < m; i++) {
			System.out.println(Arrays.binarySearch(a, b[i]) >= 0 ? 1 : 0);
		}

	}

}
