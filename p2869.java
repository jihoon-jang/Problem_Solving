import java.util.Scanner;

class p2869{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int v = in.nextInt();

		if(a >= v)
			System.out.println(1);
		else {
			int height = a - b;
			v -= a;
			System.out.println((int)Math.ceil((double)v/height)+1);
		}
		
	}

}

