import java.io.*;
import java.util.*;
import java.lang.*;


public class Main {
	public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j=0; j<n-(i+1); j++) {
        		sb.append(" ");
        	}
        	for(int k=0; k<i+1; k++) {
        		sb.append("*");
        	}
        	System.out.println(sb);
        }
    }

}