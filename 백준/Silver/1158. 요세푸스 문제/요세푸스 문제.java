import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //n입력
        int k = Integer.parseInt(st.nextToken()); //k입력
        StringBuilder sb = new StringBuilder(); //정답 저장할 sb
        sb.append("<"); //정답 시작 괄호문
        LinkedList<Integer>list = new LinkedList<>(); //사람 번호 넣을 리스트
        //리스트에 사람넣기 (0~n까지 n인덱스에 n번 사람 넣기, 0인덱스는 안쓸거임)
        for(int i=0; i<n+1; i++){
            list.add(i);
        }
        
        int idx = 0; //제거할 사람 인덱스
        //사람수만큼 반복
        for(int i=0; i<n; i++) {
            int nIdx = idx + k; //현재 제거할 사람 인덱스
            //인덱스 수가 남은 사람수(리스트크기-1(인덱스0빼는거)보다 크면 사람수보다 작아질때 까지 인덱스-사람수
            while (nIdx > (list.size() - 1)) {
                nIdx -= (list.size() - 1);
            }
            sb.append(list.get(nIdx)); //제거할 사람 sb에 저장
            //마지막 괄호 닫을 if문
            if(i<n-1)
                sb.append(", ");
            else
                sb.append(">");
            list.remove(nIdx); //현재 인덱스 사람 제거
            idx = nIdx - 1; //사람 삭제했으니까 인덱스 -1
        }

        System.out.println(sb); //정답출력


    }
}