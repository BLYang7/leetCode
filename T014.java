package com.blyang;
/**
 * 寻找一个字符数组中所有字符串的最长公共前缀，也就是所有字符串中共同的那部分
 * 
 */

public class T014 {

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}

		String prefix = strs[0];
		for (int i = 1; i < strs.length; ++i) {
			if (prefix.length() == 0 || strs[i].length() == 0){
				return "";
			}
			
			int len = prefix.length() < strs[i].length() ? prefix.length() : strs[i].length();
			int j;

			for (j = 0; j < len; ++j) {
				if (prefix.charAt(j) != strs[i].charAt(j)){
					break;
				}
			}
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}
	
	public static void main(String[] args) {
		T014 t = new T014();
		String[] strs = {
				"my name is 000",
				"my name is 011",
				"my name is 010",
				"my name is 010",
				"my name is 011",
		};
		System.out.println(t.longestCommonPrefix(strs));
	}

}
