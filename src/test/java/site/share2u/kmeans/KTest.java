package site.share2u.kmeans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.Test;

public class KTest {
	@Test
	public void test1() throws Exception {
		// 初始化一个Kmean对象，将k置为10
		Kmeans k = new Kmeans(3);
		ArrayList<float[]> dataSet = new ArrayList<float[]>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("e:/iris.data")));
		String s =null;
		String[] split;
		while((s=bufferedReader.readLine()) != null){
			split = s.split(",");
			float[] f =new float[split.length];
			for (int i = 0; i < split.length-1; i++) {
				f[i]=Float.parseFloat(split[i]);
			}
			dataSet.add(f);
		}
		
		// 设置原始数据集
		k.setDataSet(dataSet);
		// 执行算法
		k.execute();
		// 得到聚类结果
		ArrayList<ArrayList<float[]>> cluster = k.getCluster();
		
		
		// 查看结果
		for (int i = 0; i < cluster.size(); i++) {
			k.printDataArray(cluster.get(i), "cluster[" + i + "]");
		}

	}
	@Test
	public void test12(){
		 int[] a = {45,67,33,21};
	      //  System.out.println(getMaxSumSeq(a));
	       System.out.println( findKBySort(a,2));
	}


	    
	    public int  getMaxSumSeq(int[] a){
	        int rmax = Integer.MIN_VALUE;
	        int sum = Integer.MIN_VALUE;
	        int start = -1;
	        int end = -1;
	        int temp = -1;
	        for(int i = 0 ;i<a.length;i++){
	            if(sum>0){
	                sum+=a[i];
	            }else{
	                sum = a[i];
	                temp = i;
	            }
	            if(sum>rmax){
	                start = temp;
	                rmax= sum;
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
