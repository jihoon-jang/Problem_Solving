import java.util.Scanner;

public class p2739 {

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		
		for(int i = 1; i <= 9 ; i++)
		{
			System.out.println(number + " * " + i + " = " + (number*i));
		}
	}
}
