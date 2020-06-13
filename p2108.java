import java.util.Arrays;
import java.util.Scanner;

public class p2108 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int array[] = new int[n];
		int sum = 0;
		int max = -4000;
		int min = 4000;
		int number[] = new int[8001];
		
		for(int i = 0; i < n; i++) {
			array[i] = in.nextInt();
			sum += array[i];
			max = Math.max(max, array[i]);
			min = Math.min(min, array[i]);
			number[array[i]+4000]++;
		}
		System.out.println(Math.round(Math.floor(((double)sum/(double)n)*10)/10));
		Arrays.sort(array);
		if(n % 2 == 0) 
			System.out.println((array[n/2]+array[n/2-1])/2);
		else
			System.out.println(array[n/2]);
		
		int index = 0;
		int val = 0;
		boolean first = false;
		
		for(int i = 0; i < number.length; i++) {
			if(val < number[i]) {
				index = i;
				val = number[i];
				first = true;
			}
			else if(val == number[i] && first) {
				first = false;
				index = i;
			}
		}
		System.out.println(index-4000);
		System.out.println(max - min);

	}

}
