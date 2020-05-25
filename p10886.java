import java.util.Scanner;

public class p10886 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = 0;
		for(int i = 0; i < n; i++) {
			int t = in.nextInt();
			if(t == 1) 
				c ++;
			else
				c --;
		}
		if(c > 0)
			System.out.println("Junhee is cute!");
		else
			System.out.println("Junhee is not cute!");

	}

}
