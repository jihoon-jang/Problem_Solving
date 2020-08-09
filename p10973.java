import java.util.*;
import java.io.*;

public class p10973 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stz.nextToken());
		int array[] = new int[n];
		
			stz = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(stz.nextToken());
		}
		
		if(per(array)) 
			for(int i = 0; i < array.length; i++)
				System.out.print(array[i]+" ");
		else
			System.out.println(-1);
	}
	
	public static boolean per(int array[]) {
		int index = array.length-1;
	
		while(index > 0 && array[index] >= array[index-1]) 
			index--;

		if(index <= 0)
			return false;
		
		int jndex = array.length-1;
		
		while(array[index-1] <= array[jndex]) 
			jndex--;
		
		int temp = array[index-1];
		array[index-1] = array[jndex];
		array[jndex] = temp;
		
		int start = index;
		int end = array.length-1;
		
		while(start < end) {
			temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			end--;
			start++;
		}
		
		return true;
		
	}

}
