import java.util.Scanner;

public class p5596 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int s = 0;
		for(int i = 0; i < 4; i++)
			s += in.nextInt();
		int t = 0;
		for(int i = 0; i < 4; i++)
			t += in.nextInt();
		if(s >= t)
			System.out.println(s);
		else
			System.out.println(t);
	}

}
