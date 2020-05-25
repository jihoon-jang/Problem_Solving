import java.util.Scanner;

public class p2748 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long arr[] = new long[n+1];
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			arr[i] = arr[i-2] + arr[i-1];
		}
		System.out.println(arr[n]);
	}

}
