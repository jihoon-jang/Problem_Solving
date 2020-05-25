import java.util.Scanner;

public class p2851 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			int n = in.nextInt();
			if(Math.abs(100 - sum) > Math.abs(100 - (sum + n))) {
				sum += n;
			}
			else if(Math.abs(100 - sum) < Math.abs(100 - (sum + n))) {
				System.out.println(sum);
				return;
			}
			else {
				System.out.println(sum + n);
				return;
			}
		}
		System.out.println(sum);
	}

}
