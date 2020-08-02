import java.util.Scanner;

public class p1929 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int array[] = new int[1000001];
		array[1] = 1;
		
		for(int i = 2; i <= 1000000; i++) {
			for(int j = 2; i*j <= 1000000; j++)
				array[i*j] = 1;
		}
		
		for(int i = m; i <= n; i++)
			if(array[i] == 0)
				System.out.println(i);
	}

}
