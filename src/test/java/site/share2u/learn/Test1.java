package site.share2u.learn;

import org.junit.Test;

import edu.emory.mathcs.backport.java.util.Arrays;

public class Test1 {
	@Test
	public void test11(){
		int[] a={4,-3,5,-2,-1,2,6,-2};
		System.out.println(maxSubSum4(a));
	}
	
	public int maxSubSum1(int[] a){
		int maxSum=0;
		for (int i = 0; i < a.length; i++) {//4,-3,5,-2,-1,2,6,-2
			for (int j = i; j < a.length; j++) {
				int thisSum = 0;//要归零
				for (int z = i; z <= j; z++) {//这个for循环是从j位置开始的任意子串
					thisSum +=a[z];//某一位置到后面的任意j位置
				}
				System.out.println("thisSum:"+thisSum);
				if(thisSum>maxSum){
					System.out.println("maxSum:"+thisSum);
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	/**
	 * i-j的子串和，1方法被过度计算，两个for循环已经知道了i和j的位置了
	 */
	public int maxSubSum2(int[] a){
		int maxSum=0;
		for (int i = 0; i < a.length; i++) {//4,-3,5,-2,-1,2,6,-2
			int thisSum = 0;
			for (int j = i; j < a.length; j++) {
				thisSum += a[j];// 某一i位置到后面的任意j位置
				System.out.println("thisSum:" + thisSum);
				if (thisSum > maxSum) {
					System.out.println("maxSum:" + thisSum);
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	/**
	 * 分治的方法求最大子串
	 * tn=2t(n/2)+n
	 * 时间复杂度nlog(n)
	 */
	public int maxSubSum3(int[] a){
		return maxSub(a, 0, a.length-1);
	}
	private int maxSub(int[] a,int left,int right){
		if(left == right){
			if(a[left]>0){
				return a[left];
			}
			return 0;
		}
		int center = (left+right)/2;
		int maxLeftSum = maxSub(a, left, center);//N/2的时间
		int maxRightSum = maxSub(a, center+1, right);
		//横跨两边的最大zhi
		//中间到left的最大值
		int maxLeftBoardSum=0,leftBoardSum=0;
		for(int i =center;i>= left;i--){
			leftBoardSum +=a[i];
			if(leftBoardSum > maxLeftBoardSum){
				maxLeftBoardSum = leftBoardSum;
			}
		}
		//中间到reght的最大值
		int maxRightBoardSum=0,rightBoardSum=0;
		for(int i =center+1;i<= right;i++){//center的初始化
			rightBoardSum +=a[i];
			if(rightBoardSum > maxRightBoardSum){
				maxRightBoardSum = rightBoardSum;
			}
		}
		return maxArray(new int[]{maxLeftSum,maxRightSum,maxLeftBoardSum+maxRightBoardSum});
	}
	
	
	/**
	 * 联机算法
	 * 
	 */
	public int maxSubSum4(int[] a){
		int maxSum =0,thisSum=0;
		for (int i = 0; i < a.length; i++) {
			thisSum +=a[i];
			if(thisSum>maxSum){
				maxSum = thisSum;
			}else if(thisSum < 0){
				thisSum = 0;//如果之前的值小于o的话，直接舍弃
			}
		}
		return maxSum;
	}
	
	
	private int maxArray(int[] a){
		int max =a[0];
		for (int i = 1; i < a.length; i++) {
			if(a[i]>max)max=a[i];
		}
		return max;
	}
	
	@Test
	public void testPow(){
		System.out.println(pow(2,10));
	}
	public long pow(long x,int n){
		if(n==0)return 1;
		if(n==1)return x;
		if(isEven(n)){
			return pow(x*x,n/2);
		}else{
			return  pow(x*x,n/2)*x;
		}
	}

	private boolean isEven(long x) {
		return x%2==0;
	}
	
}
