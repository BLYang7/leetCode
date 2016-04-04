package com.blyang;

public class T001 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        
        int length = nums.length;
        for(int i=0; i<length-1; i++){
            for(int j=i+1; j<length; j++){
                if(target == (nums[i] + nums[j])){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        
        return result;
    }

	public static void main(String[] args) {

		int[] a = {1,2,3,4};
		T001 t1 = new T001();
		System.out.println( t1.twoSum(a, 6)[0] );
		System.out.println( t1.twoSum(a, 6)[1] );
	}

}
