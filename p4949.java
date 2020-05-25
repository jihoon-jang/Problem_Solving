import java.util.Scanner;
import java.util.Stack;

public class p4949 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		while(in.hasNextLine())
		{
			String s = in.nextLine();
			if(s.equals("."))
				break;
			String[] arr = s.split("");
			Stack<String> st = new Stack<>();
			int count = 0;
			for(int i = 0; i < arr.length; i++)
			{
				if(arr[i].equals("(")||arr[i].equals("["))
				{
					st.push(arr[i]);
					count = 0;
				}
				else if(arr[i].equals(")"))
				{
					if(!st.isEmpty()&& st.pop().equals("("))	{}
					else
					{
						System.out.println("no");
						break;
					}
				}
				else if(arr[i].equals("]"))
				{
					if(!st.isEmpty()&& st.pop().equals("["))
						{}
					else
					{
						System.out.println("no");
						break;
					}
				}
				else if(arr[i].equals("."))
				{
					if(st.isEmpty())
						System.out.println("yes");
					else
						System.out.println("no");
				}


			}
		}
	}

}
