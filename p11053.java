import java.util.Arrays;
import java.util.Scanner;

public class p11053 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);	
		int n = in.nextInt();
		int array[] = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		
		int max = 0;
		
		for(int i = 0; i < 1; i++) {
			int num = array[i];
			int count = 1;
			for(int j = i + 1; j < n; j++) {
				if(num < array[j]) {
					count ++;
					num = array[j];
					System.out.println(num);
				}
			}
			max = Math.max(max, count);
		}
			
		System.out.println(max);
	}

}
