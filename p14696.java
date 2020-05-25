import java.util.*;

public class p14696 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int loop = in.nextInt();

		for(int l = 0; l < loop; l++) {
			int a[][] = new int[2][5];

			for(int k = 0; k < 2; k++) {
				int size = in.nextInt();

				for(int i = 0; i < size; i++)
					a[k][in.nextInt()] ++;
			}
			if(Arrays.equals(a[0], a[1]))
				System.out.println('D');
			else {
				for(int i = 4; i >= 1; i--) {
					if(a[0][i] > a[1][i]) {
						System.out.println('A');
						break;
					}
					else if(a[0][i] < a[1][i]) {
						System.out.println('B');
						break;
					}
				}
			}
		}
	}

}
