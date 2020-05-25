import java.util.Scanner;

public class p5063 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			int r = in.nextInt();
			int e = in.nextInt();
			int c = in.nextInt();
			if(e > r+c)
				System.out.println("advertise");
			else if(e == r+c)
				System.out.println("does not matter");
			else
				System.out.println("do not advertise");
		}

	}

}
