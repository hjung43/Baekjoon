import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=0; i<k; i++){
            int n = Integer.parseInt(br.readLine());
            if(n!=0){
                stack.add(n);
            }else{
                stack.pop();
            }
        }
        while(!stack.empty()){
            ans += stack.pop();
        }
        System.out.println(ans);
        
    }
}