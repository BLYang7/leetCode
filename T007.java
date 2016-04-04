package com.blyang;

/**
 * 数字反转:
 * 		1、方法传参是个int类型，所以肯定不会越界
 * 		2、翻转后可能就要越界，注意越界的处理，当越界之后，返回0
 * 		3、注意数字的zheng fu
 */

public class T007 {

    public static int reverse(int x) {
    	
    	long result = 0;
    	long temp = Math.abs(x);
    	
    	while(temp > 0){
    		result = result * 10 + temp%10;
    		temp = temp/10;
    		
    		if(result > Integer.MAX_VALUE){
        		return 0;
        	}
    	}

    	result = (x > 0) ? result : -result;
    
        return (int) result;
    }
	
    public static void main(String[] args) {
		System.out.println( reverse(-2147483648) );
	}
    
}
