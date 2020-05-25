import java.util.Scanner;

public class p2438 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int number = in.nextInt();
		for(int i = 1; i < number +1; i++)
		{
			for(int j = number; j> i; j--)
				System.out.print(" ");
			for(int j = 0; j < i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
