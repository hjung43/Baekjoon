import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine()); //a값 입력
        int B = Integer.parseInt(br.readLine()); //b값 입력
        int C = Integer.parseInt(br.readLine()); //c값 입력

        int ans = A*B*C; //abc 곱한값
        String multiply = Integer.toString(ans); //ans를 문자열로 바꾸기
        int[] count = new int[10]; //0~9까지 숫자 셀 배열

        for(int i=0; i<multiply.length(); i++){ //문자열 만큼 반복
            count[multiply.charAt(i)-'0']++; //해당 숫자 인덱스에 +1
        }

        for(int i=0; i<10; i++){ //0~9까지 반복
            System.out.println(count[i]); //배열 수 모두 출력
        }
    }
}