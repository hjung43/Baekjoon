import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[10];
        String room = br.readLine();
        int answer=0;
        //int room = Integer.parseInt(br.readLine());
        for(int i=0; i<room.length(); i++){
            int num = room.charAt(i)-'0';
            nums[num]++;
        }
        int sn = nums[6]+nums[9];
        nums[6] = sn/2;
        nums[9] = 0;
        if(sn%2==1){
            nums[6]=sn/2+1;
        }
        for(int i=0; i<10; i++){
            answer = Math.max(answer, nums[i]);
        }
        System.out.println(answer);
    }
}