import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //참가자수
        int[] tShirt = new int[6]; //티셔츠 사이즈별 사람수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<6; i++){
            tShirt[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken()); //티셔츠 한 묶음 수
        int p = Integer.parseInt(st.nextToken()); //펜 한 묶음 수
        
        
        int bundleP = n/p;
        int eachP = n%p;
        int bundleT = 0;
        for(int i=0; i<6; i++){
            bundleT +=(tShirt[i]/t);
            if(tShirt[i]%t>0){
                bundleT++;
            }
        }
        
        System.out.println(bundleT);
        System.out.println(bundleP + " " + eachP);
     
    }
}