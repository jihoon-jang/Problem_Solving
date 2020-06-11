import java.util.Scanner;

public class p9661 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		
		if(n % 5 == 0 || n % 5 == 2)
			System.out.println("CY");
		else
			System.out.println("SK");
	}

}
