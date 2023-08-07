import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();  //테스트케이스 개수 받기
		
        //테스트케이스 만큼 반복
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int result = 0; //낙차값 저장 변수
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {  //배열 입력 받기
				nums[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				int b = 0; // 인덱스 i번째 상자보다 크거나 같은 상자 개수담는 변수
				for (int j = i + 1; j < n; j++) {
					if (nums[j] >= nums[i]) {  //인덱스i 상자와 크기가 같거나 큰 상자 찾기
						b++;  //인덱스i 번째 뒤로 i와 상자 크기와 같거나 큰 상자 개수
					}
				}
				if (n - i - b > result)
					result = n - (i + 1) - b; //낙차값 구하기
			}
			System.out.println("#"+(t+1)+" "+result);
		}
	}
}