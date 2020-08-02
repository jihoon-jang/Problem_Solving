import java.util.Scanner;

public class p1550 {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();

			long i = 0;
		while(true)
		{
			String n = Long.toHexString(i++);
			if(n.toUpperCase().equals(s))
				break;
		}
		System.out.println(--i);
	}
}
