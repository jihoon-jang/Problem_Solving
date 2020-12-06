import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p1076 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();
        ArrayList<String> colors = new ArrayList<>(10);
        colors.add("black");
        colors.add("brown");
        colors.add("red");
        colors.add("orange");
        colors.add("yellow");
        colors.add("green");
        colors.add("blue");
        colors.add("violet");
        colors.add("grey");
        colors.add("white");
        StringBuilder sb = new StringBuilder();
        
        sb.append(colors.indexOf(color1));
        sb.append(colors.indexOf(color2));
        for(int i = 1; i < (int)Math.pow(10, colors.indexOf(color3)); i *= 10)
            sb.append(0);
        System.out.println(Long.parseLong(sb.toString()));
    }
}
