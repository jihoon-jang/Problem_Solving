import java.util.Scanner;

public class p2805 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int array[] = new int[n];
		for(int i = 0; i < n; i++)
			array[i] = in.nextInt();

		long left = 0;
		long right = 2000000000;

		while(left <= right) {
			long mid = (left + right) / 2;
			long dif = 0;
			for(int i = 0; i < array.length; i++)
				if(array[i] > mid)
					dif += array[i] - mid;

			if(dif < m)
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(right);

	}

}
