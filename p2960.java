import java.util.Scanner;

public class p2960 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); int k = in.nextInt();
		int array[] = new int[n+1];

		for(int i = 2; i <= n; i++) {
			for(int j = 1; j*i <= n; j++) {
				if(array[j*i] == 0 && j*i % i == 0) {
					k--;
					if(k == 0) {
						System.out.println(j*i);
						return;
					}
					array[j*i] = 1;
				}
			}

		}
	}

}
