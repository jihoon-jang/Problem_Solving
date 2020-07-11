import java.util.*;

public class p11651 {

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
			public int compare(int[] arg0, int[] arg1) {
				if(arg0[1] == arg1[1])
					return arg0[0] - arg1[0];
				return arg0[1] - arg1[1];
			}
			
		});
		
		for(int i = 0; i < n; i++) {
			System.out.println(array[i][0] + " "+ array[i][1]);
		}

	}

}
