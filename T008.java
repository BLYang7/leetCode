package com.blyang;

/**
 * 字符串转数字：
 * 		1、判断是否为空，或者为“”， 如此，则返回0
 * 		2、去除字符串两端的空格
 * 		3、判断正负
 * 		4、单个字符的判断
 * 		5、处理数组越界，当处在最大最小字符的时候，返回最大或最小
 * @author blyang
 *
 */



public class T008 {
	
	private int myAtoi(String str){
		if (str == null || str.length() < 1)
			return 0;
	 
		// trim white spaces
		str = str.trim();
	 
		char flag = '+';
	 
		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;
	 
		// calculate value
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
	 
		if (flag == '-')
			result = -result;
	 
		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
	 
		return (int) result;
	}

}
