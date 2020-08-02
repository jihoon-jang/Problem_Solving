import java.util.Scanner;

public class p1912 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int array[] = new int[n];
		for(int i = 0; i < n; i++)
			array[i] = in.nextInt();
		long cal[] = new long[n];
		int index = 0;

		long sum = 0;
		for(int i = 0; i < n; i++) {
			if(array[i] <= 0) {
				if(sum == 0)
					cal[index++] = array[i];
				else {
					cal[index++] = sum;
					cal[index++] = array[i];
					sum = 0;
				}
			}
			else {
				sum += array[i];
			}
		}
		if(sum != 0)
			cal[index++] = sum;

		long max = Long.MIN_VALUE;
		long temp = -100000;

		for(int i = 0; i < index; i++) {
			if(temp + cal[i] < cal[i])
				temp = cal[i];
			else 
				temp += cal[i];
			max = Math.max(max, temp);
		}
		
		System.out.println(max);
	}

}
