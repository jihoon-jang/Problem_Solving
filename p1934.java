import java.util.Scanner;

public class p1934 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		
		for(int t = 0; t < tc; t++) {
			int a = in.nextInt();
			int b = in.nextInt();
			
			if(b < a) {
				int temp = a;
				a = b;
				b = temp;
			}
			int g = 1;
			
			for(int i = a; i > 1; i--) {
				if(a % i == 0 && b % i == 0) {
					g = i;
					break;
				}
			}
			
			System.out.println(b * (a/g));
			
		}

	}

}
