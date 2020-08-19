import java.util.*;

public class pm뉴스클러스터링 {
	    public int solution(String str1, String str2) {
	        str1 = str1.toLowerCase();
	        str2 = str2.toLowerCase();
	        ArrayList<String> al1 = new ArrayList<String>();
	        ArrayList<String> al2 = new ArrayList<String>();
	        
	        for(int i = 0; i < str1.length(); i++) {
	            if(i < str1.length()-1){
	                String part = str1.substring(i, i+2);
	                char c1 = part.charAt(0);
	                char c2 = part.charAt(1);
	                if(('a' <= c1 && 'z' >= c1) && ('a' <= c2 && 'z' >= c2)) 
	                    al1.add(part);
	            }
	        }
	        
	        for(int i = 0; i < str2.length(); i++) {
	           if(i < str2.length()-1){
	                String part = str2.substring(i, i+2);
	                char c1 = part.charAt(0);
	                char c2 = part.charAt(1);
	                if(('a' <= c1 && 'z' >= c1) && ('a' <= c2 && 'z' >= c2))
	                    al2.add(part);
	           }
	        }
	        
	        double count = 0;
	        double total = al1.size()+al2.size();
	        for(int i = 0; i < al1.size(); i++) {
	            if(al2.contains(al1.get(i))){
	                count++;
	                al2.remove(al2.indexOf(al1.get(i)));
	            }
	        }
	        
	        if(total-count == 0)
	            return 65536;
	        else
	            return  (int)(count/(total-count)*65536);
	    }
	}