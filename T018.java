package com.blyang;
/**
 * 4Sum, 求一个数组中任意四个数相加为target值
 *
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class T018 {
	
// 方法一
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//    	
//
//    	//给数组排序
//    	Arrays.sort(nums);
//    	 
//    	HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
//    	List<List<Integer>> resList = new ArrayList<List<Integer>>();
//     
//    	if(nums.length < 4 || nums == null){
//    		return resList;
//    	}
//    	
//    	for (int i = 0; i < nums.length-3; i++) {
//    		for (int j = i + 1; j < nums.length-2; j++) {
//    			
//    			int left = j + 1;  //左指针
//    			int right = nums.length - 1;  //右指针
//     
//    			while (left < right) {
//    				int sum = nums[i] + nums[j] + nums[left] + nums[right];
//     
//    				if (sum > target) {
//    					right--;
//    				} else if (sum < target) {
//    					left++;
//    				} else if (sum == target) {
//    					ArrayList<Integer> temp = new ArrayList<Integer>();
//    					temp.add(nums[i]);
//    					temp.add(nums[j]);
//    					temp.add(nums[left]);
//    					temp.add(nums[right]);
//     
//    					if ( ! hashSet.contains(temp)) {
//    						hashSet.add(temp);
//    						resList.add(temp);
//    					}
//     
//    					right--;
//    					left++;
//    				}
//    			}
//    		}
//    	}
//     
//    	return resList;
//    }
    
	
	
	//方法二
	private List<List<Integer>> resList = new ArrayList<List<Integer>>();
	HashSet<List<Integer>> hashSet = new HashSet<List<Integer>>();
	
	private void threeSum(int[] nums, int current, int target){
		
		int start = current + 1;
		
		for(int i=start; i<nums.length-2; i++){
		    
			if(i>current+1 && nums[i] == nums[i-1]){
				continue;
			}
			
			int left = i+1;
			int right = nums.length-1;
			
			while(left < right){
			    
				int temp = nums[i] + nums[left] + nums[right];
				if(temp == target){
					List<Integer> listTemp = new ArrayList<Integer>();
					listTemp.add(nums[current]);
					listTemp.add(nums[i]);
					listTemp.add(nums[left]);
					listTemp.add(nums[right]);
					left++;
					right--;
					
					if( ! hashSet.contains(listTemp)){
						resList.add(listTemp);
						hashSet.add(listTemp);
					}
					
					
				} 
				
				else if(temp < target){
					left ++;
				}
				else if(temp > target){
					right --;
				}
			}
		}
	}
	
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	
    	if( nums == null || nums.length < 4 ){
    		return resList;
    	}
    	
    	Arrays.sort(nums);
    	
    	for(int i=0; i<nums.length-3; i++){
    	    if(i>0 && nums[i] == nums[i-1]){
    	        continue;
    	    }
    		threeSum(nums, i, target-nums[i]);
    	}
    	
        return resList;
    }
    
    public static void main(String[] args) {
		T018 t = new T018();
				
		int[] nums = new int[]{0,0,0,0};
		System.out.println(t.fourSum(nums, 0));
	}
    
}
