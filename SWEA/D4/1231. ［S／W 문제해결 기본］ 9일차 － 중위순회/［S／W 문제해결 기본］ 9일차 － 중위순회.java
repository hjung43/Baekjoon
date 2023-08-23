import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static String []arr; //글자 담을 배열 선언
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 수 만큼 반복
        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(bf.readLine());  //정점의 총 수(노드의 총 수)
            arr = new String[n+1]; //정점의 총 수 +1 로 배열 크기 설정
            //배열에 글자 입력받기
            for (int i=0; i<n; i++) {
            	String s = bf.readLine();//한줄 입력
            	StringTokenizer st = new StringTokenizer(s);
            	int idx = Integer.parseInt(st.nextToken()); //첫번째 토큰 = 인덱스 (완전이진트리이기 때문)
            	String al = st.nextToken(); //두번째 토큰 글씨 저장
            	arr[idx] = al; //첫번재 토큰값의 인덱스에 두번째 토큰 저장
            }
            //결과값 출력
            System.out.print("#"+t+" ");
            inOrder(1); //이진트리 중위순회 함수 사용 (인덱스1부터니까 매개변수로 1넣기)
            System.out.println();
        }
    }
    //완전이진트리 중위순회
    public static void inOrder (int i) {  //i는 현재 탐색할 노드의 번호
    	if(i<arr.length) { //i가 총 노드 수 보다 작을 때 
    		inOrder(i*2); //왼쪽 자식 노드 탐색
    		System.out.print(arr[i]); //본인 노드 출력(완전이진트리라 빈 칸이 없기때문에 그냥 출력)
    		inOrder(i*2+1); //오른쪽 자식 노드 탐색
    	}else //범위에서 벗어나면
    		return; //리턴
    }
}