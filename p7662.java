import java.io.*;
import java.util.*;

public class p7662 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> map;

		for(int t = 0; t < tc; t++) {
			int k = Integer.parseInt(br.readLine());
			map = new TreeMap<>();

			for(int i = 0; i < k; i++) {
				String s[] = br.readLine().split(" ");
				switch(s[0]) {
				case "I" :
					int ke = Integer.parseInt(s[1]);
					if(map.containsKey(ke))
						map.put(ke, map.get(ke)+1);
					else
						map.put(ke, 1);
					break;
				case "D" :
					if(!map.isEmpty())
						switch(s[1]) {
						case "-1" :
							int max = map.firstKey();
							int val = map.get(max);
							if(val == 1)
								map.remove(max);
							else
								map.put(max, map.get(max)-1);
							break;
						case "1" :
							int min = map.lastKey();
							int value = map.get(min);
							if(value == 1)
								map.remove(min);
							else
								map.put(min, map.get(min)-1);
							break;
						}
					break;

				}
			}

			if(map.size() == 0)
				System.out.println("EMPTY");
			else
				System.out.println(map.lastKey() + " "+ map.firstKey());
		}
	}

}
