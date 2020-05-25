import java.util.Arrays;
import java.util.Scanner;

public class p4153 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
		
		while(a != 0) {
			int array[] = {a, b, c};
			Arrays.sort(array);
			if(Math.pow(array[2], 2) == Math.pow(array[0], 2) + Math.pow(array[1], 2))
				System.out.println("right");
			else
				System.out.println("wrong");
			a = in.nextInt();
			b = in.nextInt();
			c = in.nextInt();
		}
	}

}
