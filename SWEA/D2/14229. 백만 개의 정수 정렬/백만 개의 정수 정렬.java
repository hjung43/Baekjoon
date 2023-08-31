import java.util.Scanner;

public class Solution {
	public static int[]arr = new int[1000000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<1000000; i++) {
			arr[i] = sc.nextInt();
		}
		quickSort(0,1000000-1);
		System.out.println(arr[500000]);
	}
	public static void quickSort(int L, int R) {
		if(L<R) {
			int pivot = lomuto(L,R);
			quickSort(L,pivot-1);
			quickSort(pivot+1,R);
		}
	}
	public static int lomuto (int L,int R) {
		int pivot = arr[R];
		int i = L-1;
		
		for(int j=L; j<R; j++) {
			if(arr[j]<=pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		int tmp = arr[i+1];
		arr[i+1] = arr[R];
		arr[R] = tmp;
		return i+1;
	}

}