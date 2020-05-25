import java.util.Scanner;

public class p2441 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int num = in.nextInt();
		for(int i = 0; i < num; i++)
		{
			for(int j = num - i; j < num; j++)
				System.out.print(" ");
			for(int j = 0; j < num-i;j++)
				System.out.print("*");
			System.out.println();
		}
	}

}
