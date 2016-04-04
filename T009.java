package com.blyang;

public class T009 {

    public boolean isPalindrome(int x) {
    	if (x < 0){
    		return false;
    	}
			
		// initialize how many zeros
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}
 
		while (x != 0) {
			int left = x / div;
			int right = x % 10;
 
			if (left != right)
				return false;
 
			//左右两边各删除一个数字
			x = (x % div) / 10;
			
			//步长缩小100
			div /= 100;
		}
 
		return true;
    }
    
    public static void main(String[] args) {
		T009 t = new T009();
		System.out.println(t.isPalindrome(999));
		System.out.println(t.isPalindrome(123));
	}
	
}
