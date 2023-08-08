import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트 케이스 입력받기

		int[] nums = new int[1000]; // 점수 입력받을 배열
		
		//테스트 케이스 만큼 반복
		for(int t=0; t<T; t++) {
			int n = sc.nextInt(); //테스트 케이스 번호 입력받기
			int mode = 0; //점수 중 최빈수 저장할 변수
			int c = 0; //최대 빈도값 저장 변수
			int[] count = new int[101]; //점수를 인덱스로 전환하여 점수의 개수 저장할 변수
			//점수 배열로 입력받고 count 배열로 점수의 빈도 파악하기
			for(int i=0; i<1000; i++) {
				nums[i] = sc.nextInt();
				count[nums[i]]++;
				//count[nums[i]]값이 최대빈도 값 보다 크면 최대 빈도 값과 최빈수 변경
				if(count[nums[i]]>c) {  
					c = count[nums[i]];
					mode = nums[i];
				//최빈수가 여러개 일때 더 큰 수를 최빈수에 저장하기
				}else if(count[nums[i]]==c && mode < nums[i])
					mode = nums[i];
				
			}
			System.out.printf("#%d %d\n",n,mode);
		}
	}
}