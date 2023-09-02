import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	public static int n;
	public static int[]arr;
	public static int[]sortArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(str1);
		n = Integer.parseInt(st1.nextToken()); //n개 수 정렬
		int k = Integer.parseInt(st1.nextToken()); //k번째 수 찾기
		arr = new int[n];
		sortArr = new int[n];
		
		String str2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(str2);
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		mergeSort(0,n-1);
		System.out.println(arr[k-1]);
		
	}
	public static void mergeSort(int left, int right) {
		if(left<right) {
			int mid = (left+right)/2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left,mid,right);
		}
	}
	public static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid+1;
		int idx = left;
		
		while(L<=mid && R<=right) {
			if(arr[L] <= arr[R]) {
				sortArr[idx++] = arr[L++];
			}else {
				sortArr[idx++] = arr[R++];
			}
		}
		if(L<=mid) {
			for(int i=L; i<=mid; i++) {
				sortArr[idx++] = arr[i];
			}
		}else {
			for(int i=R; i<=right; i++) {
				sortArr[idx++] = arr[i];
			}
		}
		for(int i=left; i<=right; i++) {
			arr[i] = sortArr[i];
		}
	}
}