import java.util.Scanner;

public class p1011 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for(int t = 1; t <= tc; t++) {
			long x = in.nextLong();
			long y = in.nextLong();
			int speed = 1;
			
			for(int i = 1; ; i++) {
				 x += (long)speed;
				 y -= (long)speed++;
				
				 if(x > y) {
					 x -= (long)speed;
					 y += (long)speed;
					 speed --;
					 i--;
					 System.out.println(x+" "+y + " " + speed);
					 break;
				 }
			}
			
		}

	}


}
