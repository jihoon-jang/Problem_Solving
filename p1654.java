import java.util.Scanner;

public class p1654 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); 
		int k = in.nextInt();
		long array[] = new long[n];
		long max = 0;

		for(int i = 0; i < n; i++) {
			array[i] = in.nextLong();
			max = Math.max(array[i], max);
		}	

		long left = 1;
		long right = max;

		while(left <= right) {
			long count = 0;
			long mid = (right + left)/2;
			
			for(int i = 0; i < n; i++) {
				count += (long)(array[i]/mid); 
			}

			if(count >= k) 
				left = mid + 1;
			else 
				right = mid - 1;
		}

		System.out.println(right);
	}

}
