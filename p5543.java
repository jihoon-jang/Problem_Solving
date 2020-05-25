import java.util.Scanner;

public class p5543 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int h = 2000;
		for(int i = 0; i < 3; i++){
			int price = in.nextInt();
			h = Integer.min(h, price);
		}
		int d = 2000;
		for(int i = 0; i < 2; i++){
			int price = in.nextInt();
			d = Integer.min(d, price);
		}
		System.out.println(h+d-50);
	}

}
