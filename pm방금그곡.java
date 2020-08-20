import java.util.ArrayList;

public class pm¹æ±Ý±×°î {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
		public String solution(String m, String[] musicinfos) {
			ArrayList<title> al = new ArrayList<title>();
			l: for(int i = 0; i < musicinfos.length; i++) {
				String s[] = musicinfos[i].split(",");
				int time = time(s[0], s[1]);
				int tjme = time;

				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < tjme; j++) {
					char c = s[3].charAt(j%s[3].length());
					if(c == '#')
						tjme++;
					sb.append(c);
					if(j == tjme-1 && s[3].charAt((j+1)%s[3].length()) == '#')
						sb.append('#');
				}
				System.out.println(sb.toString());
				for(int j = 0; j <= sb.toString().length()-m.length(); j++){
					String temp = sb.toString().substring(j, j+ m.length());
					if(temp.charAt(0) == '#' || (j+m.length()+1 < sb.toString().length() && sb.toString().charAt(j+m.length()) == '#'))
						continue;
					if(temp.equals(m)) {
						al.add(new title(s[2], time));
						continue l;
					}
				}
			}
			int max = 0;
			int index = 0;

			for(int i = 0; i < al.size(); i++) {
				if(al.get(i).length > max){
					max = al.get(i).length;
					index = i;
				}
			}

			if(al.size() > 0)
				return al.get(index).s;
			else
				return "(None)";
		}

		public int time(String t1, String t2) {
			String s1[] = t1.split(":");
			String s2[] = t2.split(":");

			return (Integer.parseInt(s2[0])-Integer.parseInt(s1[0]))*60 + (Integer.parseInt(s2[1]) - Integer.parseInt(s1[1]));
		}

		class title{
			String s;
			int length;
			title(String s, int length){
				this.s = s;
				this.length = length;
			}
		}
	}
}