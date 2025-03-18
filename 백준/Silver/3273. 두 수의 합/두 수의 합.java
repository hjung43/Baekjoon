import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        int[] mNums = new int[x+1];
        
        for(int i=0; i<n; i++){
            if(nums[i]<=x){
                if(mNums[x-nums[i]]==1){
                    answer++;
                }
                mNums[nums[i]]=1;
            }
            
        }
        System.out.println(answer);
    }
}