package com.blyang;

/**
 * 最长无重复子序列的长度
 *	
 */

public class T003 {

    public int lengthOfLongestSubstring(String s) {
    	
		int res = 0;
		int left = 0;
		int[] prev = new int[128];
		
		for(int i=0; i<128; i++){
			prev[i] = -1;
		}
		
		for(int i=0; i<s.length(); i++){
			if(prev[s.charAt(i)] >= left){
				left = prev[s.charAt(i)] + 1;
			}
			prev[s.charAt(i)] = i;
			
			if(res < i-left + 1){
				res = i-left + 1;
			}
		}
		
		return res;
    }
    
    
    public static void main(String[] args) {
		T003 t = new T003();
		
		System.out.println(t.lengthOfLongestSubstring("12345654321"));
		
	}
    
	
}
