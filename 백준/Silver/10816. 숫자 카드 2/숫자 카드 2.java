import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            cards[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(cards,key)-lowerBound(cards, key)).append(" ");
        }
        System.out.println(sb);
    }
    public static int upperBound(int[] arr, int key){
        int left = 0;
        int right = arr.length;
        while(left<right){
            int mid = (left + right)/2;
            if(key<arr[mid]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    public static int lowerBound(int[] arr, int key){
        int left = 0;
        int right = arr.length;
        while(left<right){
            int mid = (left+right)/2;
            if(key<=arr[mid]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}
