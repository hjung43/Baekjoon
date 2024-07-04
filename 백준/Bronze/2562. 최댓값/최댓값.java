import java.io.*;
import java.util.*;
import java.lang.*;


public class Main {
	public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxIdx = -1;
        int max = 0;
        for(int i=0; i<9; i++) {
        	int n = Integer.parseInt(br.readLine());
        	if(max<n) {
        		max = n;
        		maxIdx = i+1;
        	}
        }
        System.out.println(max);
        System.out.println(maxIdx);
    }

}