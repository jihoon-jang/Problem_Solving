import java.util.Scanner;

public class p2581 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int min = in.nextInt();
		int max = in.nextInt();
		int count = 0;
		int array[] = new int[10001];
		int sum = 0;
		int minnum = Integer.MAX_VALUE;
		
		for(int i = min; i <= max ; i++) {
			array[i] = 1;
		}

		for(int i = 2; i <= max; i++) {
			if(array[i] != 0) {
				count += array[i];
				array[i] = 0;
				minnum = Integer.min(minnum, i);
				sum += i;
			}

			for(int j = i+1; j <= max; j++) {
				if(array[j] != 0 && j % i == 0)
					array[j] = 0;
			}


		}
		if(minnum == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(sum +"\n" +minnum);
	}

}
