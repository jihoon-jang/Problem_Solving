import java.util.Scanner;

public class p10996 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i = 0; i < n; i++) {
			for(int j = 1; j <= n; j++) {
				if(j % 2 == 1)
					System.out.print('*');
				else
					System.out.print(' ');
			}
			System.out.println();
			for(int j = 1; j <= n; j++) {
				if(j % 2 == 0)
					System.out.print('*');
				else
					System.out.print(' ');
			}
			System.out.println();
		}
	}

}
