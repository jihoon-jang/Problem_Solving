import java.util.Scanner;

public class p2440 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int num = in.nextInt();
		for(int i = num; i >= 1; i--)
		{
			for(int j = num - i; j < num; j++)
				System.out.print("*");
			System.out.println();
		}
	}

}
