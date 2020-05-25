import java.util.Scanner;

public class p5533 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int loop = in.nextInt();
		int[][] array = new int[loop][3];

		for(int i = 0; i < loop; i++)
		{
			for(int j = 0; j < 3; j ++)
			{
				array[i][j] = in.nextInt();
			}
		}

		for(int j = 0; j < 3; j ++)
		{
			for(int i = 0; i < loop; i++)
			{	
				int number = 0;
				if(array[i][j] != 0)
					number = array[i][j];
				if(number != 0)
					for(int k = i+1; k < loop; k++)
					{
						if(array[k][j] == number)
						{
							array[k][j] = 0;
							array[i][j] = 0;
						}
					}
			}
			
		}
		
		for(int i = 0; i < loop; i++)
		{
			int score = 0;
			for(int j = 0; j < 3; j ++)
			{
				score += array[i][j];
			}
			System.out.println(score);
		}
	}

}
