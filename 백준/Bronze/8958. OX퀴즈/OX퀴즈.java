import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
        for(int t=0; t<T; t++){  //테스트 케이스 만큼 반복
            String ans = br.readLine(); //ox퀴즈 결과 입력
            int result = 0; //총 점수 저장하는 변수
            int score = 1;  //연속 점수 저장하는 변수(연속하며 맞출수록 1씩 증가)
           
            for(int i=0; i<ans.length(); i++){   //문제수 만큼 반복
                    if(ans.charAt(i)=='O'){ //문제를 맞췄으면
                        result+=score++; //총 점수에 score 추가 후 1증가
                    }else{ //문제 틀렸을때
                        score=1; //score 1점으로 초기화
                    }
            }
            System.out.println(result); //출력
        }


    }
}