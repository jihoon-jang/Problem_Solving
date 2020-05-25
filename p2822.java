import java.util.Arrays;
import java.util.Scanner;

public class p2822 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int array[] = new int[9];
		for(int i = 1; i <= 8; i++) 
			array[i] = in.nextInt();
		int sum = 0;
		int index[] = new int[5];
		
		for(int i = 0; i < 5; i++) {
			int max = 0;
			for(int j = 1; j <= 8; j++) {
				if(max < array[j]) {
					max = array[j];
					index[i] = j;
				}
			}
			array[index[i]] = 0;
			sum += max;
		}
		Arrays.sort(index);
		System.out.println(sum);
		for(int i : index)
			System.out.print(i+" ");
	}

}
