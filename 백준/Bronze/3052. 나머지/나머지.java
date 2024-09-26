
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> remainList = new ArrayList<>();
        for(int t = 0; t<10; t++){ //10개의 수 받기 반복
            int num = Integer.parseInt(br.readLine()); //수 입력
            int remain = num%42; //42로 나눈 나머지
            if(remainList.size()!=0){ //첫번째 수가 아니라면
                int same = 0; //이전까지 같은 나머지가 있는지 확인하는 변수 (있으면1 없으면0)
                for(int i=0; i<remainList.size(); i++){ //이전까지 저장한 나머지만큼 반복
                    if(remain == remainList.get(i)){ //이전까지 나온 나머지와 현재 나머지가 같으면
                        same = 1; //나머지가 있다고 바꾸기
                        break; //반복문 중지
                    }
                }
                if(same==0){ //같은 나머지가 없었다면
                    remainList.add(remain); //새로운 나머지 추가저장
                }
            }else{ //첫번째 수라면
                remainList.add(remain); //무조건 나머지 저장
            }
        }
        System.out.println(remainList.size()); //전체 나머지 개수 출력

    }
}