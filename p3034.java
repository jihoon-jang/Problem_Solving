import java.util.Scanner;

public class p3034 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int w = in.nextInt();
		int h = in.nextInt();
		int m = (int) Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2)); 

		for(int i = 0; i < n; i++) {
			int number = in.nextInt();
			if(number <= m )
				System.out.println("DA");
			else
				System.out.println("NE");
		}
	}

}
