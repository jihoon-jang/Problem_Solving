import java.util.*;

public class p15970 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = Integer.parseInt(in.nextLine());
		int maxColor = 0;
		int answer = 0;
		point array[] = new point[size];
		for(int i = 0; i < size; i++ ) {
			array[i] = new point(in.nextInt(), in.nextInt());
			if(array[i].color > maxColor)
				maxColor = array[i].color;
		}

		for(int c = 1; c <= maxColor; c++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			for(int i = 0; i < size; i++) {
				if(array[i].color == c) 
					al.add(array[i].coor);
			}
			Collections.sort(al);
			for(int i = 0; i < al.size(); i++) {
				int prev = 0, next = 0;
				if(i == 0)
					answer += al.get(1) - al.get(0);
				else if(i == al.size() - 1)
					answer += al.get(i) - al.get(i-1);
				else {
					prev = al.get(i) - al.get(i-1);
					next = al.get(i+1) - al.get(i);
					if(prev > next)
						answer += next;
					else
						answer += prev;
				}
			}
		}
		System.out.println(answer);
	}
}

class point {
	int coor;
	int color;
	point(){}
	point(int coor, int color) {
		this.coor = coor;
		this.color = color;
	}
}