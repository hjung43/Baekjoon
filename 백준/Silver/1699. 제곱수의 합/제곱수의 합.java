import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //입력값
        double sqrtN = Math.sqrt(n); //루트n값
        int[]dp = new int[n+1]; //dp배열(해당 인댁스의 제곱수 항의 최소개수 저장할 배열)

        //dp
        for(int i=1; i<n+1; i++){
            int min = Integer.MAX_VALUE; //제곱수 항의 최소개수 저장할 변수
            //루트n 이하로만 반복
            for(int j=1; j<=sqrtN; j++){
                //j의 제곱이 i보다 작거나 같고 i-j제곱의 dp값 +1이 min보다 작을때
                if(i>=j*j && dp[i-(j*j)]+1<min){
                        min = dp[i-(j*j)]+1; //최솟값 초기화
                }
            }
            dp[i] = min; //최소개수 저장

        }
        System.out.println(dp[n]);


    }
}