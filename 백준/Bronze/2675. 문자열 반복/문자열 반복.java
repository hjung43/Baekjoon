import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트케이스 개수
        for(int t = 0; t<T; t++){ //테케만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine()); //반복횟수, 문자열 입력 후 나누기
            StringBuilder sb = new StringBuilder(); //결과 문자열 저장할 변수
            int n = Integer.parseInt(st.nextToken()); //반복횟수
            String code = st.nextToken(); //주어진 문자열
            for(int i=0; i<code.length(); i++){ //문자열 길이 만큼 반복
                for(int j=0; j<n; j++){ //반복횟수만큼 문자 stringbuilder에 반복저장
                    sb.append(code.charAt(i));
                }
            }
            System.out.println(sb); //출력
        }

    }
}