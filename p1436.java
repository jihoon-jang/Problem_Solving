import java.util.Scanner;

public class p1436 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; ; i++) {
			if(String.valueOf(i).contains("666"))
				n--;
			if(n == 0) {
				System.out.println(i);
				return;
			}
		}

	}

}
