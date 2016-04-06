package com.blyang;
/**
 * 去除有序数组中的重复数，返回不重复的数字的个数
 * 
 * 这个题目有歧义，描述不准确，应该是返回这个个数N之后，当前这个数组中的前N个，就是全不重复的数字。
 */
public class T026 {
    public int removeDuplicates(int[] nums) {
    	
        if(nums.length < 2 || nums == null){
            return nums.length;
        }
    	
    	int start = 0;
    	
    	for(int i=1; i<nums.length; i++){
    		if(nums[start] != nums[i]){
    			nums[start + 1] = nums[i];
    			start ++;
    		}
    	}
    	
    	return ++start;
    }
    
    public static void main(String[] args) {
		T026 t = new T026();
    	int[] nums = new int[]{1,1,2};
		System.out.println(t.removeDuplicates(nums));
	}
    
}
