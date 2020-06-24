import java.util.*;

public class p1546 {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int loop = in.nextInt();
		double array[] = new double[loop];
		double max = 0;
		
		for(int i = 0; i < loop; i++) {
			array[i] = in.nextInt();
			max = Math.max(max, array[i]);
		}

		double sum = 0;
		for(int i = 0; i < loop; i++) {
			array[i] /= max;
			sum += array[i];
		}
		System.out.println(sum/loop*100);
	}

}
