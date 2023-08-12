import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //동전 종류 개수 입력
		int k = sc.nextInt(); //동전을 통해 만들어야 되는 값
		 
		int[]money = new int[n]; //가지고 있는 동전을 담을 배열
		//배열에 가지고 있는 동전 종류 담기
		for(int i=0; i<n; i++) {
			money[i] = sc.nextInt();
		}
		int result = 0; //총 동전개수 저장할 변수
		//가지고 있는 동전 종류 중 가장 큰 수부터 몇개씩 사용할 수 있는지 확인
		for(int i=n-1; i>=0; i--) {
			if(k>=money[i]) { //만들어야 하는 값이 동전값 보다 크거나 같으면
				result =result + k/money[i];  //동전을 몇개 사용할 수 있는지 파악
				k=k%money[i]; //만들어야 하는 나머지값 저장
			}
		}
		System.out.println(result);
	}
}