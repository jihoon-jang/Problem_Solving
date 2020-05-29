import java.util.Scanner;

public class p2163 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		if(m < n) {
			int temp = n;
			n = m;
			m = temp;
		}
		
		System.out.println((m-1)*n+(n-1));
	}

}
