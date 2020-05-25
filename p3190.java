import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p3190 {
	static int size;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		size = in.nextInt();
		int map[][] = new int[size+1][size+1];
		int apple = in.nextInt();
		Queue xq = new LinkedList();
		Queue yq = new LinkedList();
		xq.add(1);
		yq.add(1);
		for(int i =0 ; i < apple; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			map[x][y] = 1;
		}
		String dir = "right";
		int co = in.nextInt();
		String sa[] = new String[10000];
		for(int i = 0; i <co; i++) {
			sa[in.nextInt()] = in.next();
		}
		int t = 1;
		int x=1, y=1;
		map[x][y] =2 ;
lab:		for(;;t++) {
			switch(dir)  {
			case "right": 
				y++;
				if(!check(x,y) || map[x][y] == 2)
					break lab;
				xq.add(x);
				yq.add(y);
				if(map[x][y] != 1) {
					map[x][y] = 2;
					map[(int)xq.poll()][(int)yq.poll()] = 0;
				}
				else {
					map[x][y] = 2;
				}
				if(sa[t] != null && sa[t].equals("D"))
					dir = "down";
				else if(sa[t] != null &&sa[t].equals("L"))
					dir = "up";
				break;
			case "left": 
				y--;
				if(!check(x,y) || map[x][y] == 2)
					break lab;
				xq.add(x);
				yq.add(y);
				if(map[x][y] != 1) {
					map[x][y] = 2;
					map[(int)xq.poll()][(int)yq.poll()] = 0;
				}
				else {
					map[x][y] = 2;
				}
				if(sa[t] != null &&sa[t].equals("D"))
					dir = "up";
				else if(sa[t] != null &&sa[t].equals("L"))
					dir = "down";
				break;
			case "up": 
				x--;
				if(!check(x,y)|| map[x][y] == 2)
					break lab;
				xq.add(x);
				yq.add(y);
				if(map[x][y] != 1) {
					map[x][y] = 2;
					map[(int)xq.poll()][(int)yq.poll()] = 0;
				}
				else {
					map[x][y] = 2;
				}
				if(sa[t] != null &&sa[t].equals("D"))
					dir = "right";
				else if(sa[t] != null &&sa[t].equals("L"))
					dir = "left";
				break;
			case "down": 
				x++;
				if(!check(x,y)|| map[x][y] == 2)
					break lab;
				xq.add(x);
				yq.add(y);
				if(map[x][y] != 1) {
					map[x][y] = 2;
					map[(int)xq.poll()][(int)yq.poll()] = 0;
				}
				else {
					map[x][y] = 2;
				}
				if(sa[t] != null &&sa[t].equals("D"))
					dir = "left";
				else if(sa[t] != null && sa[t].equals("L"))
					dir = "right";
				break;
			}
			
		}
		System.out.println(t);
	}
	
	public static boolean check(int x, int y) { 
		return x >= 1 && x <= size && y >= 1 && y <= size;
	}

}
