import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while(!(str = br.readLine()).equals("0 0 0")){
            StringTokenizer st = new StringTokenizer(str);
            List<Integer>nums = new ArrayList<>();
            for(int i=0; i<3; i++){
                nums.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(nums);
            if(Math.pow(nums.get(0),2)+Math.pow(nums.get(1),2)==Math.pow(nums.get(2),2)){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        }
    }
}