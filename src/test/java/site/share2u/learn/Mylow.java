package site.share2u.learn;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public  class Mylow {
	
	public static void main(String[] args) {
		System.out.println(twoSum(new int[]{0,2,3,0},0));
	}

	 public static int[] twoSum(int[] nums, int target) {
	        int[] index = new int[2];
	        for(int i=0;i<nums.length;i++){
	            int sum=nums[i];
	            if(target<sum)continue;
	            index[0]=i;
	            for(int j=i+1;j<nums.length;j++){
	                sum +=nums[j];
	                System.out.println(i+"+"+j+"="+sum);
	                if(target == sum){
	                    index[1]=j;
	                    return index;
	                }else{
	                    sum -=nums[j];
	                    continue;
	                }
	            }
	        }
	    return index;
	    }
	}
