import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2493 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop = Integer.parseInt(br.readLine());
		int[] tower = new int [loop+1];
		int index = 0;
		int max = 0;
		StringTokenizer str = new StringTokenizer(br.readLine()," ");

		for(int i = 1; i < tower.length; i++)
		{
			tower[i] = Integer.parseInt(str.nextToken());
			if(tower[i] > max)
			{
				max = tower[i];
				index = i;
				bw.write(0+ " ");
			}
			else
			{
				for(int j = i; j > 0; j--)
				{
					if(tower[j] > tower[i])
					{
						bw.write(j+ " ");
						break;
					}
				}
			}
		}
		bw.flush();
	}

}
