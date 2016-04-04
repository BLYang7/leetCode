package com.blyang;

public class T004 {
	
	private int findKthSortedArrays(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k){
		
		int m = aEnd - aStart; // length of A
		int n = bEnd - bStart; // length of B
		
		// A must be longer
		if (m < n) {  
            return findKthSortedArrays(B, bStart, bEnd, A, aStart, aEnd, k);  
        }
        
		//if smaller is 0
        if (n == 0){
        	return A[aStart + k - 1];  
        }
         
        //if find the 1'st number
        if (k == 1){
        	return Math.min(A[aStart], B[bStart]);
        }
  
        // new start. 二分法
        int pb = Math.min(k / 2, n);
        int pa = k - pb; 
        
        //新的二分首端的大小，来决定删除那些数据
        if (A[aStart + pa - 1] > B[bStart + pb - 1]){
        	return findKthSortedArrays(A, aStart, aEnd, B, bStart + pb, bEnd, k - pb);  
        }
        else if (A[aStart + pa - 1] < B[bStart + pb - 1]){
        	return findKthSortedArrays(A, aStart + pa, aEnd, B, bStart, bEnd, k - pa); 
        }
        //如果两者相等了，那直接返回第K个值即可
        else{
        	return A[aStart + pa - 1];  
        }
	}
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	
    	int m = nums1.length;
    	int n = nums2.length;
    	
    	if ((n + m) % 2 == 1) {
    		return findKthSortedArrays(nums1, 0, m, nums2, 0, n, (n + m) / 2 + 1); 
    	}
        else {
        	return ( findKthSortedArrays(nums1, 0, m, nums2, 0, n, (n + m) / 2 + 1) +  
                    findKthSortedArrays(nums1, 0, m, nums2, 0, n, (n + m) / 2) ) / 2.0;
        } 
    }
    
    public static void main(String[] args) {
    	T004 t = new T004();
    	int[] A = {1,2,3,4,5};
    	int[] B = {6,7,8,9};
		System.out.println(t.findMedianSortedArrays(A, B));
	}
    
}






