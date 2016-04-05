package com.blyang;
/**
 * 三个数相加，寻找相加之后距离指定目标值最近的和
 * 枚举第一个数，然后设两个指针，在第一个数的后半段开始王中间收缩
 * if sum > target则右指针往左移， if sum < target则左指针往右移。
 */
import java.util.Arrays;

public class T016 {
	
	public int threeSumClosest(int[] nums, int target) {
		int min = Integer.MAX_VALUE;
		int result = 0;
	 
		Arrays.sort(nums);
	 
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				int diff = Math.abs(sum - target);
	 
				if(diff == 0){
					return sum;
				}
	 
				if (diff < min) {
					min = diff;
					result = sum;
				}
				
				if (sum <= target) {
					left++;
				} else {
					right--;
				}
				
			}
		}
	 
		return result;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{-3,-4,-2,1,2,3,4};
		T016 t = new T016();
		System.out.println(t.threeSumClosest(nums, 8));
	}
	
}
