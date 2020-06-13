import java.util.Scanner;

public class p10816 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int array[] = new int[20000001];

		for(int i = 0; i < n; i++) {
			int num = in.nextInt();
			array[num+10000000]++;
		}

		int m = in.nextInt();

		for(int i = 0; i < m; i++) {
			int num = in.nextInt();
			System.out.print(array[num+10000000]+" ");
		}

	}

}
