import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution{

    public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int T = Integer.parseInt(br.readLine());
          for(int t=1; t<=T; t++) {
        	  StringTokenizer st = new StringTokenizer(br.readLine());
        	  int n = Integer.parseInt(st.nextToken());
        	  int m = n/4;
        	  int k = Integer.parseInt(st.nextToken());
        	  String num = br.readLine();
        	  
        	  List<Integer>list = new ArrayList<>();
        	  
        	  for(int i=0; i<m; i++) {
        		  for(int j=i; j<i+n; j=j+m) {
        			  String str = "";
        			  for(int l=j; l<j+m; l++) {
        				  str += num.charAt(l%n);
        			  }
        			  int pass = Integer.parseInt(str,16);
        			  if(!list.contains(pass)) {
        				  list.add(Integer.parseInt(str,16));
        			  }
        		  }
        	  }
        	  Collections.sort(list, Collections.reverseOrder());
        	  System.out.println("#"+t+" "+list.get(k-1));
          }
    }

}