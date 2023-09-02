import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static int[]arr;
    public static int[]sortArr;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(bf.readLine());
        arr = new int [n];
        sortArr = new int [n];
         
        for (int i = 0; i <n; i++) {
        	 int str = Integer.parseInt(bf.readLine());
            arr[i]=str;
        }
        mergeSort(0,n-1);
        for (int i = 0; i <n; i++) {
        	sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }
    public static void mergeSort(int left, int right) {
        if(left<right) {
            int mid = (left+right)/2;
            mergeSort(left,mid);
            mergeSort(mid+1,right);
            merge(left,mid,right);
        }
    }
    public static void merge(int left, int mid, int right) {
        int L = left;
        int R = mid+1;
        int idx = left;
        while(L<=mid && R<=right) {
            if(arr[L]<=arr[R]) {
                sortArr[idx++] = arr[L++];
            }else {
                sortArr[idx++] = arr[R++];
            }
        }
        if(L<=mid) {
            for(int i=L; i<=mid; i++) {
                sortArr[idx++]=arr[i];
            }
        }else {
            for(int i=R; i<=right; i++) {
                sortArr[idx++]=arr[i];
            }
        }
        
        for(int i=left; i<=right; i++) {
            arr[i] = sortArr[i];
        }
    }
}