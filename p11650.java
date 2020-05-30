import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class p11650 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int array[][] = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			array[i][0] = in.nextInt();
			array[i][1] = in.nextInt();
		}
		
		Arrays.sort(array, new Comparator<int[]>() {

			@Override
			public int compare(int[] x, int[] y) {
				if(x[0] == y[0])
					return Integer.compare(x[1], y[1]);
				
				return Integer.compare(x[0], y[0]);
			}
			
		});
		
		for(int i = 0; i < n; i++) {
			System.out.println(array[i][0] +" " + array[i][1]);
		}
	}

}
