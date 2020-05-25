import java.util.Scanner;

public class p10539 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long sum[] = new long[n];
		long array[] = new long[n];
		for(int i = 0; i < n; i++)
			sum[i] = in.nextLong();
		
		for(int i = 0; i < n; i++)
			array[i] = sum[i]*(i+1);
		
		System.out.print(array[0]+" ");
		for(int i = 1; i < n; i++) {
			System.out.print(array[i] - array[i-1]+" ");
		}
	}

}
