import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class p10814 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String array[][] = new String[n][2];
		for(int i = 0; i < n; i++) {
			array[i][0] = in.next();
			array[i][1] = in.next();
		}
			
		Arrays.sort(array, new Comparator<String []>() {

			@Override
			public int compare(String x[], String y[]) {
				
				return Integer.compare(Integer.parseInt(x[0]), Integer.parseInt(y[0]));
			}
			
		});
		
		for(int i = 0; i < n; i++) {
			System.out.println(array[i][0] +" "+array[i][1]);
		}

	}

}
