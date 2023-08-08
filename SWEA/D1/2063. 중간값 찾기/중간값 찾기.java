import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //점수 개수 입력받기
		int[] nums = new int[n]; // 점수 입력받을 배열
		int mid = n/2+1; //총 점수 중 중간 점수 번째
		
		//점수 입력받기
		for(int i=0; i<n; i++)
			nums[i] = sc.nextInt();
		
		//선택정렬을 이용하여 중간값 까지만 정렬
		for(int i=0; i<=mid; i++) {
			int minIdx = i; //배열 중 최솟값 저장할 인덱스(앞쪽부터 작은 수 저장)
			//i오른쪽 숫자들과 i를 비교하여 더 작은값 찾기
			for(int j= i+1; j<n; j++) {
				if(nums[j] < nums[minIdx]) {
					minIdx=j;
				}
			}//최솟값 파악 후 왼쪽부터 저장
			int tmp = nums[i];
			nums[i] = nums[minIdx];
			nums[minIdx] = tmp;
		}
		System.out.println(nums[mid-1]); //mid는 점수 순서 이므로 인덱스로 쓸때 -1 필요
	}
}