import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p19947 {
    
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int cost = Integer.parseInt(stz.nextToken());
        int year = Integer.parseInt(stz.nextToken());
        max = cost;
    
        if(year >= 1)
            y1(cost, year);
        if(year >= 3)
            y3(cost, year);
        if(year >= 5)
            y5(cost, year);
    
        System.out.println(max);
    }
    
    public static void y1(int money, int year) {
        money *= 1.05;
        max = Math.max(money, max);
        year--;
        
        if(year >= 1)
            y1(money, year);
        if(year >= 3)
            y3(money, year);
        if(year >= 5)
            y5(money, year);
    }
    
    public static void y3(int money, int year) {
        money *= 1.2;
        max = Math.max(money, max);
        year -= 3;
        
        if(year >= 1)
            y1(money, year);
        if(year >= 3)
            y3(money, year);
        if(year >= 5)
            y5(money, year);
    }
    
    public static void y5(int money, int year) {
        money *= 1.35;
        max = Math.max(money, max);
        year -= 5;
        
        if(year >= 1)
            y1(money, year);
        if(year >= 3)
            y3(money, year);
        if(year >= 5)
            y5(money, year);
    }
}
