import java.util.*;
import java.io.*;

public class p2206{
	static short n, m;
	static short[] dx = { -1, 1, 0, 0 };
	static short[] dy = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][][] visit;
	static Queue<Point> q = new LinkedList<Point>();

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Short.parseShort(s[0]);
		m = Short.parseShort(s[1]);
		map = new int[n + 1][m + 1];
		visit = new boolean[n+1][m+1][2];

		for (int i = 1; i <= n; i++)
		{
			String str = br.readLine();
			for (int j = 1; j <= m; j++)
				map[i][j] = str.charAt(j - 1) - '0';
		}
		bfs();
	}

	public static void bfs() {
		int answer = 0;
		q.add(new Point((short)1,(short)1, (short)1, 1));

		while (!q.isEmpty())
		{
			Point p = q.poll();

			if(p.x == n && p.y == m) {
				answer = p.distance;
				break;
			}

			for (short i = 0; i < 4; i++)
			{
				short nx = (short)(p.x + dx[i]);
				short ny = (short)(p.y + dy[i]);

				if (nx >= 1 && ny >= 1 && nx <= n && ny <= m)
				{
					if (map[nx][ny] == 0)
					{	
						if(!visit[nx][ny][p.chance]) {
							visit[nx][ny][p.chance] = true;
							q.add(new Point(nx, ny, p.chance, p.distance + 1));
						}
					}
					else if (map[nx][ny] == 1 && p.chance == 1 && !visit[nx][ny][0])
					{
						visit[nx][ny][0] = true;
						q.add(new Point(nx, ny, (short)0, p.distance + 1));
					}
				}
			}
		}

		System.out.println(answer == 0 ? -1 : answer);
	}
}

class Point
{
	public short x, y;
	public short chance;
	public int distance;
	public Point(short x, short y, short c, int d)
	{
		this.x = x;
		this.y = y;
		this.chance = c;
		this.distance = d;
	}
}