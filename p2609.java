import java.util.Scanner;

public class p2609 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		
		if(n1 > n2) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}

		int gcb=1;
		for(int i = n1; i > 1; i--) {
			if(n1 % i == 0 && n2 % i == 0) {
				gcb = i;
				break;
			}
		}
		int lsb=1;
		lsb = n1/gcb*n2;
		System.out.println(gcb + " \n"+ lsb);
	}

}
