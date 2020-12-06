import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class p11004 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        long[] A = new long[n];
        str = bf.readLine().split(" ");
        for(int i=0; i<n; i++){
            A[i] = Long.parseLong(str[i]);
        }
        quickSort(A, 0, n-1, k-1);
        System.out.println(A[k-1]);
    }
    
    public static int partition(long[] arr, int left, int right){
        int mid = (left+right)/2;
        long pivot = arr[mid];
        int low = left;
        int high = right;
        
        while(low <= high){
            while(arr[low] < pivot) low++;
            while(arr[high] > pivot) high--;
            
            if(low <= high){
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        
        return low;//오른쪽 파티션의 시작점 반환
    }
    
    public static void quickSort(long[] arr, int left, int right, int order){
        int part2 = partition(arr, left, right);
        
        if(part2 > order && left < part2-1)//왼쪽 끝과 오른쪽 파티션의 차이가 1보다 크게 나면, 왼쪽 파티션 정렬 (왼쪽 파티션에 숫자가 있다는 소리)
            quickSort(arr, left, part2-1, order);
        if(part2 <= order && part2 < right)//오른쪽끝보다 오른쪽 파티션 시작점이 작으면, 오른쪽 파티션 정렬(오른쪽파티션에 숫자가 있다는 소리)
            quickSort(arr, part2, right, order);
    }
    
    public static void swap(long[] arr, int a, int b){
        long temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

