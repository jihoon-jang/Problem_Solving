import java.util.Scanner;

public class p1924 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int month = in.nextInt();
		int day = in.nextInt();
		int[] what = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		int num = 0;
		for(int i = 0; i < month; i++)
			num+=what[i];
		num += day;
		
		switch(num%7) 
		{
		case 1: System.out.println("MON");
		break;
		case 2: System.out.println("TUE");
		break;
		case 3: System.out.println("WED");
		break;
		case 4: System.out.println("THU");
		break;
		case 5: System.out.println("FRI");
		break;
		case 6: System.out.println("SAT");
		break;
		default:
			System.out.println("SUN");
		}
	}

}
