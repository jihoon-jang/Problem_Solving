import java.util.Scanner;

public class p3009 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int a1 = in.nextInt();
		int b1 = in.nextInt();
		int a2 = in.nextInt();
		int b2 = in.nextInt();
		int a3 = in.nextInt();
		int b3 = in.nextInt();

		if(a1 == a2)
			System.out.print(a3);
		else if(a2 == a3)
			System.out.print(a1);
		else
			System.out.print(a2);
		
		if(b1 == b2)
			System.out.println(" "+b3);
		else if(b2 == b3)
			System.out.println(" "+b1);
		else
			System.out.println(" "+b2);
//

	}

}
