import java.io.*;
import java.util.*;
import java.lang.*;


public class Main {
	public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        if(m<45) {
        	m = 60 - (45 -m);
        	if(h==0) {
        		h=23;
        	}else{
        		h--;
        	}
        }else {
        	m = m-45;
        }
        System.out.println(h+" "+m);
    }

}