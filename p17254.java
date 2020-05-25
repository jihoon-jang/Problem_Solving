import java.util.Arrays;
import java.util.Scanner;

public class p17254 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int number = in.nextInt();
		int cnt = in.nextInt(); in.nextLine();
		char[][] arr = new char[cnt][number];

		for(int i = 0; i < cnt; i++)
		{
			String s = in.nextLine();
			char[] c = s.toCharArray();
			int index = 0;
			for(int j = 0; j < c.length; j++)
			{	
				if(c[j] != ' ')
					arr[i][index++] = c[j];
			}
		}	
		sort(arr);
	}

	public static void sort(char[][] arr)
	{
		int[][] n = new int[arr.length][2];
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j <arr[0].length; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		for(int i = 0; i < n.length; i++)
		{
			n[i][0] = arr[i][1]-48;
		}
	}

}
