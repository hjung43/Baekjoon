import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //카드개수 입력
        int[] cards = new int[n]; //카드 배열
        StringTokenizer st = new StringTokenizer(br.readLine()); //카드 숫자 읽기
        //카드 배열에 카드 숫자 넣기
        for(int i=0; i<n; i++){
            cards[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards); //카드배열 오름차순정렬

        int m = Integer.parseInt(br.readLine()); //찾아야할 수 갯수 입력
        st = new StringTokenizer(br.readLine()); //찾아야 할 수 읽기
        StringBuilder sb = new StringBuilder(); //정답 저장할 스트링빌더
        
        //찾아야 할 수 만큼 반복문 돌려서 찾아야 할 수 개수 찾기
        for(int i=0; i<m; i++){
            int key = Integer.parseInt(st.nextToken()); //칮아야 할 수
            //찾아야 할 수의 바로 오른쪽 인덱스 - 찾아야할 수 중 가장 작은 인덱스(결국 카드 갯수)저장 
            sb.append(upperBound(cards,key)-lowerBound(cards, key)).append(" ");
        }
        System.out.println(sb); //출력
    }
    //찾아야할 수의 바로 오른쪽 인덱스 찾기
    public static int upperBound(int[] arr, int key){
        //이분탐색을 위해 left =0, right = 배열의 가장끝 +1 로 설정
        int left = 0;
        int right = arr.length;
        //left와 right가 같아지면 멈추도록
        while(left<right){
            int mid = (left + right)/2; //(left+right /2)를 해서 가운데 값 찾기
            if(key<arr[mid]){ //가운데 값이 찾아야 할 수 보다 크면
                right = mid; //right 가운데 값으로 옮기기
            }else{ //가운데 값이 찾아야 할 수보다 작거나 같으면
                left = mid+1; //left = mid+1 해서 하나 오른쪽으로
            }
        }
        //다 돌고나면 right는 key값보다 하나 더 큰 자리에 멈추고 left가 계속 1씩 커지면서 결국 key값의 바로 오른쪽 인덱스에서 멈춤
        return left; //key값의 바로 오른쪽 인덱스 반환
    }
    //찾아야할 수의 가장 왼쪽 인덱스 찾기
    public static int lowerBound(int[] arr, int key){
        //이분탐색을 위해 left =0, right = 배열의 가장끝 +1 로 설정
        int left = 0;
        int right = arr.length;
        //left와 right가 같아지면 멈추도록
        while(left<right){
            int mid = (left+right)/2; //(left+right /2)를 해서 가운데 값 찾기
            if(key<=arr[mid]){ //가운데 값이 찾아야 할 수 보다 크거나 같으면 
                right = mid; //right 가운데 값으로 옮기기
            }else{ //가운데 값이 찾아야 할 수보다 작으면
                left = mid + 1; //left하나 오른쪽으로
            }
        }
        //다 돌고나면 right는 key값이랑 같은 카드중에 가장 왼쪽으로 이동해있고 left가 계속 1씩 커지만서 right랑 만남
        return right; //key랑 똑같은 카드 중에 가장 작은 인덱스 반환
    }
}
