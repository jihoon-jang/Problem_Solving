import java.util.Scanner;

public class p12790 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for(int t = 1; t <= tc; t++) {
			int hp = in.nextInt();
			int mp = in.nextInt();
			int attack = in.nextInt();
			int shield = in.nextInt();
			hp += in.nextInt();
			if(hp < 1)
				hp = 1;
			mp += in.nextInt();
			if(mp < 1)
				mp = 1;
			attack += in.nextInt();
			if(attack < 0)
				attack = 0;
			shield += in.nextInt();

			System.out.println(hp+5*mp+2*attack+2*shield);
		}
	}

}
