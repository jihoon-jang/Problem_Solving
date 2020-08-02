import java.util.Scanner;

public class p1978 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count = 0;
		int array[] = new int[10001];
		int max = 0;

		for(int i = 0; i < n; i++) {
			int num = in.nextInt();
			array[num]++;
			max = Math.max(max, num);
		}

		for(int i = 2; i <= max; i++) {
			if(array[i] != 0) {
				count += array[i];
				array[i] = 0;
			}

			for(int j = i+1; j <= max; j++) {
				if(array[j] != 0 && j % i == 0)
					array[j] = 0;
			}


		}

		System.out.println(count);
	}

}
