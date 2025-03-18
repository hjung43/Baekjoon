import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer>stack = new Stack<>(); //수열 만들 스택
        StringBuilder sb = new StringBuilder(); //정답 담을 sb
        int n = Integer.parseInt(br.readLine()); //수열 크기
        int num = 1; //1씩 커지는 오름차순으로 스택에 넣을 수
        //수열 크기만큼 반복
        for(int i = 0; i <n; i++) {
            int find = Integer.parseInt(br.readLine()); //찾아야할 수(수열의 i번째 숫자)
            //찾아야할 수 보다 스택에 넣을 수(num)가 작거나 같다면 찾아야 할 수까지 오름차순으로 스택에 넣기
            while(num<=n && num<=find){
                stack.push(num++);
                sb.append("+").append("\n");
            }
                //마지막 스택의 수가 찾는수랑 같으면 pop
                if(find==stack.peek()){
                    stack.pop();
                    sb.append("-").append("\n");
                }else{ //다르면 수열만들기 종료
                    System.out.println("NO");
                    return;
                }
            
        }
        System.out.println(sb);
    }
}