import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++){
            num[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            int key = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = n-1;
            boolean exist = false;
            while(start <= end){
                int mid = (start+end)/2;
                if(num[mid]==key){
                    System.out.println(1);
                    exist = true;
                    break;
                }else if(num[mid]>key){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
            if(!exist){
                System.out.println(0);
            }
        }
        
    }
}