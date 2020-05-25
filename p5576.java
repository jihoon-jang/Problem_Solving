import java.util.Arrays;
import java.util.Scanner;

public class p5576 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int array1[] = new int[10];
		int array2[] = new int[10];
		for(int i = 0; i < 10; i++)
			array1[i] = in.nextInt();
		for(int i = 0; i < 10; i++)
			array2[i] = in.nextInt();
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		System.out.println(array1[9]+array1[8]+array1[7]+" "+(array2[9]+array2[8]+array2[7]));
	}

}
