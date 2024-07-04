import java.io.*;
import java.util.*;
import java.lang.*;


public class Main {
	public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int h = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	int n = Integer.parseInt(st.nextToken());
        	
        	int ansH = n%h;
        
        	int ansW = n/h+1;
        	if(ansH==0) {
        		ansH=h;
        		ansW=n/h;
        	}
        	
        	StringBuilder sb = new StringBuilder();
        	sb.append(ansH);
        	if(ansW<10) {
        		sb.append(0).append(ansW);
        	}else {
        		sb.append(ansW);
        	}
        	
        	System.out.println(sb);
        	
        	
        }
        
        
        
    }

}