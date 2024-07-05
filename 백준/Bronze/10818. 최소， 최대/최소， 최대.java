import java.io.*;
import java.util.*;
import java.lang.*;


public class Main {
	public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -1000000;
        int min = 1000000;
        for(int i = 0; i<n; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	max = Math.max(max, num);
        	min = Math.min(min, num);
        }
        System.out.println(min+" "+max);
    }
}