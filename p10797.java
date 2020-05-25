import java.util.Scanner;

public class p10797 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count = 0;
		for(int i = 0; i < 5; i++) {
			int car = in.nextInt();
			if(car == n)
				count++;
		}
		System.out.println(count);

	}

}
