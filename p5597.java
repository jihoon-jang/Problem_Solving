import java.util.Scanner;

public class p5597 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int array[] = new int[31];
		for(int i = 0; i < 28; i++) {
			array[in.nextInt()] = 1;
		}

		for(int i = 1; i <= 30; i++) {
			if(array[i] == 0)
				System.out.println(i);
		}

	}

}
