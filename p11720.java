import java.util.Scanner;

public class p11720 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String line = in.nextLine();
		String s = "";
		String[] arr = line.split("");
		for(int i = 0; i < arr.length; i++)
		{
			if(s.length() == 9 || i == arr.length -1)
			{
				s+= arr[i];
				System.out.println(s);
				s = "";
			}
			else
				s+= arr[i];
		}
		in.close();
	}

}
