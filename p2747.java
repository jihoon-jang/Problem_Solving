import java.util.Scanner;

public class p2747 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int array[] = new int[46];
		array[0] = 0;
		array[1] = 1;
		
		for(int i = 2; i <= 45; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		System.out.println(array[n]);
	}

}
