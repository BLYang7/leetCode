package com.blyang;
/**
 * 去除数组中和给定的value重复的数，返回新的数组的长度
 */
public class T027 {
	
    public int removeElement(int[] nums, int val) {
        if(nums.length < 1){
            return nums.length;
        }
       int newIndex = 0;  
        for (int oldIndex = 0; oldIndex < nums.length; ++oldIndex) {  
            if (nums[oldIndex] != val) {  
                nums[newIndex++] = nums[oldIndex];  
            }   
        }  
        return newIndex;  
    }
    
    public static void main(String[] args) {
		T027 t = new T027();
		int[] nums = new int[]{2,2,3};
		System.out.println(t.removeElement(nums, 2));
	}
    
}
