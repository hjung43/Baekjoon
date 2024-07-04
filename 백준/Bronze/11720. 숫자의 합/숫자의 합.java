import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String nums = br.readLine();
        int sum= 0;
        for(int i=0; i<n; i++){
            int a = nums.charAt(i)-'0';
            sum = sum + a;
        }
       System.out.println(sum);
    }
}