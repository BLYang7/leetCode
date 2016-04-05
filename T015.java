package com.blyang;
/**
 * 寻找三个数字相加为零的所有数
 * 
 * 枚举一个值，设置两个指针，left和right
 * 三个数相加，小于零时，left指针左移。大于零时，right指针右移
 */
import java.util.ArrayList;
import java.util.List;

public class T015 {
	
	//输出结果的全局变量
	List<List<Integer>> resList = new ArrayList<List<Integer>> ();
	
	//冒泡排序
    private int[] sort(int[] nums){
    	for(int i=0; i<nums.length-1; i++){
    		for(int j=0; j<nums.length-i-1; j++){
    			if(nums[j] > nums[j+1]){
    				int temp = nums[j];
    				nums[j] = nums[j+1];
    				nums[j+1] = temp;
    			}
    		}
    	}
    	return nums;
    }
    
    //寻找三个数相加为零
    private void find(int[] nums, int start, int end, int target){
    	int left = start;
    	int right = end;
    	while(left < right){
    		if (nums[left] + nums[right] + target == 0) {  
                List<Integer> ans = new ArrayList<Integer>();  
                ans.add(target);  
                ans.add(nums[left]);  
                ans.add(nums[right]);  
                resList.add(ans); //放入结果集中  
                
                while (left < right && nums[left] == nums[left+1]){
                	left++;  
                }
                while (left < right && nums[right] == nums[right-1]){
                	right--;  
                }
                left++;  
                right--;  
            } else if (nums[left] + nums[right] + target < 0) {  
                left++;  
            } else {  
                right--;  
            }  
    	}
    }
    
    //具体的寻找方法
    public List<List<Integer>> threeSum(int[] nums) {
    	
        if(nums.length < 3 || nums == null){
        	return resList;
        }
        
        nums = sort(nums);
        int len = nums.length;

        for(int i=0; i< len-2; i++){
        	if (i > 0 && nums[i] == nums[i-1]){
        		continue;  
        	}
            find(nums, i+1, len-1, nums[i]); //寻找两个数与num[i]的和为0
        }

        return resList;
    }
    

    
    public static void main(String[] args) {
		int[] numArr = new int[]{-2,-1,-3,0,1,2,3};
		
		T015 t = new T015();

		System.out.println(t.threeSum(numArr));
		
	}
    
}
