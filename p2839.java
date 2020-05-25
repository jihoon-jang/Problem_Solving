import java.util.Scanner;

public class p2839 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int count = n/5;
		int five = 5*count;

		for(; count > 0; count--)
		{
			five = 5 * count;
			if((n-five) % 3 == 0)
				break;
		}
		five = 5 * count;
		if((n-five) % 3 != 0)
			System.out.println("-1");
		else
			System.out.println(count + (n-five)/3);
	}

}
