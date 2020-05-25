import java.util.Scanner;

public class p11721 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int index = Integer.parseInt(in.nextLine());
		String[] array = new String[index];
		String line = in.nextLine();
		array = line.split("");
		int number = 0;

		for(int i = 0; i < index; i++)
			number += Integer.parseInt(array[i]);

		System.out.println(number);
	}

}
