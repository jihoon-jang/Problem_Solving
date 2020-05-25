import java.util.Scanner;

public class p8393 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int loop = in.nextInt();
		int num = 0;
		for(int i = 0 ; i<= loop;i++)
			num += i;
		System.out.println(num);
	}

}
