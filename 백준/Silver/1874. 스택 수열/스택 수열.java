import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer>stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int num = 1;
        for(int i = 0; i <n; i++) {
            int f = Integer.parseInt(br.readLine());
            while(num<=n && num<=f){
                stack.push(num++);
                sb.append("+").append("\n");
            }
            if(!stack.empty()){
                if(f==stack.peek()){
                    stack.pop();
                    sb.append("-").append("\n");
                }else{
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb);
    }
}