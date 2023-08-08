import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] nums = new int[100]; // 점수 입력받을 배열
		
		//테스트 케이스 만큼 반복
		for(int t=0; t<10; t++) {
			int n = sc.nextInt(); //덤프횟수 입력받기
			
			for(int i=0; i<100; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			for(int i=0; i<n; i++) {
				if(nums[99]-nums[0]!=0) {
				nums[99] -= 1;
				nums[0] +=1;
				Arrays.sort(nums);
				} else {
					break;
				}
			}
			System.out.printf("#%d %d\n",t+1,nums[99]-nums[0]);
		}
	}
}