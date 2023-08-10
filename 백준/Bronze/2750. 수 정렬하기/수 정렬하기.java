import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[]nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i]= sc.nextInt();
		}
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(nums[i]>nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j]=tmp;
				}
			}
		}
		for(int i : nums) {
			System.out.println(i);
		}
	}
}