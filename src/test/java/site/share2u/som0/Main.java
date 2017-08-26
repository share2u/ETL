package site.share2u.som0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine1 = br.readLine();
		int k = Integer.parseInt(br.readLine());
		
		String[] split = readLine1.split(" ");
		int[] in = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			in[i]=Integer.parseInt(split[i]); 
		}
		System.out.println(findKBySort(in,k));
		
	}

	public static int getMaxSumSeq(int[] a) {
		int rmax = Integer.MIN_VALUE;
		int sum = Integer.MIN_VALUE;
		int start = -1;
		int end = -1;
		int temp = -1;
		for (int i = 0; i < a.length; i++) {
			if (sum > 0) {
				sum += a[i];
			} else {
				sum = a[i];
				temp = i;
			}
			if (sum > rmax) {
				start = temp;
				rmax = sum;
				end = i;
			}
		}
		return rmax;
	}
	
    public static int findKBySort(int[] nums, int K) {  
        quickSort(nums, 0, nums.length - 1, false);// 降序排序  
        return nums[K - 1];  
 }  


 public static void quickSort(int[] nums, int fromIndex, int toIndex,  
               boolean orient) {  
        if (nums == null || fromIndex >= toIndex)  
               return;  

        int temp = 0;  
        int mid = (fromIndex + toIndex) / 2;  
        int midNum = nums[mid];  
        int a = fromIndex, b = toIndex;  

        while (a < b) {  
               if (orient) {  
                      while (nums[a] <= midNum && a < mid) {  
                             a++;  
                      }  
                      while (nums[b] >= midNum && b > mid) {  
                             b--;  
                      }  
               } else {  
                      while (nums[a] >= midNum && a < mid) {  
                             a++;  
                      }  
                      while (nums[b] <= midNum && b > mid) {  
                             b--;  
                      }  
               }  
               if (a == mid) {  
                      mid = b;  
               } else if (b == mid) {  
                      mid = a;  
               }  

               temp = nums[a];  
               nums[a] = nums[b];  
               nums[b] = temp;  
        }  
        quickSort(nums, fromIndex, mid - 1, orient);  
        quickSort(nums, mid + 1, toIndex, orient);  
 }  

}
