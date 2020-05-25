import java.util.Scanner;

public class p14864 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int loop = in.nextInt();
		int array[] = new int[size+1];
		for(int i = 0; i <=size;i++)
			array[i]=i;
		for(int l = 0; l < loop; l++) {
			int s = in.nextInt();
			int m = in.nextInt();
			array[s] ++;
			array[m] --;
		}
		
		for(int i = 1; i < size; i++)
		{
			for(int j = i+1; j <= size; j++) {
				if(array[i] == array[j]){
					System.out.println(-1);
					return;
				}
			}
		}
		
		for(int i = 1; i<=size;i++)
			System.out.print(array[i] + " ");
	}

}
