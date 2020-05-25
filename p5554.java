import java.util.Scanner;

public class p5554 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sum = 0;
		for(int i = 0; i < 4; i++)
			sum += in.nextInt();
		System.out.println(sum/60 +"\n"+sum%60);
		
	}

}
