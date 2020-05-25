import java.util.*;

public class p14697 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int room1 = in.nextInt();
		int room2 = in.nextInt();
		int room3 = in.nextInt();
		int number = in.nextInt();
		int n = number;
		for(int i = number/room3; i >= 0; i--) {
			n = number-(i*room3);
			if(n == 0) {
				System.out.println(1);
				return;
			}
			for(int j = n/room2; j >= 0; j--) {
				n -= j*room2;
				if(n == 0) {
					System.out.println(1);
					return;
				}
				for(int k = n/room1; k >= 0; k--) {
					n-= k*room1;
					if(n == 0) {
						System.out.println(1);
						return;
					}
				}
			}
		}
		System.out.println(0);
	}

}
